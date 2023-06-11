package pl.zzpj.repository.rest;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputCreateDto;

@Testcontainers
class VehicleTiresRestControllerTestIT extends VehicleEquipmentITConfig {


    VehicleTireInputCreateDto dto;
    String validStringDto;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeAll
    static void beforeAll() {
        init();
    }

    @BeforeEach
    void beforeEach() throws JsonProcessingException {
        dto = new VehicleTireInputCreateDto("name", "desc",
            2.00, "as.sd/2", 200.00, 30.0);
        validStringDto = objectMapper.writeValueAsString(dto);
    }

    @AfterAll
    static void afterAll() {
        postgres.close();
//        tomcat.close();
    }

    @Test
    void testConnection() {
        Assertions.assertTrue(postgres.isRunning());
        System.out.println(postgres.getMappedPort(5432));
        System.out.println(postgres.getDatabaseName());
//        Assertions.assertTrue(tomcat.isRunning());
//        System.out.println(tomcat.getMappedPort(8080));
//        System.out.println(tomcat.getHost());
        System.out.println(baseUrl);
    }

    @Test
    void loop() {
        while (true) {

        }
    }

}