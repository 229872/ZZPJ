package pl.zzpj.repository;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import pl.zzpj.repository.rest.dto.input.CredentialsDto;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Tests for user module")
public class UserRestIT extends AbstractConfigIT {

  @Value("${authentication.failure.tolerance.tries:2}")
  private Integer authenticationFailAttempts;
  @Value("${account.blockade.time.seconds:180}")
  private Integer accountBlockadeTimeInSeconds;

  public UserRestIT(ServletWebServerApplicationContext webServerAppCtxt) {
    baseURI = String.format("http://localhost:%s/", webServerAppCtxt.getWebServer().getPort());
    RestAssured.requestSpecification =
            new RequestSpecBuilder()
                    .setContentType(ContentType.JSON)
                    .setAccept(ContentType.JSON)
                    .build();
    accountBlockadeTimeInSeconds = 10;
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
    @DisplayName("Should properly authenticate with correct credentials")
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
    @DisplayName("Should fail to authenticate without sending body in request")
    void should_fail_authenticate_without_body() {

      given()
              .post(baseURI + "users/auth/authenticate")
              .then()
              .statusCode(403);
    }

    @Test
    @Order(3)
    @DisplayName("Should fail to authenticate if we send empty body in request")
    void should_fail_authenticate_with_empty_body() {

      given()
              .post(baseURI + "users/auth/authenticate")
              .then()
              .statusCode(403);
    }

    @ParameterizedTest(name = "login: {0}, password: {1}")
    @Order(4)
    @DisplayName("Should fail to authenticate with wrong credentials")
    @CsvSource({
            "wrongLogin, Kochamzzpj!",
            "admin, wrongPassword"
    })
    void should_fail_authenticate_with_wrong_credentials(String login, String password) {
      CredentialsDto credentials = new CredentialsDto(login, password);

      given()
              .body(credentials)
              .post(baseURI + "users/auth/authenticate")
              .then()
              .statusCode(400);
    }
  }
  @Nested
  @Order(2)
  @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
  class BlockAccount {
    @Test
    @Order(1)
    @DisplayName("Should not block account without exceeding limit for fail attempts")
    void should_not_block_account_without_exceeding_limit() {
      CredentialsDto credentials = new CredentialsDto("admin", "WrongPassword!");

      for (int attempt = 1; attempt <= authenticationFailAttempts; attempt++) {
        Response response = given()
                .body(credentials)
                .post(baseURI + "users/auth/authenticate");

        response.then()
                .statusCode(400);

        String responseBody = response.body().asString();
        assertEquals("Wrong credentials", responseBody);
      }
    }

    @Test
    @Order(2)
    @DisplayName("Should properly block account if we exceed limit of fails authentication attempts")
    void should_not_block_account_after_exceeding_limit() {
      CredentialsDto credentials = new CredentialsDto("admin", "WrongPassword!");

      given()
              .body(credentials)
              .post(baseURI + "users/auth/authenticate")
              .then()
              .statusCode(400);

      Response response = given()
              .body(credentials)
              .post(baseURI + "users/auth/authenticate");

      response.then().statusCode(400);
      String responseBody = response.getBody().asString();
      assertEquals("Account is not active", responseBody);
    }

    @Test
    @Order(3)
    @DisplayName("Should block account for time from descriptor and should unblock account after timeout")
    void account_should_be_blocked_until_timeout() {
      CredentialsDto credentials = new CredentialsDto("admin", "Kochamzzpj!");

      Response response = given()
              .body(credentials)
              .post(baseURI + "users/auth/authenticate");

      response.then().statusCode(400);
      String responseBody = response.getBody().asString();
      assertEquals("Account is not active", responseBody);

      try {
        Thread.sleep(accountBlockadeTimeInSeconds * 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      given()
              .body(credentials)
              .post(baseURI + "users/auth/authenticate")
              .then()
              .statusCode(200);

    }
  }

}
