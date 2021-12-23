package starter.steps.order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

public class putorderSteps extends BaseTest {
    @Given("I am login as a admin")
    public void iAmLoginAsAAdmin() {
        putorders.HitEndpointLoginAdmin();
    }

    @Given("I am login as a customer")
    public void iAmLoginAsACustomer() {
        putorders.HitEndpointLoginCustomer();
    }

    @And("I am set body request details {string}")
    public void iAmSetBodyRequestDetails(String details) {
        putorders.setRequestPayloadUpdateOrder(details);
    }

    @When("I am hit endpoint put update order by id {int}")
    public void iAmHitEndpointPutUpdateOrderById(int id) {
        putorders.HitEndpointPutOrderByID(id);
    }

    //invalid
    @When("I am hit endpoint put update order by id {string}")
    public void iAmHitEndpointPutUpdateOrderById(String invalidid) {
        putorders.HitEndpointPutOrderByIDFailed(invalidid);
    }

    @Then("I am get a status code {int} for update order")
    public void iAmGetAStatusCodeForUpdateOrder(int statuscode) {
        putorders.validateStatusCodeEndpoint(statuscode);
    }

    @And("validate response body code {int} message {string} for put update order")
    public void validateResponseBodyCodeMessageForPutUpdateOrder(int code, String message) {
        putorders.JsonschemaEndpointPutOrderSuccess(code, message);
    }

    @And("validate response body failed code {int} message {string} for put update order")
    public void validateResponseBodyFailedCodeMessageForPutUpdateOrder(int code, String message) {
        putorders.JsonschemaEndpointPutOrderFailed(code, message);
    }


}
