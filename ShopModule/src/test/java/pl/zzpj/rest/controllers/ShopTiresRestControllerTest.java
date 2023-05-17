package pl.zzpj.rest.controllers;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import pl.zzpj.rest.dto.shopEquipment.Input.ShopTireInputDto;
import pl.zzpj.rest.dto.shopEquipment.RestTireType;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;

class ShopTiresRestControllerTest {

    @Test
    void getAll() {
    }

//    @Test
//    void getEquipmentById() {
//        given()
//                .contentType(ContentType.JSON)
//                .when()
//                .pathParam("id", "")
//                .get()"/shop/tires/{id}";
//    }

    @Test
    void createEquipment() {
        ShopTireInputDto dto = ShopTireInputDto.builder().name("name").cost(123.0).size("test").description("descr").archive(false)
                .maximumSpeed(100L).maximumWeight(10L).type(RestTireType.SUMMER).productionDate(LocalDateTime.now()).build();

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(dto)
                .post("/shop/tires/")
                .then().statusCode(200);
    }

    @Test
    void updateEquipment() {

        ShopTireInputDto dto = ShopTireInputDto.builder().name("name").cost(123.0).size("test").description("descr").archive(false)
                .maximumSpeed(100L).maximumWeight(10L).type(RestTireType.SUMMER).productionDate(LocalDateTime.now()).build();
// TODO
//        ShopTireOutputDto returnDto = UUID.fromString(given()
//                .contentType(ContentType.JSON)
//                .when()
//                .body(dto)
//                .post("/shop/tires/")
//                .getBody().as(ShopTireOutputDto.class).toString());

//        dto.setSize("zmiana");
//        dto.setCost(2137.0);
//
//        given()
//                .contentType(ContentType.JSON)
//                .when()
//                .pathParam(String.valueOf(id), id)
//                .body(dto)
//                .put("/shop/tires/{id}")
//                .then().statusCode(200);
    }
}