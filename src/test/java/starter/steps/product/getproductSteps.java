package starter.steps.product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class getproductSteps {
    @Given("I want to see detail product by id")
    public void iWantToSeeDetailProductById() {
    }

    @When("I am hit endpoint product method get")
    public void iAmHitEndpointProductMethodGet() {
    }

    @Then("I am get a status code {int} get product")
    public void iAmGetAStatusCodeGetProduct(int statuscode) {
    }

    @And("validate response success product by id")
    public void validateResponseSuccessProductById() {
    }
}
