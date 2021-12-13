package starter.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

public class signupSteps extends BaseTest {
    @Given("I am set body request for signup name {string} email {string} password {string} phone {string}")
    public void iAmSetBodyRequestForSignupNameEmailPasswordPhone(String name, String email, String password, String phone) {
        signup.setRequestPayload(name,email,password,phone);
    }

    @And("I am set valid header for signup {string} with fill {string}")
    public void iAmSetValidHeaderForSignupWithFill(String header, String content) {
        signup.setHeader(header,content);
    }

    @When("I am hit endpoint signup")
    public void iAmHitEndpointSignup() {
        signup.hitEndpointSignup();
    }

    @Then("I am get a status code {int} signup")
    public void iAmGetAStatusCodeSignup(int statuscode) {
        signup.validateEndpointSignup(statuscode);
    }

    @And("validate response success signup")
    public void validateResponseSuccessSignup() {
    }

    @And("validate error message Email or Telephone Number Already Exist")
    public void validateErrorMessageEmailOrTelephoneNumberAlreadyExist() {

    }

    @And("validate error message Password must consist of six characters or more")
    public void validateErrorMessagePasswordMustConsistOfSixCharactersOrMore() {
    }

    @And("validate error message Invalid Name")
    public void validateErrorMessageInvalidName() {
    }

    @And("validate error message Invalid Email")
    public void validateErrorMessageInvalidEmail() {
    }

    @And("validate error message Invalid Password")
    public void validateErrorMessageInvalidPassword() {
    }
}
