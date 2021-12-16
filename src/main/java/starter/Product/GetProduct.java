package starter.Product;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.BaseEndpoint.BaseEndpoint;
import java.io.File;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class GetProduct {

    BaseEndpoint endpoint = new BaseEndpoint();

//    public void setHeader(){
//        SerenityRest
//                .
//    }
    // GET all product
    public void hitEndpointGetBook(){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .when()
                .get(endpoint.GetAllProduct)
                .then()
                .statusCode(200);
    }

}
