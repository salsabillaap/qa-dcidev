package starter.steps.order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

public class deleteordersSteps extends BaseTest {

    @Given("I'm a admin")
    public void iMAAdmin() {
        deleteorders.HitEndpointLoginAdmin();
    }

    @When("I delete order with id {int}")
    public void iDeleteOrderWithId(int id) {
        deleteorders.HitEndpointDeleteOrderSuccess(id);
    }

    @Then("I get status code {int} for delete order")
    public void iGetStatusCodeForDeleteOrder(int statuscode) {
        deleteorders.validateStatusCodeEndpointDeleteOrder(statuscode);
    }

    @And("Validate response body {int} and message {string} for delete order")
    public void validateResponseBodyAndMessageForDeleteOrder(int code, String message) {
        deleteorders.JsonschemaEndpointDeleteOrderSuccess(code,message);
    }

    @And("Validate failed delete order respon body {int} and message {string}")
    public void validateFailedDeleteOrderResponBodyAndMessage(int code, String message) {
        deleteorders.JsonschemaEndpointDeleteOrderFailed(code,message);
    }

    @When("I delete order with id {string}")
    public void iDeleteOrderWithId(String invalidid) {
        deleteorders.HitEndpointDeleteOrderFailedInvalidID(invalidid);
    }

    @Given("I'm a customer")
    public void iMACustomer() {
        deleteorders.HitEndpointLoginCustomer();
    }
}
