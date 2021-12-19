package starter.steps.groupproduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

public class postgroupproductSteps extends BaseTest {
    @Given("as customer login")
    public void asCustomerLogin() {
        postgroupproduct.HitEndpointLoginCustomer();
    }
    @Given("as admin login")
    public void asAdminLogin() {
        postgroupproduct.HitEndpointLoginAdmin();
    }
    @And("I am set header")
    public void iAmSetHeader() {
        postgroupproduct.SetHeaderPostGroupProduct();
    }

    @When("I am hit endpoint group product by id product {int}")
    public void iAmHitEndpointGroupProductByIdProduct(int id) {
        postgroupproduct.HitEndpointPostGroupProductSuccess(id);
    }

    @Then("I am get a status code {int} post group product")
    public void iAmGetAStatusCodePostGroupProduct(int statuscode) {
        postgroupproduct.validateEndpointPostGroupProduct(statuscode);
    }

    @And("validate response body code {int} message {string} for post group product")
    public void validateResponseBodyCodeMessageForPostGroupProduct(int code, String message) {
        postgroupproduct.JsonschemaEndpointPostGroupProductSuccess(code,message);
    }


    @And("validate response body failed code {int} message {string} for post group product")
    public void validateResponseBodyFailedCodeMessageForPostGroupProduct(int code, String message) {
        postgroupproduct.JsonschemaEndpointPostGroupProductFailed(code,message);
    }
}
