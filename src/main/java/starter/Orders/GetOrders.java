package starter.Orders;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.BaseEndpoint.BaseEndpoint;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class GetOrders {
   BaseEndpoint endpoint = new BaseEndpoint();
   JSONObject requestpayload;
   String token;


    // hit endpoint untuk login sebagai user
    public void HitEndpointLoginCustomer(){
        requestpayload = new JSONObject();
        requestpayload.put("Email","andi@gmail.com");
        requestpayload.put("Password","andi12345");
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

    //hit endpoint get order by id order
    public void HitEndpointGetOrderByID(int id){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get(endpoint.GetOrderByIDOrders+id);

    }

    //hit endpoint get order by id order failed
    public void HitEndpointGetOrderByInvalidID(String InvalidID){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get(endpoint.GetOrderByIDOrders+InvalidID);

    }

    //hit endpoint get all order by id group for admin
    public void HitEndpointGetAllOrderByIDGroup(int id){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get(endpoint.GetOrderByIDOrders+id);

    }

    //hit endpoint get all order by id group for admin failed
    public void HitEndpointGetAllOrderByInvalidIDGroup(String InvalidID){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get(endpoint.GetOrderByIDOrders+InvalidID);

    }


    //hit endpoint get all order by id user
    public void HitEndpointGetAllOrderByIDUser(int id){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get(endpoint.GetOrderByIDOrders+id);

    }

    //hit endpoint get all order by id user failed
    public void HitEndpointGetAllOrderByInvalidIDUser(String InvalidID){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get(endpoint.GetOrderByIDOrders+InvalidID);

    }


//********////



    //validate status code endpoint
    public void validateStatusCodeEndpoint(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }

    //validate jsonschema by id order
    public void jsonschemaEndpointGetOrderByIdOrder(int code, String message, int id){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/order/get/getorderbyidorder.json"))
                .body("Code",equalTo(code))
                .body("Data.ID",equalTo(id))
                .body("Message",equalTo(message));
    }

    //validate jsonschema by id order failed
    public void jsonschemaEndpointGetOrderByIdOrderFailed(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/users/get/getorderbyidorderfailed.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }


    //validate jsonschema by id group for admin
    public void jsonschemaEndpointGetAllOrderByIdGroup(int code, String message, int id){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/order/get/getallorderbyidgroup.json"))
                .body("Code",equalTo(code))
                .body("Data.ID",equalTo(id))
                .body("Message",equalTo(message));
    }

    //validate jsonschema by id group failed
    public void jsonschemaEndpointGetAllOrderByIdGroupFailed(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/users/get/getallorderbyidgroupfailed.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }


    //validate jsonschema by id user
    public void jsonschemaEndpointGetAllOrderByIduser(int code, String message, int id){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/order/get/getallorderbyiduser.json"))
                .body("Code",equalTo(code))
                .body("Data.ID",equalTo(id))
                .body("Message",equalTo(message));
    }

    //validate jsonschema by id user failed
    public void jsonschemaEndpointGetAllOrderByIdUserFailed(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/users/get/getallorderbyiduserfailed.json"))
                .body("Code",equalTo(code))
                .body("Message",equalTo(message));
    }



}
