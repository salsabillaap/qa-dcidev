package starter.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

public class loginSteps extends BaseTest {

    @Given("I am set valid body request email {string} and password {string}")
    public void iAmSetValidBodyRequestEmailAndPassword(String email, String password) {
        login.setBodyRequest(email,password);
    }

    @And("I am set valid header {string} with fill {string}")
    public void iAmSetValidHeaderWithFill(String header, String content) {
        login.setHeader(header,content);
    }

    @When("I am hit endpoint")
    public void iAmHitEndpoint() {
        login.hitEndpointAuthentication();
    }

    @Then("I am get a status code {int} and valid response")
    public void iAmGetAStatusCodeOKAndValidResponse(int statuscode) {
        login.validateEndpointAuthentication(statuscode);
    }



}
