package starter.steps.product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

public class getproductSteps extends BaseTest {

    @Given("I am set header {string} with value {string}")
    public void iAmSetHeaderWithValue(String header, String content) {
        getproduct.setHeader(header,content);
    }

    @When("I am hit endpoint get all product")
    public void iAmHitEndpointGetAllProduct() {
        getproduct.hitEndpointGetProduct();
    }
    //hit invalid endpoint
    @When("I am hit invalid endpoint get all product")
    public void iAmHitInvalidEndpointGetAllProduct() {
        getproduct.hitInvalidEndpointGetProduct();
    }

    @Then("I am get a status code {int} for get all product")
    public void iAmGetAStatusCodeForGetAllProduct(int statuscode) {
        getproduct.validateEndpointGET(statuscode);
    }

    @And("validate response body code {int} message {string} for get all product")
    public void validateResponseBodyCodeMessageForGetAllProduct(int code, String message) {
        getproduct.JsonschemaGetAllProductSuccess(code,message);
    }

    @And("validate response body failed code {int} message {string} for get all product")
    public void validateResponseBodyFailedCodeMessageForGetAllProduct(int code, String message) {
        getproduct.JsonschemaGetAllProductFailed(code,message);
    }

    //GET Product By ID
    @When("I am hit endpoint get product by id {int}")
    public void iAmHitEndpointGetProductById(int id) {
        getproduct.hitEndpointGetProductID(id);
    }
    //GET Product By Invalid ID
    @When("I am hit endpoint get product by id {string}")
    public void iAmHitEndpointGetProductById(String invalidID) {
        getproduct.hitEndpointGetProductInvalidID(invalidID);
    }

    @Then("I am get a status code {int} for get product by id")
    public void iAmGetAStatusCodeForGetProductById(int statuscode) {
        getproduct.validateEndpointGET(statuscode);
    }

    @And("validate response body code {int} message {string} for get product by id {int}")
    public void validateResponseBodyCodeMessageForGetProductById(int code, String message, int id) {
        getproduct.JsonschemaGetProductByIDSuccess(code,message,id);
    }

    @And("validate response body failed code {int} message {string} for get product by id")
    public void validateResponseBodyFailedCodeMessageForGetProductById(int code, String message) {
        getproduct.JsonschemaGetProductByIDFailed(code,message);
    }
}
