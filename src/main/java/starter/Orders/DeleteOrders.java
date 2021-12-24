package starter.Orders;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.BaseEndpoint.BaseEndpoint;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class DeleteOrders {

    BaseEndpoint endpoint = new BaseEndpoint();
    JSONObject requestpayload;
    String token;
    String token1;
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
        requestpayload.put("Email","jajal2@jajal2.com");
        requestpayload.put("Password","123456");
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

    public void HitEndpointDeleteOrderSuccess(int id){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .delete(endpoint.DeleteOrderByIDOrder+id);
    }
    public void HitEndpointDeleteOrderFailedasCustomer(int id) {
        SerenityRest
                .given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token1)
                .when()
                .delete(endpoint.DeleteOrderByIDOrder + id);
    }
    public void HitEndpointDeleteOrderFailedInvalidID(String invalidid){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .delete(endpoint.DeleteProduct+invalidid);
    }

    public void validateStatusCodeEndpointDeleteOrder(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }
    public void JsonschemaEndpointDeleteOrderSuccess(int code,String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/users/delete/deleteusersuccess.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }
    public void JsonschemaEndpointDeleteOrderFailed(int code,String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/users/delete/deleteuserfailed.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }

}
