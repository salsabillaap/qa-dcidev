package starter.steps.product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class getproductSteps {

    @Given("I am set header {string} with value {string}")
    public void iAmSetHeaderWithValue(String arg0, String arg1) {
    }

    @When("I am hit endpoint get all product")
    public void iAmHitEndpointGetAllProduct() {
    }

    @Then("I am get a status code {int} for get all product")
    public void iAmGetAStatusCodeForGetAllProduct(int arg0) {
    }

    @And("validate response success get all product")
    public void validateResponseSuccessGetAllProduct() {
    }

}
