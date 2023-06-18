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
    private static UUID rentId;
    private static DateTimeFormatter format =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    public RentRestIT(ServletWebServerApplicationContext webServerAppCtxt) {
        baseURI = String.format("http://localhost:%s/", webServerAppCtxt.getWebServer().getPort());
        RestAssured.requestSpecification =
                new RequestSpecBuilder()
                        .setContentType(ContentType.JSON)
                        .setAccept(ContentType.JSON)
                        .log(LogDetail.ALL)
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
                .get(baseURI + "rentVehicles/getAll")
                .then()
                .log().all()
                .statusCode(200)
                .extract().jsonPath().getList("id", UUID.class);

        userIds = given()
                .header("Authorization", "Bearer " + adminJwt)
                .get(baseURI + "users")
                .then()
                .log().all()
                .statusCode(200)
                .extract().jsonPath().getList("clientId", UUID.class);
    }


    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

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
                .log().all()
                .statusCode(200);
    }

    @Test
    @Order(2)
    void findAllRents_correct() {
        List<UUID> rents = given().get(baseURI + "rents")
                .then()
                .log().all()
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
                .log().all()
                .statusCode(200)
                .body("$", hasSize(1));
    }

    @Test
    @Order(2)
    void findVehicleRent_correct() {
        given().get(baseURI + "rents/vehicle/" + vehicleIds.get(0))
                .then()
                .log().all()
                .statusCode(200)
                .body("$", hasSize(1));
    }

    @Test
    @Order(2)
    void findRentsByStatus_created_correct() {
        given().get(baseURI + "rents/status/CREATED")
                .then()
                .log().all()
                .statusCode(200)
                .body("$", hasSize(1));
    }

    @Test
    @Order(2)
    void findRentsToIssue_correct() {
        String date = LocalDateTime.now().plusDays(6).format(format);
        given()
                .log().all()
                .get(baseURI + "rents/to-issue/" + date)
                .then()
                .log().all()
                .statusCode(200)
                .body("$", hasSize(1));
    }

    @Test
    @Order(3)
    void findRent_correct() {
        given().get(baseURI + "rents/" + rentId.toString())
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    @Order(3)
    void issueVehicle_correct() {
        given().put(baseURI + "rents/issue/" + rentId.toString())
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    @Order(4)
    void findRentsByStatus_issued_correct() {
        given().get(baseURI + "rents/status/CREATED")
                .then()
                .log().all()
                .statusCode(200)
                .body("$", hasSize(0));

        given().get(baseURI + "rents/status/ISSUED")
                .then()
                .log().all()
                .statusCode(200)
                .body("$", hasSize(1));
    }

    @Test
    @Order(5)
    void returnVehicle_correct() {
        given().put(baseURI + "rents/return/" + rentId.toString())
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    @Order(6)
    void findRentsByStatus_returned_correct() {
        given().get(baseURI + "rents/status/CREATED")
                .then()
                .log().all()
                .statusCode(200)
                .body("$", hasSize(0));

        given().get(baseURI + "rents/status/ISSUED")
                .then()
                .log().all()
                .statusCode(200)
                .body("$", hasSize(0));

        given().get(baseURI + "rents/status/RETURNED_GOOD")
                .then()
                .log().all()
                .statusCode(200)
                .body("$", hasSize(1));
    }
}
