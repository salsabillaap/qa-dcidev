package starter.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

public class loginSteps extends BaseTest {

    @Given("I am set body request email {string} and password {string}")
    public void iAmSetBodyRequestEmailAndPassword(String email, String password) {
        login.setRequestPayload(email,password);
    }

    @And("I am set valid header {string} with fill {string}")
    public void iAmSetValidHeaderWithFill(String header, String content) {
        //login.setBodyRequest();
        login.setHeader(header,content);
    }

    @When("I am hit endpoint login")
    public void iAmHitEndpointLogin() {
        login.hitEndpointLogin();
    }

    @Then("I am get a status code {int}")
    public void iAmGetAStatusCode(int statuscode) {
        login.validateEndpointLogin(statuscode);
    }

    @And("valid response success")
    public void validResponseSuccess() {
        login.JsonschemaEndpointLoginSuccess();
    }

    @And("valid response failed")
    public void validResponseFailed() {
        login.JsonschemaEndpointLoginFailed();
    }


}
