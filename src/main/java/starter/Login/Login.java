package starter.Login;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.BaseEndpoint.BaseEndpoint;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Login {
    BaseEndpoint endpoint = new BaseEndpoint();

    JSONObject requestpayload;

    //define request payload
    public void setRequestPayload(String email, String password){
        requestpayload = new JSONObject();
        requestpayload.put("Email",email);
        requestpayload.put("Password",password);
    }
    //set header dan body
    public void setHeader(String header, String content){
        SerenityRest
                .given()
                .header(header,content)
                .body(requestpayload.toString());
    }
    //click endpoint
    public void hitEndpointLogin(){
        SerenityRest
                .when()
                    .post(endpoint.Login);

    }
    //validasi response status code
    public void validateEndpointLogin(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }

    //VALIDASI JSONSCHEMA
    public void JsonschemaEndpointLoginSuccess(){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/login/loginsuccess.json"));
    }
    public void JsonschemaEndpointLoginFailed(){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/login/loginfailed.json"));
    }

}
