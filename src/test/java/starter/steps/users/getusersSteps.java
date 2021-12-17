package starter.steps.users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

public class getusersSteps extends BaseTest {

    @Given("I am success login as admin")
    public void iAmSuccessLoginAsAdmin() {
        getusers.HitEndpointLoginAdmin();
    }

    @Given("I am success login as customer")
    public void iAmSuccessLoginAsCustomer() {
        getusers.HitEndpointLoginCustomer();
    }

    //Get All Users
    @When("I am hit endpoint get all users")
    public void iAmHitEndpointGetAllUsers() {
        getusers.HitEndpointGetAllUsers();
    }

    @Then("I am get a status code {int} for get all users")
    public void iAmGetAStatusCodeForGetAllUsers(int statuscode) {
        getusers.validateStatusCodeEndpoint(statuscode);
    }

    @And("validate response body code {int} message {string} for get all users")
    public void validateResponseBodyCodeMessageForGetAllUsers(int code, String message) {
        getusers.jsonschemaEnpointGetAllUsersSuccess(code,message);
    }

    @And("validate response body failed code {int} message {string} for get all users")
    public void validateResponseBodyFailedCodeMessageForGetAllUsers(int code, String message) {
        getusers.jsonschemaEndpointGetAllUsersFailed(code,message);
    }

    //GET Users By ID
    @When("I am hit endpoint get user by id {int}")
    public void iAmHitEndpointGetUserById(int id) {
        getusers.HitEndpointGetUsersByID(id);
    }
    //HIT ENDPOINT INVALID ID
    @When("I am hit endpoint get user by id {string}")
    public void iAmHitEndpointGetUserById(String invaliId) {
        getusers.HitEndpointGetUsersByInvalidID(invaliId);
    }

    @Then("I am get a status code {int} for get users by id")
    public void iAmGetAStatusCodeForGetUsersById(int statuscode) {
        getusers.validateStatusCodeEndpoint(statuscode);
    }

    @And("validate response body code {int} message {string} for get users by id {int}")
    public void validateResponseBodyCodeMessageForGetUsersById(int code, String message, int id) {
        getusers.jsonschemaEndpointGetUsersByIDSuccess(code,message,id);
    }

    @And("validate response body code {int} message {string} for get users by id")
    public void validateResponseBodyCodeMessageForGetUsersById(int code, String message) {
        getusers.jsonschemaEndpointGetUsersByIDFailed(code,message);
    }


}
