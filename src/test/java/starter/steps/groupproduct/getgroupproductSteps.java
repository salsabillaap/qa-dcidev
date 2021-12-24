package starter.steps.groupproduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;


public class getgroupproductSteps extends BaseTest {

    //All Group Product
    @Given("I am set header {string} value {string}")
    public void iAmSetHeaderValue(String header, String content) {
        getgroupproduct.setHeader(header, content);
    }

    @When("I am hit endpoint all group product")
    public void iAmHitEndpointAllGroupProduct() {
        getgroupproduct.hitEndpointGetGroupProduct();
    }

    @Then("I am get status code {int} for get all group product")
    public void iAmGetStatusCodeForGetAllGroupProduct(int statuscode) {
        getgroupproduct.validateEndpointGET(statuscode);
    }

    @And("validate response body code {int} message {string} for all group product")
    public void validateResponseBodyCodeMessageForAllGroupProduct(int code, String message) {
        //getgroupproduct.JsonschemaGetAllGroupProduct(code, message);
    }

    //By Id Group
    @When("I am hit endpoint get group product by id {int}")
    public void iAmHitEndpointGetGroupProductById(int id) {
        getgroupproduct.hitEndpointGetIDGroup(id);
    }

    //By Id Group Invalid Id
    @When("I am hit endpoint get group product by id {string}")
    public void iAmHitEndpointGetGroupProductById(String invalidID) {
        getgroupproduct.hitEndpointGetIDGroupInvalidID(invalidID);
    }

    @Then("I am get status code {int} for get group product by id")
    public void iAmGetStatusCodeForGetGroupProductById(int statuscode) {
        getgroupproduct.validateEndpointGET(statuscode);
    }

    @And("validate response body code {int} message {string} for all group product {int}")
    public void validateResponseBodyCodeMessageSuccessOperationForAllGroupProduct(int code, String message, int id) {
        getgroupproduct.JsonschemaGetByIDGroupSuccess(code, message, id);
    }

    //By Id Group Invalid Id
    @And("validate response body failed code {int} message {string} for all group product by id")
    public void validateResponseBodyFailedCodeMessageInvalidIdForAllGroupProductById(int code, String message) {
        getgroupproduct.JsonschemaGetByIDGroupFailed(code, message);
    }


//*******//

    //By id Product
    @When("I am hit endpoint get all group product by id {int}")
    public void iAmHitEndpointGetAllGroupProductById(int id) {
        getgroupproduct.hitEndpointGetIDProduct(id);
    }

    //By id Product Invalid id
    @When("I am hit endpoint get all group product by id {string}")
    public void iAmHitEndpointGetAllGroupProductById(String invalidID) {
        getgroupproduct.hitEndpointGetIDProductInvalidID(invalidID);
    }

    @Then("I am get status code {int} for get all group product by id")
    public void iAmGetStatusCodeForGetAllGroupProductById(int statuscode) {
        getgroupproduct.validateEndpointGET(statuscode);
    }

    @And("validate response body code {int} message {string} for get all group product {int}")
    public void validateResponseBodyCodeMessageSuccessOperationForGetAllGroupProduct(int code, String message) {
        getgroupproduct.JsonschemaGetByIDProductSuccess(code, message);
    }

    //By id Product Invalid id
    @And("validate response body failed code {int} message {string} for get all group product by id")
    public void validateResponseBodyFailedCodeMessageSuccessOperationForGetAllGroupProductById(int code, String message) {
        getgroupproduct.JsonschemaGetByIDProductFailed(code, message);
    }

    //get status
    @When("I am hit endpoint get status product {string}")
    public void iAmHitEndpointGetStatusProduct(String Available) {
        getgroupproduct.hitEndpointGetAStatus(Available);
    }

    @Then("I am get status code {int} for get status product")
    public void iAmGetStatusCodeForGetStatusProduct(int statuscode) {
        getgroupproduct.validateEndpointGET(statuscode);
    }

    @And("validate response body code {int} message {string} for get status product")
    public void validateResponseBodyCodeMessageSuccessOperationForGetStatusProduct(int code, String message) {
        getgroupproduct.JsonschemaGetStatusProduct(code, message);
    }


}
