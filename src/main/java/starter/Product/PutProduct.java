package starter.Product;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.BaseEndpoint.BaseEndpoint;
import java.io.File;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class PutProduct{
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
    //valid request update product except photo
    public void setRequestPayloadUpdateProduct(String name,String detail, int price, int limit){
        SerenityRest
                .given()
                .header("Content-Type","multipart/form-data")
                .header("Authorization","Bearer "+token)
                    .multiPart("name_product",name)
                    .multiPart("detail_product",detail)
                    .multiPart("price",price)
                    .multiPart("limit",limit);
                    //.multiPart("photo",new File())
    }

    //hit endpoint PUT
    public void hitEnpointPutUpdateProduct(int id){
        SerenityRest
                .when()
                .put(endpoint.PutProduct+id);
    }
    //hit endpoint PUT invalid ID
    public void hitEnpointPutUpdateProduct(String invalidId){
        SerenityRest
                .when()
                .put(endpoint.PutProduct+invalidId);
    }
    //validate status code
    public void validateEndpointPutUpdateProduct(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }
    //validate jsonschema
    public void JsonschemaEndpointPutProductSuccess(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/product/put/putproductsuccess.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }
    //validate jsonschema
    public void JsonschemaEndpointPutProductFailed(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/product/put/putproductfailed.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }
}
