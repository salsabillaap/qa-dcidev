package starter.GroupProduct;

import net.serenitybdd.rest.SerenityRest;
import starter.BaseEndpoint.BaseEndpoint;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class GetGroupProduct {
    BaseEndpoint endpoint = new BaseEndpoint();

    //set header
    public void setHeader(String header, String content) {
        SerenityRest
                .given()
                .header(header, content);
    }

    // Hit GET all product success
    public void hitEndpointGetGroupProduct() {
        SerenityRest
                .when()
                .get(endpoint.GetGroupAllProduct);
    }

    //hit GET by ID Group success
    public void hitEndpointGetIDGroup(int id){
        SerenityRest
                .when()
                .get(endpoint.GetGroupAllProductIDGroup+id);
    }

    //hit GET by ID Group failed
    public void hitEndpointGetIDGroupInvalidID(String invalidID){
        SerenityRest
                .when()
                .get(endpoint.GetGroupAllProductIDGroup+invalidID);
    }

    //hit GET by ID Product success
    public void hitEndpointGetIDProduct(int id){
        SerenityRest
                .when()
                .get(endpoint.GetGroupAllProductIDProduct+id);
    }

    //hit GET by ID Product failed
    public void hitEndpointGetIDProductInvalidID(String invalidID){
        SerenityRest
                .when()
                .get(endpoint.GetGroupAllProductIDProduct+invalidID);
    }


    //hit GET status product
    public void hitEndpointGetAStatus(String message){
        SerenityRest
                .when()
                .get(endpoint.GetGroupProductStatus+message);
    }








    //validasi response code get product
    public void validateEndpointGET(int statuscode) {
        SerenityRest
                .then()
                .statusCode(statuscode);

    }

    //validasi jsonschema success
    public void JsonschemaGetAllGroupProduct(int code, String message) {
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/groupproduct/get/getallgroupproduct.json"))
                .body("Code", equalTo(code))
                .body("Message", equalTo(message));
    }

    //validasi jsonschema success get by id group
    public void JsonschemaGetByIDGroupSuccess(int code, String message, int id){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/groupproduct/get/getbyidgroupsuccess.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message))
                .body("Data.ID",equalTo(id));
    }

    //validasi jsonschema failed get by id group
    public void JsonschemaGetByIDGroupFailed(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/groupproduct/get/getbyidgroupfailed.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }

    //validasi jsonschema success get by id product
    public void JsonschemaGetByIDProductSuccess(int code, String message, int id){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/groupproduct/get/getbyidproductsuccess.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message))
                .body("Data.ID",equalTo(id));
    }

    //validasi jsonschema failed get by id product
    public void JsonschemaGetByIDProductFailed(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/groupproduct/get/getbyidgroupfailed.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }


    //validasi jsonschema status product
    public void JsonschemaGetStatusProduct(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/groupproduct/get/getgroupproductstatus.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }

}
