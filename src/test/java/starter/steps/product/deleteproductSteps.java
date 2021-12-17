package starter.steps.product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

public class deleteproductSteps extends BaseTest {

    @Given("I am already logged in as admin")
    public void iAmAlreadyLoggedInAsAdmin() {
        deleteproduct.HitEndpointLoginAdmin();
    }

    @Given("I'm already logged in as customer")
    public void iMAlreadyLoggedInAsCustomer() {
        deleteproduct.HitEndpointLoginCustomer();
    }

    @When("I am hit endpoint delete product by id {int}")
    public void iAmHitEndpointDeleteProductById(int id) {
        deleteproduct.HitEndpointDeleteProduct(id);
    }
    @When("I am hit endpoint delete product by id {string}")
    public void iAmHitEndpointDeleteProductById(String invalidId) {
        deleteproduct.HitEndpointDeleteProductFailed(invalidId);
    }

    @Then("I am get a status code {int} for delete product")
    public void iAmGetAStatusCodeForDeleteProduct(int statuscode) {
        deleteproduct.validateStatusCodeEndpointDeleteProduct(statuscode);
    }

    @And("validate response body code {int} message {string} for delete product")
    public void validateResponseBodyCodeMessageForDeleteProduct(int code, String message) {
        deleteproduct.JsonschemaEndpointDeleteProductSuccess(code,message);
    }

    @And("validate response body failed code {int} message {string} for delete product")
    public void validateResponseBodyFailedCodeMessageForDeleteProduct(int code, String message) {
        deleteproduct.JsonschemaEndpointDeleteProductFailed(code,message);
    }

}
