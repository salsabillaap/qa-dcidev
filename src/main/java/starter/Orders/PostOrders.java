package starter.Orders;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.BaseEndpoint.BaseEndpoint;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class PostOrders {

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

        token1 = SerenityRest
                .then()
                .extract()
                .path("Data.Token");
    }

    //hit endpoint untuk login sebagai user customer
    public void HitEndpointLoginCustomer(){
        requestpayload = new JSONObject();
        requestpayload.put("Email","jajal8@jajal8.com");
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
    public void setrequestbodyphone(String phone){
        requestpayload = new JSONObject();
        requestpayload.put("phone",phone);
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .body(requestpayload.toString());
    }
    public void setrequestbodyphoneadmin(String phone){
        requestpayload = new JSONObject();
        requestpayload.put("phone",phone);
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token1)
                .body(requestpayload.toString());
    }

    public void HitEndpointPostOrderSuccess(int id){
        SerenityRest
                .when()
                .post(endpoint.PostOrders+id);
    }
    public void validateEndpointPostOrder(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }
    //validate jsonschema success
    public void JsonschemaEndpointPostOrderSuccess(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/order/post/postordersuccess.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }
    //validate jsonschema failed
    public void JsonschemaEndpointPostOrderFailed(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/order/post/postorderfailed.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }

}
