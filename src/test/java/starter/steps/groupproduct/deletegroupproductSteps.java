package starter.steps.groupproduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

public class deletegroupproductSteps extends BaseTest {

    @Given("I am log in as admin")
    public void iAmLogInAsAdmin() {
        deletegroupproduct.HitEndpointLoginAdmin();
    }

    @Given("I am log in as customer")
    public void iAmLogInAsCustomer() {
        deletegroupproduct.HitEndpointLoginCustomer();
    }

    @When("I am hit endpoint delete group product by id group product {int}")
    public void iAmHitEndpointDeleteGroupProductByIdGroupProduct(int idgroupproduct) {
        deletegroupproduct.HitEndpointDeleteGroupProduct(idgroupproduct);
    }

    @When("I am hit endpoint delete group product by id group product {string}")
    public void iAmHitEndpointDeleteGroupProductByIdGroupProduct(String invalidid) {
        deletegroupproduct.HitEndpointDeleteGroupProductInvalidID(invalidid);
    }

    @Then("I am get a status code {int} for delete group product")
    public void iAmGetAStatusCodeForDeleteGroupProduct(int statuscode) {
        deletegroupproduct.validateStatusCodeEndpointDeleteGroupProduct(statuscode);
    }

    @And("validate response body code {int} message {string} for delete group product")
    public void validateResponseBodyCodeMessageForDeleteGroupProduct(int code, String message) {
        deletegroupproduct.JsonschemaEndpointDeleteGroupProduct(code,message);
    }

}
