package starter.steps.order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

public class postordersSteps extends BaseTest {
    @Given("As a Customer")
    public void asACustomer() {
        postorders.HitEndpointLoginCustomer();
    }
    @Given("As a admin")
    public void asAAdmin() {
        postorders.HitEndpointLoginAdmin();
    }

    @And("set request body phone {string}")
    public void setRequestBodyPhone(String phone) {
        postorders.setrequestbodyphone(phone);
    }

    @And("set request body phone {string} as admin")
    public void setRequestBodyPhoneAsAdmin(String phone) {
        postorders.setrequestbodyphoneadmin(phone);
    }

    @When("I create new order in id_group {int}")
    public void iCreateNewOrderInId_group(int id) {
        postorders.HitEndpointPostOrderSuccess(id);
    }

    @Then("I get status code {int} for new order")
    public void iGetStatusCodeForNewOrder(int statuscode) {
        postorders.validateEndpointPostOrder(statuscode);
    }

    @And("Validate response body new order {int} and message {string} for order")
    public void validateResponseBodyNewOrderAndMessageForOrder(int code, String message) {
        postorders.JsonschemaEndpointPostOrderSuccess(code,message);
    }

    @And("Validate failed response body new order {int} and message {string} for order")
    public void validateFailedResponseBodyNewOrderAndMessageForOrder(int code, String message) {
        postorders.JsonschemaEndpointPostOrderFailed(code,message);
    }
}
