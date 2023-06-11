package pl.zzpj.repository.rest;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import pl.zzpj.repository.rest.adapters.VehicleTiresRestAdapter;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputCreateDto;

@ContextConfiguration(classes = VehicleTiresRestController.class)
@WebMvcTest(controllers = VehicleTiresRestController.class)
class VehicleTiresRestControllerTestIT extends VehicleEquipmentITConfig {


    VehicleTireInputCreateDto dto;
    String validStringDto;

    @MockBean
    private VehicleTiresRestAdapter tiresRestAdapter;

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void beforeEach() throws JsonProcessingException {
        dto = new VehicleTireInputCreateDto("name", "desc",
            2.00, "as.sd/2", 200.00, 30.0);
        validStringDto = objectMapper.writeValueAsString(dto);
    }

    @Test
    void testConnection() {
        Assertions.assertTrue(postgres.isRunning());
        System.out.println(postgres.getMappedPort(5432));
        System.out.println(postgres.getDatabaseName());
    }

    @Test
    void testtest() throws Exception {
        MvcResult outputDto = mockMvc.perform(
                post("/equipment/tires/winter")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(validStringDto)
            )
            .andExpect(status().isCreated())
            .andReturn(); //  andExpect(model().attribute("uuid", null));

        System.out.println(outputDto);
    }
}