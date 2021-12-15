package starter.steps.product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

public class postproductSteps extends BaseTest {
    //POST Create Product
    @Given("I am logged in as user admin")
    public void iAmLoggedInAsUserAdmin() {
        postproducts.HitEndpointLoginAdmin();
    }

    @Given("I am logged in as user customer")
    public void iAmLoggedInAsUserCustomer() {
        postproducts.HitEndpointLoginCustomer();
    }

    @And("I am set body request {string} {string} price {int} limit {int}")
    public void iAmSetBodyRequestPriceLimit(String name_product, String detail_product, int price, int limit) {
        postproducts.setRequestPayloadCreateProduct(name_product,detail_product,price,limit);
    }
    //price dan limit format string
    @And("I am set body request {string} {string} price {string} limit {string}")
    public void iAmSetBodyRequestPriceLimit(String name_product, String detail_product , String price, String limit) {
        postproducts.setRequestPayloadCreateProductFailed(name_product,detail_product,price,limit);
    }
    //invalid file photo extension
    @And("I am set body request {string} {string} price {int} limit {int} {string}")
    public void iAmSetBodyRequestPriceLimit(String name_product, String detail_product, int price, int limit, String ext) {
        postproducts.RequestPayloadFailedExtension(name_product,detail_product,price,limit,ext);
    }
    //name header photo salah
    @And("I am set body request {string} {string} price {int} limit {int} photo {string}")
    public void iAmSetBodyRequestPriceLimitPhoto(String name_product, String detail_product, int price, int limit, String ext) {
        postproducts.RequestPayloadFailedUpload(name_product,detail_product,price,limit,ext);
    }

    @When("I am hit endpoint product method post")
    public void iAmHitEndpointProductMethodPost() {
        postproducts.hitEnpointPostCreateProduct();
    }

    @Then("I am get a status code {int} post product")
    public void iAmGetAStatusCodePostProduct(int statuscode) {
        postproducts.validateEndpointPostCreateProduct(statuscode);
    }

    @And("validate response success create product {string}")
    public void validateResponseSuccessCreateProduct(String message) {
        postproducts.JsonschemaEndpointPostProductSuccess(message);
    }

    @And("validate response body code {int} message {string}")
    public void validateResponseBodyCodeMessage(int code, String message) {
        postproducts.JsonschemaEndpointPostProductFailed(code,message);
    }

}
