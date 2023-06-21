package pl.zzpj.repository;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import pl.zzpj.repository.rest.dto.input.CredentialsDto;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRestIT extends AbstractConfigIT {

  public UserRestIT(ServletWebServerApplicationContext webServerAppCtxt) {
    baseURI = String.format("http://localhost:%s/", webServerAppCtxt.getWebServer().getPort());
    RestAssured.requestSpecification =
            new RequestSpecBuilder()
                    .setContentType(ContentType.JSON)
                    .setAccept(ContentType.JSON)
                    .build();
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
  class Authentication {

    @Test
    @Order(1)
    void should_authenticate_with_correct_credentials() {
      CredentialsDto credentials = new CredentialsDto("admin", "Kochamzzpj!");

      given()
              .body(credentials)
              .post(baseURI + "users/auth/authenticate")
              .then()
              .statusCode(200);
    }

    @Test
    @Order(2)
    void should_fail_authenticate_without_body() {

      given()
              .post(baseURI + "users/auth/authenticate")
              .then()
              .statusCode(403);
    }

    @Test
    @Order(3)
    void should_fail_authenticate_with_empty_body() {

      given()
              .post(baseURI + "users/auth/authenticate")
              .then()
              .statusCode(403);
    }

    @Test
    @Order(4)
    void should_fail_authenticate_with_wrong_credentials() {
      CredentialsDto credentials = new CredentialsDto("adminn", "Kochamzzpj!");

      given()
              .body(credentials)
              .post(baseURI + "users/auth/authenticate")
              .then()
              .statusCode(400);
    }


  }
}
