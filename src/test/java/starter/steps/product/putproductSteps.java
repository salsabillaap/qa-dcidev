package starter.steps.product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

public class putproductSteps extends BaseTest {
    @Given("I'm already logged in as admin")
    public void iMAlreadyLoggedInAsAdmin() {
        putproduct.HitEndpointLoginAdmin();
    }
    @Given("I am already logged in as customer")
    public void iAmAlreadyLoggedInAsCustomer() {
        putproduct.HitEndpointLoginCustomer();
    }
    @And("I am set body request name product {string} detail product {string} price {int} limit {int}")
    public void iAmSetBodyRequestNameProductDetailProductPriceLimit(String name, String detail, int price, int limit) {
        putproduct.setRequestPayloadUpdateProduct(name,detail,price,limit);
    }

    @When("I am hit endpoint put update product by {int}")
    public void iAmHitEndpointPutUpdateProductBy(int id) {
        putproduct.hitEnpointPutUpdateProduct(id);
    }

    @When("I am hit endpoint put update product by {string}")
    public void iAmHitEndpointPutUpdateProductBy(String invalidId) {
        putproduct.hitEnpointPutUpdateProduct(invalidId);
    }

    @Then("I am get a status code {int} for update product")
    public void iAmGetAStatusCodeForUpdateProduct(int statuscode) {
        putproduct.validateEndpointPutUpdateProduct(statuscode);
    }

    @And("validate response body code {int} message {string} for put update product")
    public void validateResponseBodyCodeMessageForPutUpdateProduct(int code, String message) {
        putproduct.JsonschemaEndpointPutProductSuccess(code,message);
    }

    @And("validate response body failed code {int} message {string} for put update product")
    public void validateResponseBodyFailedCodeMessageForPutUpdateProduct(int code, String message) {
        putproduct.JsonschemaEndpointPutProductFailed(code,message);
    }

}
