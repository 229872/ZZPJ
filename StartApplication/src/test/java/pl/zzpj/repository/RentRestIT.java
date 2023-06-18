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
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import pl.zzpj.repository.rest.dto.CreateRentDto;
import pl.zzpj.repository.rest.dto.input.CredentialsDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RentRestIT extends AbstractConfigIT {

    private final String adminJwt;

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
    class CreateRent {


        private static List<UUID> vehicleIds;
        private static List<UUID> userIds;

        @BeforeEach
        void init() {
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

        @Test
        @Order(1)
        void createRent_correct() {
            CreateRentDto createRentDto = CreateRentDto.builder()
                    .userId(userIds.get(0))
                    .vehicleId(vehicleIds.get(0))
                    .declaredStart(LocalDateTime.now().plusDays(2))
                    .declaredEnd(LocalDateTime.now().plusDays(5))
                    .build();

            given()
                    .body(createRentDto)
                    .post(baseURI + "rents")
                    .then()
                    .log().all()
                    .statusCode(200);
        }
    }

    @Nested
    @Order(2)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class ReadRents {
        @Test
        @Order(1)
        void findAllRents_correct() {
            given().get(baseURI + "rents")
                    .then()
                    .log().all()
                    .statusCode(200);
        }
    }


}
