package starter.Product;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.BaseEndpoint.BaseEndpoint;
import java.io.File;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class PostProduct {
    BaseEndpoint endpoint = new BaseEndpoint();
    JSONObject requestpayload;

    public String token;

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

    //valid request valid
    public void setRequestPayloadCreateProduct(String name_product,String detail_product,int price,int limit){
        SerenityRest
                .given()
                .header("Content-Type","multipart/form-data")
                .header("Authorization","Bearer "+token)
                .multiPart("name_product",name_product)
                .multiPart("detail_product",detail_product)
                .multiPart("price",price)
                .multiPart("limit",limit)
                .multiPart("photo",new File("E:/Video/github-logo.png"));
    }
    //invalid request string price and limit
    public void setRequestPayloadCreateProductFailed(String name_product,String detail_product,String price,String limit){
        SerenityRest
                .given()
                .header("Content-Type","multipart/form-data")
                .header("Authorization","Bearer "+token)
                .multiPart("name_product",name_product)
                .multiPart("detail_product",detail_product)
                .multiPart("price",price)
                .multiPart("limit",limit)
                .multiPart("photo",new File("E:/Video/github-logo.png"));
    }
    //valid request create product failed extension
    public void RequestPayloadFailedExtension(String name_product,String detail_product,int price,int limit,String photo){
        SerenityRest
                .given()
                .header("Content-Type","multipart/form-data")
                .header("Authorization","Bearer "+token)
                .multiPart("name_product",name_product)
                .multiPart("detail_product",detail_product)
                .multiPart("price",price)
                .multiPart("limit",limit)
                .multiPart("photo",new File(photo));
    }

    //valid request create product failed extension
    public void RequestPayloadFailedUpload(String name_product,String detail_product,int price,int limit,String photo){
        SerenityRest
                .given()
                .header("Content-Type","multipart/form-data")
                .header("Authorization","Bearer "+token)
                .multiPart("name_product",name_product)
                .multiPart("detail_product",detail_product)
                .multiPart("price",price)
                .multiPart("limit",limit)
                .multiPart("urlphoto",new File(photo));
    }

    public void hitEnpointPostCreateProduct(){
        SerenityRest
                .when()
                .post(endpoint.Product);
    }

    public void validateEndpointPostCreateProduct(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }

    public void JsonschemaEndpointPostProductSuccess(String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/product/post/postproductsuccess.json"))
                .body("Code",equalTo(200))
                .body("Message",equalTo(message));
    }
    public void JsonschemaEndpointPostProductFailed(int code,String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/product/post/postproductsuccess.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }

}
