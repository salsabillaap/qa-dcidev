package starter.Product;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.BaseEndpoint.BaseEndpoint;
import java.io.File;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class GetProduct {

    BaseEndpoint endpoint = new BaseEndpoint();

    //set header
    public void setHeader(String header, String content){
        SerenityRest
                .given()
                .header(header,content);
    }
    // Hit GET all product success
    public void hitEndpointGetProduct(){
        SerenityRest
                .when()
                .get(endpoint.GetAllProduct);

    }
    // Hit GET all product failed
    public void hitInvalidEndpointGetProduct(){
        SerenityRest
                .when()
                .get("https://barengin.site/prousct");

    }
    //hit GET product by ID
    public void hitEndpointGetProductID(int id){
        SerenityRest
                .when()
                .get(endpoint.GetProductID+id);
    }
    //hit GET product by ID
    public void hitEndpointGetProductInvalidID(String invalidID){
        SerenityRest
                .when()
                .get(endpoint.GetProductID+invalidID);
    }

    //validasi response code get product
    public void validateEndpointGET(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);

    }
    //validasi jsonschema success
    public void JsonschemaGetAllProductSuccess(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/product/get/getallproductsuccess.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }
    //validasi jsonschema failed
    public void JsonschemaGetAllProductFailed(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/product/get/getallproductfailed.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }
    //validasi jsonschema success get product by id
    public void JsonschemaGetProductByIDSuccess(int code, String message, int id){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/product/get/getproductbyidsuccess.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message))
                .body("Data.ID",equalTo(id));
    }
    //validasi jsonschema failed get product by id
    public void JsonschemaGetProductByIDFailed(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/product/get/getproductbyidfailed.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }

}
