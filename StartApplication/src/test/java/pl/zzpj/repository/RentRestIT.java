package pl.zzpj.repository;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RentRestIT extends AbstractConfigIT {

    @Autowired
    public RentRestIT(ServletWebServerApplicationContext webServerAppCtxt) {
        RestAssured.baseURI = String.format("http://localhost:%s/", webServerAppCtxt.getWebServer().getPort());
    }

}
