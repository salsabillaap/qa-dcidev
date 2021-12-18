package starter.Users;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.BaseEndpoint.BaseEndpoint;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUsers {

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
        requestpayload.put("Email","user@example.com");
        requestpayload.put("Password","user123");
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

    public void HitEndpointDeleteUserSuccess(int id){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .delete(endpoint.DeleteUser+id);
    }
    public void HitEndpointDeleteUserFailed(String invalidid){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .delete(endpoint.DeleteProduct+invalidid);
    }

    public void validateStatusCodeEndpointDeleteUser(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }
    public void JsonschemaEndpointDeleteUserSuccess(int code,String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/users/delete/deleteusersuccess.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }
    public void JsonschemaEndpointDeleteUserFailed(int code,String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/users/delete/deleteuserfailed.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }

}
