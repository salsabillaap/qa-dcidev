package starter.Signup;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.BaseEndpoint.BaseEndpoint;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class Signup {
    BaseEndpoint endpoint = new BaseEndpoint();

    JSONObject requestpayload;

    //define request payload
    public void setRequestPayload(String name, String email, String password, String phone ){
        requestpayload = new JSONObject();
        requestpayload.put("name",name);
        requestpayload.put("email",email);
        requestpayload.put("password",password);
        requestpayload.put("phone",phone);
    }
    //set Header dan body
    public void setHeader(String header, String content){
        SerenityRest
                .given()
                .header(header,content)
                .body(requestpayload.toString());

    }

    public void hitEndpointSignup(){
        SerenityRest
                .when()
                .post(endpoint.Signup);
    }

    public void validateEndpointSignup(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }

    //VALIDASI JSONSCHEMA
    public void JsonschemaEndpointSignupSuccess(){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/signup/signupsuccess.json"))
                .body("Message",equalTo("Success Operation"));
    }

    public void JsonschemaEndpointSignupFailed(String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/signup/signupfailed.json"))
                .body("Message",equalTo(message));
    }
}
