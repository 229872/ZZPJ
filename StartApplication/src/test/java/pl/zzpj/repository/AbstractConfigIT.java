package pl.zzpj.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public abstract class AbstractConfigIT {

    @Container
    static protected PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:14"
    ).withDatabaseName("zzpjdbTest")
            .withUsername("zzpj")
            .withPassword("zzpjpassword");

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.close();
    }
}
