package pl.zzpj.repository.rest;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.MountableFile;

import java.nio.file.Paths;


public class VehicleEquipmentITConfig {

    public static Network network = Network.newNetwork();
    protected static String baseUrl;
    public static final MountableFile JAR = MountableFile
        .forHostPath(Paths.get("target/VehicleEquipment.jar").toAbsolutePath());
    @Container
    protected static final PostgreSQLContainer<?> postgres
        = new PostgreSQLContainer<>("postgres:14")
        .withDatabaseName("zzpjdbTest")
        .withUsername("zzpj")
        .withPassword("zzpjpassword")
        .withNetwork(network)
        .withNetworkAliases("db")
        .withReuse(true);

    @Container
    protected static GenericContainer tomcat
        = new GenericContainer("tomcat:10.1.8-jdk17-temurin-jammy")
        .withExposedPorts(8080)
        .dependsOn(postgres)
        .withNetwork(network)
        .withNetworkAliases("tomcat")
        .withCopyFileToContainer(JAR, "/usr/local/tomcat/webapps/VehicleEquipment.jar")
//        .withCommand()
//        .waitingFor(Wait.forHttp("/equipment/tires"))
        .withReuse(true);

    @DynamicPropertySource
    public static void dynamicConfig(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    public static void init() {
        baseUrl = String.format("http://%s:%d/", tomcat.getHost(), tomcat.getMappedPort(8080));
    }
}
