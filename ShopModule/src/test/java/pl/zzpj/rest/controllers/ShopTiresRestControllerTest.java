package pl.zzpj.rest.controllers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import pl.zzpj.rest.dto.shopEquipment.Input.ShopTireInputDto;
import pl.zzpj.rest.dto.shopEquipment.Output.ShopTireOutputDto;
import pl.zzpj.rest.dto.shopEquipment.RestTireType;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;

class ShopTiresRestControllerTest {

    @Test
    void getAll() {
        RestAssured.get("/shop/tires").then().statusCode(200);
    }

//    @Test
//    void getEquipmentById() {
//        given()
//                .contentType(ContentType.JSON)
//                .when()
//                .pathParam("id", "")
//                .get()"/shop/tires/{id}";
//    }

    //    @Test
    void createEquipment() {
        ShopTireInputDto dto = ShopTireInputDto.builder().name("name").cost(123.0).size("test").description("descr").archive(false)
                .maximumSpeed(100L).maximumWeight(10L).type(RestTireType.SUMMER).productionDate(LocalDateTime.now()).build();
        ShopTireOutputDto returnDto = with()
                .contentType(ContentType.JSON)
                .body(dto)
                .when()
                .request("POST", "shop/tires").getBody().as(ShopTireOutputDto.class);
        System.out.println(returnDto);
    }

    //    @Test
    void updateEquipment() {

        ShopTireInputDto dto = ShopTireInputDto.builder().name("name").cost(123.0).size("test").description("descr").archive(false)
                .maximumSpeed(100L).maximumWeight(10L).type(RestTireType.SUMMER).productionDate(LocalDateTime.now()).build();

        ShopTireOutputDto returnDto = given()
                .contentType(ContentType.JSON)
                .when()
                .body(dto)
                .post("/shop/tires")
                .getBody().as(ShopTireOutputDto.class);

        returnDto.setSize("zmiana");
        returnDto.setCost(1234.0);

        System.out.println("here");
        System.out.println(returnDto);

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(dto)
                .put("/shop/tires/{id}", returnDto.getUuid())
                .then().statusCode(200);
    }
}