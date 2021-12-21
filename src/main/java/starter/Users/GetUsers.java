package starter.Users;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.BaseEndpoint.BaseEndpoint;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class GetUsers {
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
    //hit endpoint get all user success
    public void HitEndpointGetAllUsers(){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get(endpoint.GetAllUsers);
    }
    //hit endpoint get users by id
    public void HitEndpointGetUsersByID(int id){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get(endpoint.GetUsersID+id);

    }
    //hit endpoint get users by invalid id
    public void HitEndpointGetUsersByInvalidID(String invalidId){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get(endpoint.GetUsersID+invalidId);
    }

    //validate status code endpoint
    public void validateStatusCodeEndpoint(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }

    //VALIDATE JSONSCHEMA GET ALL USERS
    public void jsonschemaEnpointGetAllUsersSuccess(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/users/get/getalluserssuccess.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }


    public void jsonschemaEndpointGetAllUsersFailed(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/users/get/getallusersfailed.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }

    //VALIDATE JSONSCHEMA GET USERS BY ID
    public void jsonschemaEndpointGetUsersByIDSuccess(int code, String message, int id){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/users/get/getusersbyidsuccess.json"))
                .body("Code",equalTo(code))
                .body("Data.ID",equalTo(id))
                .body("Message",equalTo(message));
    }

    public void jsonschemaEndpointGetUsersByIDFailed(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/users/get/getusersbyidfailed.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }

}
