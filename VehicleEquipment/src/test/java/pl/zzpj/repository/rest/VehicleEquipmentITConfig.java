package pl.zzpj.repository.rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class VehicleEquipmentITConfig {


    @Container
    protected static final PostgreSQLContainer<?> postgres
        = new PostgreSQLContainer<>("postgres:14")
        .withDatabaseName("zzpjdbTest")
        .withUsername("zzpj")
        .withPassword("zzpjpassword")
        .withReuse(true);

    @DynamicPropertySource
    public static void dynamicConfig(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }
}
