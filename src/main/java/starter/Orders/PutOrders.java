package starter.Orders;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.BaseEndpoint.BaseEndpoint;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class PutOrders {

    BaseEndpoint endpoint = new BaseEndpoint();
    JSONObject requestpayload;
    public String token;


    // hit endpoint untuk login sebagai admin
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


    //valid request update order
    public void setRequestPayloadUpdateOrder(String email,String password){
        SerenityRest
                .given()
                .header("Content-Type","multipart/form-data")
                .header("Authorization","Bearer "+token)
                .multiPart("email",email)
                .multiPart("password",password);
    }


    //hit endpoint put order by id order
    public void HitEndpointPutOrderByID(int id){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get(endpoint.PutOrdersByIDOrders+id);

    }

    //hit endpoint put order by id order failed
    public void HitEndpointPutOrderByIDFailed(String InvalidID){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get(endpoint.PutOrdersByIDOrders+InvalidID);

    }

    //*******

    //validate status code endpoint
    public void validateStatusCodeEndpoint(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }

    //validate jsonschema success
    public void JsonschemaEndpointPutOrderSuccess(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/product/put/putorder.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }
    //validate jsonschema failed
    public void JsonschemaEndpointPutOrderFailed(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/product/put/putorderfailed.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }



}
