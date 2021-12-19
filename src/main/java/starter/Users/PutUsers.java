package starter.Users;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.BaseEndpoint.BaseEndpoint;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class PutUsers {

    BaseEndpoint endpoint = new BaseEndpoint();
    JSONObject requestpayload;
    String token;

    //LOGIN SEBAGAI ADMIN
    public void HitEndpointLoginAdmin() {
        requestpayload = new JSONObject();
        requestpayload.put("Email", "admin@admin.com");
        requestpayload.put("Password", "admin123");

        SerenityRest
                .given()
                .header("Content-Type", "application/json")
                .body(requestpayload.toString())
                .when()
                .post(endpoint.Login);

        token = SerenityRest
                .then()
                .extract()
                .path("Data.Token");
    }

    //LOGIN SEBAGAI CUSTOMER
    public void HitEndpointLoginCustomer() {
        requestpayload = new JSONObject();
        requestpayload.put("Email", "user@example.com");
        requestpayload.put("Password", "user123");

        SerenityRest
                .given()
                .header("Content-Type", "application/json")
                .body(requestpayload.toString())
                .when()
                .post(endpoint.Login);

        token = SerenityRest
                .then()
                .extract()
                .path("Data.Token");
    }

    public void setRequestPayloadUpdateUsers(String name, String email, String password, String phone) {
        requestpayload = new JSONObject();
        requestpayload.put("name", name);
        requestpayload.put("email", email);
        requestpayload.put("password", password);
        requestpayload.put("phone", phone);

        SerenityRest
                .given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestpayload.toString());
    }

    //hit endpoint PUT with id
    public void HitEndpointUpdateUsers(int id) {
        SerenityRest
                .when()
                .put(endpoint.PutUsers + id);
    }

    //hit endpoint PUT with invalid id (String)
    public void HitEndpointUpdateUsersFailed(String invalidId) {
        SerenityRest
                .when()
                .put(endpoint.PutUsers + invalidId);
    }

    //validate status code
    public void validateEndpointUpdateUsers(int statuscode) {
        SerenityRest
                .then()
                .statusCode(statuscode);
    }

    //validate jsonschema success
    public void JsonschemaEndpointUpdateUsersSuccess(int code, String message) {
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/users/put/putuserssuccess.json"))
                .body("Code", equalTo(code))
                .body("Message", equalTo(message));
    }

    //validate jsonschema failed
    public void JsonschemaEndpointUpdateUsersFailed(int code, String message) {
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/users/put/putusersfailed.json"))
                .body("Code", equalTo(code))
                .body("Message", equalTo(message));
    }


}
