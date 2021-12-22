package starter.GroupProduct;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.BaseEndpoint.BaseEndpoint;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class DeleteGroupProduct {
    BaseEndpoint endpoint = new BaseEndpoint();
    JSONObject requestpayload;
    String token;

    // hit endpoint untuk login sebagai user admin
    public void HitEndpointLoginAdmin(){
        requestpayload = new JSONObject();
        requestpayload.put("Email","admin@admin.com");
        requestpayload.put("Password","admin123");
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .body(requestpayload.toString())
                .when()
                .post(endpoint.Login)
                .then()
                .statusCode(200);

        token = SerenityRest
                .then()
                .extract()
                .path("Data.Token");
    }
    //hit endpoint untuk login sebagai user customer
    public void HitEndpointLoginCustomer(){
        requestpayload = new JSONObject();
        requestpayload.put("Email","wahyu@gmail.com");
        requestpayload.put("Password","wahyu123");
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .body(requestpayload.toString())
                .when()
                .post(endpoint.Login)
                .then()
                .statusCode(200);

        token = SerenityRest
                .then()
                .extract()
                .path("Data.Token");
    }

    //hit endpoint delete group product with id group product
    public void HitEndpointDeleteGroupProduct(int id){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .delete(endpoint.DeleteGroupProduct+id);
    }

    //hit endpoint delete group product with id group product
    public void HitEndpointDeleteGroupProductInvalidID(String invalidid){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .delete(endpoint.DeleteGroupProduct+invalidid);
    }

    //validate status code
    public void validateStatusCodeEndpointDeleteGroupProduct(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }

    //validate jsonschema
    public void JsonschemaEndpointDeleteGroupProduct(int code,String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/GroupProduct/delete/deletegroupproductsucess.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }

}
