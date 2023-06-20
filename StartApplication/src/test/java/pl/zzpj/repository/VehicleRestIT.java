package pl.zzpj.repository;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.ConditionRating;
import pl.zzpj.repository.rest.dto.*;

import java.util.ArrayList;
import java.util.UUID;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VehicleRestIT extends AbstractConfigIT{

    static UUID uuidCar;
    static UUID uuidVan;
    static UUID uuidPickup;
    VehicleDto dtoCar;
    VehicleDto dtoVan;
    VehicleDto dtoPickup;
    String validStringDto;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public VehicleRestIT(ServletWebServerApplicationContext webServerAppCtxt) {
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
        dtoCar = CarDto.builder()
                .make("Toyota")
                .model("Corolla")
                .hourlyRate(20)
                .isAvailable(true)
                .damage(new ArrayList<>())
                .rating(ConditionRating.ALLWEATHER)
                .color("Grey")
                .transmission("Manual")
                .drive_type("FWD")
                .fuel_type("Gasoline")
                .car_type("Sedan")
                .car_options(new ArrayList<>())
                .specs(new ArrayList<>())
                .doors(4)
                .build();
        dtoVan = VanDto.builder()
                .make("Toyota")
                .model("Corolla")
                .hourlyRate(20)
                .isAvailable(true)
                .damage(new ArrayList<>())
                .rating(ConditionRating.ALLWEATHER)
                .color("Grey")
                .transmission("Manual")
                .drive_type("FWD")
                .fuel_type("Gasoline")
                .car_type("van")
                .car_options(new ArrayList<>())
                .specs(new ArrayList<>())
                .doors(4)
                .build();
        dtoPickup = PickupDto.builder()
                .make("Toyota")
                .model("Corolla")
                .hourlyRate(20)
                .isAvailable(true)
                .damage(new ArrayList<>())
                .rating(ConditionRating.ALLWEATHER)
                .color("Grey")
                .transmission("Manual")
                .drive_type("FWD")
                .fuel_type("Gasoline")
                .car_type("Pickup")
                .car_options(new ArrayList<>())
                .specs(new ArrayList<>())
                .doors(4)
                .build();
        validStringDto = objectMapper.writeValueAsString(dtoCar);
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
    void createVehiclePositiveTet() {
        uuidCar = given()
                .header("Content-Type", "application/json")
                .when()
                .body(dtoCar)
                .post(baseURI + "vehicles/add")
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getUUID("id");

        Assertions.assertNotNull(uuidCar);

        uuidVan = given()
                .header("Content-Type", "application/json")
                .when()
                .body(dtoVan)
                .post(baseURI + "vehicles/add")
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getUUID("id");

        Assertions.assertNotNull(uuidVan);
        Assertions.assertNotEquals(uuidCar, uuidVan);

        uuidPickup = given()
                .header("Content-Type", "application/json")
                .when()
                .body(dtoPickup)
                .post(baseURI + "vehicles/add")
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getUUID("id");

        Assertions.assertNotNull(uuidPickup);
        Assertions.assertNotEquals(uuidPickup, uuidCar);
        Assertions.assertNotEquals(uuidPickup, uuidVan);
    }

    @Test
    @Order(3)
    void getVehiclePositiveTest() {
        given()
                .header("Content-Type", "application/json")
                .when()
                .get(String.format("%svehicles/getById/%s", baseURI, uuidCar))
                .then()
                .statusCode(200)
                .assertThat().body(Matchers.notNullValue())
                .body("car_type", equalTo(dtoCar.getCar_type()));

        given()
                .header("Content-Type", "application/json")
                .when()
                .get(String.format("%svehicles/getById/%s", baseURI, uuidVan))
                .then()
                .statusCode(200)
                .assertThat().body(Matchers.notNullValue())
                .body("car_type", equalTo(dtoVan.getCar_type()));

        given()
                .header("Content-Type", "application/json")
                .when()
                .get(String.format("%svehicles/getById/%s", baseURI, uuidPickup))
                .then()
                .statusCode(200)
                .assertThat().body(Matchers.notNullValue())
                .body("car_type", equalTo(dtoPickup.getCar_type()));
    }

    @Test
    @Order(4)
    void updateVehiclePositiveTest() {
        EditVehicleDto edit = EditVehicleDto.builder().color("changed").build();

        given()
                .header("Content-Type", "application/json")
                .when()
                .body(edit)
                .patch(String.format("%svehicles/update/%s", baseURI, uuidCar))
                .then()
                .statusCode(200).assertThat();

        given()
                .header("Content-Type", "application/json")
                .when()
                .get(String.format("%svehicles/getById/%s", baseURI, uuidCar))
                .then()
                .statusCode(200)
                .assertThat()
                .body("color", equalTo(edit.getColor()));


    }

    @Test
    @Order(5)
    void switchAvailabilityPositiveTest() {

        boolean availabilityBeforeChange = given()
                .header("Content-Type", "application/json")
                .when()
                .get(String.format("%svehicles/getById/%s", baseURI, uuidCar))
                .as(VehicleDto.class).isAvailable();


        given()
                .header("Content-Type", "application/json")
                .when()
                .patch(String.format("%svehicles/switchAvailability/%s", baseURI, uuidCar))
                .then()
                .statusCode(200).assertThat();

        boolean availabilityAfterChange = given()
                .header("Content-Type", "application/json")
                .when()
                .get(String.format("%svehicles/getById/%s", baseURI, uuidCar))
                .as(VehicleDto.class).isAvailable();

        Assertions.assertNotEquals(availabilityBeforeChange, availabilityAfterChange);

    }

    @Test
    @Order(6)
    void removeVehiclePositiveTest() {

        int vehicleCount = given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseURI +"vehicles/getAll").body().jsonPath().getList(".", VehicleDto.class).size();

        given()
                .header("Content-Type", "application/json")
                .when()
                .delete(String.format("%svehicles/remove/%s", baseURI, uuidCar))
                .then()
                .statusCode(200);

        int nextVehicleCount = given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseURI +"vehicles/getAll").body().jsonPath().getList(".", VehicleDto.class).size();

        Assertions.assertEquals(vehicleCount, nextVehicleCount + 1);

        given()
                .header("Content-Type", "application/json")
                .when()
                .delete(String.format("%svehicles/remove/%s", baseURI, uuidPickup))
                .then()
                .statusCode(200);

        nextVehicleCount = given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseURI +"vehicles/getAll").body().jsonPath().getList(".", VehicleDto.class).size();

        Assertions.assertEquals(vehicleCount, nextVehicleCount + 2);

        given()
                .header("Content-Type", "application/json")
                .when()
                .delete(String.format("%svehicles/remove/%s", baseURI, uuidVan))
                .then()
                .statusCode(200);

        nextVehicleCount = given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseURI +"vehicles/getAll").body().jsonPath().getList(".", VehicleDto.class).size();

        Assertions.assertEquals(vehicleCount, nextVehicleCount + 3);
    }
}
