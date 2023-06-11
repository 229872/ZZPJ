package pl.zzpj.repository;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputCreateDto;

import java.util.UUID;


@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExampleTest {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
        "postgres:14"
    ).withDatabaseName("zzpjdbTest")
        .withUsername("zzpj")
        .withPassword("zzpjpassword");

    @LocalServerPort
    private static Integer port;
    @Autowired
    private ServletWebServerApplicationContext webServerAppCtxt;

    VehicleTireInputCreateDto dto;
    String validStringDto;

    private ObjectMapper objectMapper = new ObjectMapper();

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @BeforeEach
    void BeforeEach() throws JsonProcessingException {
        RestAssured.baseURI = String.format("http://localhost:%s/", webServerAppCtxt.getWebServer().getPort());
        dto = new VehicleTireInputCreateDto("name", "desc",
            2.00, "as.sd/2", 200.00, 30.0);
        validStringDto = objectMapper.writeValueAsString(dto);
    }

    @Test
    void testConnection() {
        Assertions.assertTrue(postgres.isRunning());
        System.out.println(postgres.getMappedPort(5432));
        System.out.println(postgres.getDatabaseName());
        System.out.println(RestAssured.baseURI);
    }

    @Test
    void testGet() {
        UUID uuid = given()
            .header("Content-Type", "application/json")
            .when()
            .body(dto)
            .post(baseURI + "equipment/tires/summer")
            .then()
            .statusCode(201)
            .extract().body().jsonPath().getUUID("uuid");


        given()
            .header("Content-Type", "application/json")
            .when()
            .get(String.format("%sequipment/tires/%s", baseURI, uuid))
            .then()
            .statusCode(200)
            .assertThat().body(Matchers.notNullValue());
    }
}
