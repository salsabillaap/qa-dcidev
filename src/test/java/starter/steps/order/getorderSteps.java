package starter.steps.order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

public class getorderSteps extends BaseTest {

    //***** GET Order By ID
    @Given("I am successfully login as customer")
    public void iAmSuccessfullyLoginAsCustomer() {
        getorders.HitEndpointLoginCustomer();
    }

    @Given("I am successfully login as admin")
    public void iAmSuccessfullyLoginAsAdmin() {
        getorders.HitEndpointLoginAdmin();
    }

    @When("I am hit endpoint get order by id {int}")
    public void iAmHitEndpointGetOrderById(int id) {
        getorders.HitEndpointGetOrderByID(id);
    }

    // Hit Endpoint invalid id
    @When("I am hit endpoint get order by id {string}")
    public void iAmHitEndpointGetOrderById(String invalidId) {
        getorders.HitEndpointGetOrderByInvalidID(invalidId);
    }

    @Then("I am get a status code {int} for get oder by id")
    public void iAmGetAStatusCodeForGetOderById(int statuscode) {
        getorders.validateStatusCodeEndpoint(statuscode);
    }

    @And("Validate response body success code {int} message {string} for get order by id {int}")
    public void validateResponseBodySuccessCodeMessageForGetOrderById(int code, String message, int idorder) {
        getorders.jsonschemaEndpointGetOrderByIdOrder(code,message,idorder);
    }


    @And("Validate response body failed code {int} message {string} for get order by id order")
    public void validateResponseBodyFailedCodeMessageForGetOrderByIdOrder(int code, String message) {
        getorders.jsonschemaEndpointGetOrderByIdOrderFailed(code,message);
    }


    @When("I am hit endpoint get order by id group {int}")
    public void iAmHitEndpointGetOrderByIdGroup(int id) {
        getorders.HitEndpointGetAllOrderByIDGroup(id);
    }

    @When("I am hit endpoint get order by id group {string}")
    public void iAmHitEndpointGetOrderByIdGroup(String InvalidId) {
        getorders.HitEndpointGetAllOrderByInvalidIDGroup(InvalidId);
    }

    @Then("I am get a status code {int} for get oder by id group")
    public void iAmGetAStatusCodeForGetOderByIdGroup(int statuscode) {
        getorders.validateStatusCodeEndpoint(statuscode);
    }

    @And("Validate response body code {int} message {string} for get order by id group")
    public void validateResponseBodyCodeMessageForGetOrderByIdGroup(int code, String message) {
        getorders.jsonschemaEndpointGetAllOrderByIdGroup(code,message);
    }

    @And("Validate response body failed code {int} message {string} for get order by id group")
    public void validateResponseBodyFailedCodeMessageForGetOrderByIdGroup(int code, String message) {
        getorders.jsonschemaEndpointGetAllOrderByIdGroupFailed(code,message);
    }


    @When("I am hit endpoint get order by id user {int}")
    public void iAmHitEndpointGetOrderByIdUser(int id) {
        getorders.HitEndpointGetAllOrderByIDUser(id);
    }

    @Then("I am get a status code {int} for get oder by id user")
    public void iAmGetAStatusCodeForGetOderByIdUser(int statuscode) {
        getorders.validateStatusCodeEndpoint(statuscode);
    }

    @And("Validate response body code {int} message {string} for get order by id user")
    public void validateResponseBodyCodeMessageForGetOrderByIdUser(int code, String message) {
        getorders.jsonschemaEndpointGetAllOrderByIduser(code,message);
    }

    @And("Validate response body failed code {int} message {string} for get order by id user")
    public void validateResponseBodyFailedCodeMessageForGetOrderByIdUser(int code, String message) {
        getorders.jsonschemaEndpointGetAllOrderByIdUserFailed(code, message);
    }

    @When("I am hit endpoint get order by id user {string}")
    public void iAmHitEndpointGetOrderByIdUser(String InvalidID) {
        getorders.HitEndpointGetAllOrderByInvalidIDUser(InvalidID);
    }
}
