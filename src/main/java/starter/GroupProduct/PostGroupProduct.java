package starter.GroupProduct;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.BaseEndpoint.BaseEndpoint;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class PostGroupProduct {
    BaseEndpoint endpoint = new BaseEndpoint();
    JSONObject requestpayload;
    String token;

    //LOGIN SEBAGAI ADMIN
    public void HitEndpointLoginAdmin(){
        requestpayload = new JSONObject();
        requestpayload.put("Email","admin@admin.com");
        requestpayload.put("Password","admin123");

        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .body(requestpayload.toString())
                .when()
                .post(endpoint.Login);

        token = SerenityRest
                .then()
                .extract()
                .path("Data.Token");
    }
    //LOGIN SEBAGAI CUSTOMER
    public void HitEndpointLoginCustomer(){
        requestpayload = new JSONObject();
        requestpayload.put("Email","wahyu@gmail.com");
        requestpayload.put("Password","wahyu123");

        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .body(requestpayload.toString())
                .when()
                .post(endpoint.Login);

        token = SerenityRest
                .then()
                .extract()
                .path("Data.Token");
    }

    public void SetHeaderPostGroupProduct(){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token);
    }
    public void HitEndpointPostGroupProductSuccess(int id){
        SerenityRest
                .when()
                .post(endpoint.PostGroupProduct+id);
    }
    public void validateEndpointPostGroupProduct(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }
    //validate jsonschema success
    public void JsonschemaEndpointPostGroupProductSuccess(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/GroupProduct/post/postgroupproductsuccess.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }
    //validate jsonschema failed
    public void JsonschemaEndpointPostGroupProductFailed(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/GroupProduct/post/postgroupproductfailed.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }

}
