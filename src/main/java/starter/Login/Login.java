package starter.Login;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.BaseEndpoint.BaseEndpoint;

public class Login {
    BaseEndpoint endpoint = new BaseEndpoint();

    JSONObject requestpayload;

    //set request payload/body request
    public void setBodyRequest(String email, String password){
        requestpayload = new JSONObject();
        requestpayload.put("Email",email);
        requestpayload.put("Password",password);
    }
    //set header
    public void setHeader(String header, String content){
        SerenityRest
                .given()
                .header(header,content)
                .body(requestpayload.toString());
    }
    //click endpoint
    public void hitEndpointAuthentication(){
        SerenityRest
                .when()
                    .post(endpoint.Login);

    }
    //validasi response status code
    public void validateEndpointAuthentication(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }

}
