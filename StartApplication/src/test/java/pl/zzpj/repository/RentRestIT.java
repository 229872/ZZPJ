package pl.zzpj.repository;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import pl.zzpj.repository.rest.dto.CreateRentDto;
import pl.zzpj.repository.rest.dto.input.CredentialsDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RentRestIT extends AbstractConfigIT {

    private final String adminJwt;
    private List<UUID> vehicleIds;
    private List<UUID> userIds;
    private static DateTimeFormatter format =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public RentRestIT(ServletWebServerApplicationContext webServerAppCtxt) {
        baseURI = String.format("http://localhost:%s/", webServerAppCtxt.getWebServer().getPort());
        RestAssured.requestSpecification =
                new RequestSpecBuilder()
                        .setContentType(ContentType.JSON)
                        .setAccept(ContentType.JSON)
                        .build();

        CredentialsDto credentialsDto = new CredentialsDto("admin", "Kochamzzpj!");

        adminJwt = given()
                .body(credentialsDto)
                .post(baseURI + "users/auth/authenticate")
                .then()
                .statusCode(200)
                .extract().asString();
        System.out.println(adminJwt);

        vehicleIds = given()
                .get(baseURI + "vehicles/getAll")
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("id", UUID.class);

        userIds = given()
                .header("Authorization", "Bearer " + adminJwt)
                .get(baseURI + "users")
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("clientId", UUID.class);
    }


    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Nested
    @Order(1)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class ReturnedGoodScenario {
        private static UUID rentId;
        
        @Test
        @Order(1)
        void createRent_correct() {
            CreateRentDto createRentDto = CreateRentDto.builder()
                    .userId(userIds.get(0))
                    .vehicleId(vehicleIds.get(0))
                    .declaredStart(LocalDateTime.now().plusMinutes(5))
                    .declaredEnd(LocalDateTime.now().plusDays(5))
                    .build();

            given()
                    .body(createRentDto)
                    .post(baseURI + "rents")
                    .then()
                    .statusCode(200);
        }

        @Test
        @Order(1)
        void calculatePrice_correct() {
            CreateRentDto createRentDto = CreateRentDto.builder()
                    .userId(userIds.get(0))
                    .vehicleId(vehicleIds.get(0))
                    .declaredStart(LocalDateTime.now().plusMinutes(5))
                    .declaredEnd(LocalDateTime.now().plusDays(5))
                    .build();

            given()
                    .body(createRentDto)
                    .post(baseURI + "rents/calculate")
                    .then()
                    .log().all()
                    .statusCode(200);
        }

        @Test
        @Order(2)
        void createRent_startAfterNow() {
            CreateRentDto createRentDto = CreateRentDto.builder()
                    .userId(userIds.get(0))
                    .vehicleId(vehicleIds.get(1))
                    .declaredStart(LocalDateTime.now().minusHours(2))
                    .declaredEnd(LocalDateTime.now().plusDays(5))
                    .build();

            given()
                    .body(createRentDto)
                    .post(baseURI + "rents")
                    .then()
                    .statusCode(400);
        }

        @Test
        @Order(2)
        void createRent_endBeforeStart() {
            CreateRentDto createRentDto = CreateRentDto.builder()
                    .userId(userIds.get(0))
                    .vehicleId(vehicleIds.get(1))
                    .declaredStart(LocalDateTime.now().plusDays(5))
                    .declaredEnd(LocalDateTime.now().plusMinutes(5))
                    .build();

            given()
                    .body(createRentDto)
                    .post(baseURI + "rents")
                    .then()
                    .statusCode(400);
        }

        @Test
        @Order(2)
        void createRent_userNotExists() {
            CreateRentDto createRentDto = CreateRentDto.builder()
                    .userId(UUID.randomUUID())
                    .vehicleId(vehicleIds.get(1))
                    .declaredStart(LocalDateTime.now().plusDays(5))
                    .declaredEnd(LocalDateTime.now().plusMinutes(5))
                    .build();

            given()
                    .body(createRentDto)
                    .post(baseURI + "rents")
                    .then()
                    .statusCode(404);
        }

        @Test
        @Order(2)
        void findAllRents_correct() {
            List<UUID> rents = given().get(baseURI + "rents")
                    .then()
                    .statusCode(200)
                    .extract().jsonPath().getList("id", UUID.class);
            Assertions.assertEquals(1, rents.size());
            rentId = rents.get(0);
            System.out.println(rentId);
        }

        @Test
        @Order(2)
        void findUsersRent_correct() {
            given().get(baseURI + "rents/user/" + userIds.get(0))
                    .then()
                    .statusCode(200)
                    .body("$", hasSize(1));
        }

        @Test
        @Order(2)
        void findUsersRent_noSuchUser() {
            given().get(baseURI + "rents/user/" + UUID.randomUUID())
                    .then()
                                        .statusCode(200)
                    .body("$", hasSize(0));
        }

        @Test
        @Order(2)
        void findFutureVehicleRent_correct() {
            given().get(baseURI + "rents/vehicle/" + vehicleIds.get(0))
                    .then()
                    .statusCode(200)
                    .body("$", hasSize(1));
        }

        @Test
        @Order(2)
        void findAllVehicleRent_correct() {
            given().get(baseURI + "rents/vehicle/" + vehicleIds.get(0) + "/all")
                    .then()
                    .statusCode(200)
                    .body("$", hasSize(1));
        }

        @Test
        @Order(2)
        void findRentsByStatus_created_correct() {
            given().get(baseURI + "rents/status/CREATED")
                    .then()
                    .statusCode(200)
                    .body("$", hasSize(1));
        }

        @Test
        @Order(2)
        void findRentsByStatus_badStatus() {
            given().get(baseURI + "rents/status/BAD")
                    .then()
                                        .statusCode(400);
        }

        @Test
        @Order(2)
        void findRentsToIssue_correct() {
            String date = LocalDateTime.now().plusDays(6).format(format);
            given()
                    .get(baseURI + "rents/to-issue/" + date)
                    .then()
                    .statusCode(200)
                    .body("$", hasSize(1));
        }

        @Test
        @Order(2)
        void findRentsToIssue_incorrectDate() {
            given()
                    .get(baseURI + "rents/to-issue/55")
                    .then()
                                        .statusCode(400);
        }

        @Test
        @Order(3)
        void findRent_correct() {
            given().get(baseURI + "rents/" + rentId.toString())
                    .then()
                    .statusCode(200);
        }

        @Test
        @Order(3)
        void findRent_noSuchRent() {
            given().get(baseURI + "rents/" + UUID.randomUUID())
                    .then()
                    .statusCode(404);
        }

        @Test
        @Order(3)
        void issueVehicle_correct() {
            given().put(baseURI + "rents/issue/" + rentId.toString())
                    .then()
                    .statusCode(200);
        }

        @Test
        @Order(3)
        void issueVehicle_noSuchRent() {
            given().put(baseURI + "rents/issue/" + UUID.randomUUID())
                    .then()
                    .statusCode(404);
        }

        @Test
        @Order(4)
        void findRentsByStatus_issued_correct() {
            given().get(baseURI + "rents/status/CREATED")
                    .then()
                    .statusCode(200)
                    .body("$", hasSize(0));

            given().get(baseURI + "rents/status/ISSUED")
                    .then()
                    .statusCode(200)
                    .body("$", hasSize(1));
        }

        @Test
        @Order(5)
        void returnVehicle_correct() {
            given().put(baseURI + "rents/return/" + rentId.toString())
                    .then()
                    .statusCode(200);
        }

        @Test
        @Order(6)
        void returnVehicle_alreadyReturned() {
            given().put(baseURI + "rents/return/" + rentId.toString())
                    .then()
                    .statusCode(400);
        }

        @Test
        @Order(6)
        void findRentsByStatus_returned_correct() {
            given().get(baseURI + "rents/status/CREATED")
                    .then()
                    .statusCode(200)
                    .body("$", hasSize(0));

            given().get(baseURI + "rents/status/ISSUED")
                    .then()
                    .statusCode(200)
                    .body("$", hasSize(0));

            given().get(baseURI + "rents/status/RETURNED_GOOD")
                    .then()
                    .statusCode(200)
                    .body("$", hasSize(1));
        }
    }

    @Nested
    @Order(2)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class ReturnedDamagedScenario {

        private static UUID rentId;

        @Test
        @Order(1)
        void createRent_correct() throws InterruptedException {
            CreateRentDto createRentDto = CreateRentDto.builder()
                    .userId(userIds.get(0))
                    .vehicleId(vehicleIds.get(1))
                    .declaredStart(LocalDateTime.now().plusSeconds(3))
                    .declaredEnd(LocalDateTime.now().plusHours(12))
                    .build();

            given()
                    .body(createRentDto)
                    .post(baseURI + "rents")
                    .then()
                    .statusCode(200);
            TimeUnit.SECONDS.sleep(3);
        }

        @Test
        @Order(2)
        void findRentsByStatus_created_correct() {
            List<UUID> rents = given().get(baseURI + "rents/status/CREATED")
                    .then()
                    .statusCode(200)
                    .extract().jsonPath().getList("id", UUID.class);
            Assertions.assertEquals(1, rents.size());
            rentId = rents.get(0);
        }

        @Test
        @Order(3)
        void issueVehicle_correct() {
            given().put(baseURI + "rents/issue/" + rentId.toString())
                    .then()
                    .statusCode(200);
        }

        @Test
        @Order(5)
        void returnDamagedVehicle_correct() {
            given().put(baseURI + "rents/return-damaged/" + rentId.toString())
                    .then()
                                        .statusCode(200);
        }

        @Test
        @Order(6)
        void findRentsByStatus_returned_correct() {
            given().get(baseURI + "rents/status/CREATED")
                    .then()
                    .statusCode(200)
                    .body("$", hasSize(0));

            given().get(baseURI + "rents/status/ISSUED")
                    .then()
                    .statusCode(200)
                    .body("$", hasSize(0));

            given().get(baseURI + "rents/status/RETURNED_DAMAGED")
                    .then()
                    .statusCode(200)
                    .body("$", hasSize(1));
        }
    }

    @Nested
    @Order(3)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class ReturnedMissingScenario {

        private static UUID rentId;

        @Test
        @Order(1)
        void createRent_correct() throws InterruptedException {
            CreateRentDto createRentDto = CreateRentDto.builder()
                    .userId(userIds.get(0))
                    .vehicleId(vehicleIds.get(2))
                    .declaredStart(LocalDateTime.now().plusSeconds(3))
                    .declaredEnd(LocalDateTime.now().plusHours(12))
                    .build();

            given()
                    .body(createRentDto)
                    .post(baseURI + "rents")
                    .then()
                    .statusCode(200);
            TimeUnit.SECONDS.sleep(3);
        }

        @Test
        @Order(2)
        void findRentsByStatus_created_correct() {
            List<UUID> rents = given().get(baseURI + "rents/status/CREATED")
                    .then()
                    .statusCode(200)
                    .extract().jsonPath().getList("id", UUID.class);
            Assertions.assertEquals(1, rents.size());
            rentId = rents.get(0);
        }

        @Test
        @Order(3)
        void issueVehicle_correct() {
            given().put(baseURI + "rents/issue/" + rentId.toString())
                    .then()
                    .statusCode(200);
        }

        @Test
        @Order(5)
        void returnDamagedVehicle_correct() {
            given().put(baseURI + "rents/return-missing/" + rentId.toString())
                    .then()
                    .statusCode(200);
        }

        @Test
        @Order(6)
        void findRentsByStatus_returned_correct() {
            given().get(baseURI + "rents/status/CREATED")
                    .then()
                    .statusCode(200)
                    .body("$", hasSize(0));

            given().get(baseURI + "rents/status/ISSUED")
                    .then()
                    .statusCode(200)
                    .body("$", hasSize(0));

            given().get(baseURI + "rents/status/NOT_RETURNED")
                    .then()
                    .statusCode(200)
                    .body("$", hasSize(1));
        }
    }
}
