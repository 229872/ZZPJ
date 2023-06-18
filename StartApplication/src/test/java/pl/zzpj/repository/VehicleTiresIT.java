package pl.zzpj.repository;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputCreateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputUpdateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.RestTireType;

import java.util.UUID;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VehicleTiresIT extends AbstractConfigIT {


    static UUID uuidSummer;
    static UUID uuidWinter;
    static UUID uuidSpecial;
    static UUID uuidAllSeason;
    VehicleTireInputCreateDto dto;
    String validStringDto;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public VehicleTiresIT(ServletWebServerApplicationContext webServerAppCtxt) {
        RestAssured.baseURI = String.format("http://localhost:%s/", webServerAppCtxt.getWebServer().getPort());
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @BeforeEach
    void BeforeEach() throws JsonProcessingException {
        dto = new VehicleTireInputCreateDto("Opona", "Opona",
                2.00, "205/60R13", 200.00, 30.0);
        validStringDto = objectMapper.writeValueAsString(dto);
    }

    @Test
    @Order(1)
    void testConnection() {
        Assertions.assertTrue(postgres.isRunning());
        Assertions.assertNotNull(postgres.getMappedPort(5432));
        Assertions.assertNotNull(postgres.getDatabaseName());
        Assertions.assertNotNull(RestAssured.baseURI);
    }

    @Test
    @Order(2)
    void shouldCreateFourDifferentTireTypes() {
        uuidSummer = given()
                .header("Content-Type", "application/json")
                .when()
                .body(dto)
                .post(baseURI + "equipment/tires/summer")
                .then()
                .statusCode(201)
                .extract().body().jsonPath().getUUID("uuid");

        Assertions.assertNotNull(uuidSummer);

        uuidWinter = given()
                .header("Content-Type", "application/json")
                .when()
                .body(dto)
                .post(baseURI + "equipment/tires/winter")
                .then()
                .statusCode(201)
                .extract().body().jsonPath().getUUID("uuid");

        Assertions.assertNotNull(uuidWinter);
        Assertions.assertNotEquals(uuidSummer, uuidWinter);

        uuidAllSeason = given()
                .header("Content-Type", "application/json")
                .when()
                .body(dto)
                .post(baseURI + "equipment/tires/all_season")
                .then()
                .statusCode(201)
                .extract().body().jsonPath().getUUID("uuid");

        Assertions.assertNotNull(uuidAllSeason);
        Assertions.assertNotEquals(uuidSummer, uuidAllSeason);
        Assertions.assertNotEquals(uuidWinter, uuidAllSeason);

        uuidSpecial = given()
                .header("Content-Type", "application/json")
                .when()
                .body(dto)
                .post(baseURI + "equipment/tires/special")
                .then()
                .statusCode(201)
                .extract().body().jsonPath().getUUID("uuid");

        Assertions.assertNotNull(uuidSpecial);
        Assertions.assertNotEquals(uuidSummer, uuidSpecial);
        Assertions.assertNotEquals(uuidWinter, uuidSpecial);
        Assertions.assertNotEquals(uuidAllSeason, uuidSpecial);


    }

    @Test
    @Order(3)
    void shouldGetFourDifferentTireTypes() {
        given()
                .header("Content-Type", "application/json")
                .when()
                .get(String.format("%sequipment/tires/%s", baseURI, uuidSummer))
                .then()
                .log().all()
                .statusCode(200)
                .log().all()
                .assertThat().body(Matchers.notNullValue())
                .body("archive", equalTo(false))
                .body("type", equalTo(RestTireType.SUMMER.name()));

        given()
                .header("Content-Type", "application/json")
                .when()
                .get(String.format("%sequipment/tires/%s", baseURI, uuidWinter))
                .then()
                .statusCode(200)
                .assertThat().body(Matchers.notNullValue())
                .body("archive", equalTo(false))
                .body("type", equalTo(RestTireType.WINTER.name()));

        given()
                .header("Content-Type", "application/json")
                .when()
                .get(String.format("%sequipment/tires/%s", baseURI, uuidAllSeason))
                .then()
                .statusCode(200)
                .assertThat().body(Matchers.notNullValue())
                .body("archive", equalTo(false))
                .body("type", equalTo(RestTireType.ALL_SEASON.name()));

        given()
                .header("Content-Type", "application/json")
                .when()
                .get(String.format("%sequipment/tires/%s", baseURI, uuidSpecial))
                .then()
                .statusCode(200)
                .assertThat().body(Matchers.notNullValue())
                .body("archive", equalTo(false))
                .body("type", equalTo(RestTireType.SPECIAL.name()));
    }

    @Test
    @Order(4)
    void shouldUpdateTireThenArchive() throws JsonProcessingException {
        VehicleTireInputUpdateDto updateDto = new VehicleTireInputUpdateDto("Zmiana", "Zmiana",
                123.44, 34.32, 33.33);
        String validUpdateStringDto = objectMapper.writeValueAsString(updateDto);

        given()
                .header("Content-Type", "application/json")
                .when()
                .body(validUpdateStringDto)
                .put(String.format("%sequipment/tires/%s", baseURI, uuidAllSeason))
                .then()
                .statusCode(200);

        given()
                .header("Content-Type", "application/json")
                .when()
                .get(String.format("%sequipment/tires/%s", baseURI, uuidAllSeason))
                .then()
                .statusCode(200)
                .assertThat().body(Matchers.notNullValue())
                .body("archive", equalTo(false))
                .body("name", equalTo(updateDto.getName()))
                .body("description", equalTo(updateDto.getDescription()))
                .body("cost", equalTo(updateDto.getCost().floatValue()))
                .body("maximumSpeed", equalTo(updateDto.getMaximumSpeed().floatValue()))
                .body("maximumWeight", equalTo(updateDto.getMaximumWeight().floatValue()));

        given()
                .header("Content-Type", "application/json")
                .when()
                .put(String.format("%sequipment/tires/%s/%s", baseURI, uuidAllSeason, true))
                .then()
                .statusCode(204);

        given()
                .header("Content-Type", "application/json")
                .when()
                .get(String.format("%sequipment/tires/%s", baseURI, uuidAllSeason))
                .then()
                .statusCode(200)
                .assertThat().body(Matchers.notNullValue())
                .body("archive", equalTo(true));
    }

    @Test
    @Order(5)
    void shouldDeleteTireAndThenNotFindItWithCS404() {
        given()
                .header("Content-Type", "application/json")
                .when()
                .delete(String.format("%sequipment/tires/%s", baseURI, uuidAllSeason))
                .then()
                .statusCode(204);

        given()
                .header("Content-Type", "application/json")
                .when()
                .get(String.format("%sequipment/tires/%s", baseURI, uuidAllSeason))
                .then()
                .statusCode(404);

    }
}
