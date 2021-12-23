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

    @When("I am hit endpoint get order by id group {int}")
    public void iAmHitEndpointGetOrderByIdGroup(int id) {

    }

    @Then("I am get a status code {int} for get oder by id group")
    public void iAmGetAStatusCodeForGetOderByIdGroup(int arg0) {
    }

    @And("Validate response body code {int} message {string} for get order by id group")
    public void validateResponseBodyCodeMessageForGetOrderByIdGroup(int arg0, String arg1) {
    }
}
