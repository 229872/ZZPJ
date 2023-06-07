//package pl.zzpj.repository.rest.controllers;
//
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputCreateDto;
//import pl.zzpj.repository.rest.dto.vehicleEquipment.Output.VehicleTireOutputDto;
//import pl.zzpj.repository.rest.dto.vehicleEquipment.RestTireType;
//
//import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.with;
//
//class VehicleTiresRestControllerTest {
//
//    @Test
//    void getAll() {
//        RestAssured.get("/shop/tires").then().statusCode(200);
//    }
//
////    @Test
////    void getEquipmentById() {
////        given()
////                .contentType(ContentType.JSON)
////                .when()
////                .pathParam("id", "")
////                .get()"/shop/tires/{id}";
////    }
//
//    @Test
//    void createEquipment() {
//        VehicleTireInputCreateDto dto = VehicleTireInputCreateDto.builder().name("name").cost(123.0).size("test").description("descr").archive(false)
//                .maximumSpeed(100L).maximumWeight(10L).type(RestTireType.SUMMER).build();
//        VehicleTireOutputDto returnDto = with()
//                .contentType(ContentType.JSON)
//                .body(dto)
//                .when()
//                .request("POST", "shop/tires").getBody().as(VehicleTireOutputDto.class);
//
//        Assertions.assertNotNull(returnDto.getUuid());
//
//        VehicleTireOutputDto getDto = with()
//                .contentType(ContentType.JSON)
//                .when()
//                .request("GET", "shop/tires/{id}", returnDto.getUuid())
//                .getBody().as(VehicleTireOutputDto.class);
//
//        Assertions.assertEquals(returnDto, getDto);
//    }
//
//    @Test
//    void updateEquipment() {
//
//        VehicleTireInputCreateDto dto = VehicleTireInputCreateDto.builder().name("name").cost(123.0).size("test").description("descr").archive(false)
//                .maximumSpeed(100L).maximumWeight(10L).type(RestTireType.SUMMER).build();
//
//        VehicleTireOutputDto returnDto = given()
//                .contentType(ContentType.JSON)
//                .when()
//                .body(dto)
//                .post("/shop/tires")
//                .getBody().as(VehicleTireOutputDto.class);
//
//        returnDto.setSize("zmiana");
//        returnDto.setCost(1234.0);
//
//        System.out.println("here");
//        System.out.println(returnDto);
//
//        given()
//                .contentType(ContentType.JSON)
//                .when()
//                .body(dto)
//                .put("/shop/tires/{id}", returnDto.getUuid())
//                .then().statusCode(200);
//    }
//}