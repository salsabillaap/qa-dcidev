package starter.steps.order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

public class getorderSteps extends BaseTest {

    //***** GET Order By ID
    @Given("I am successfully login as customer")
    public void iAmSuccessfullyLoginAsCustomer() {getorders.HitEndpointLoginCustomer();
    }

    @When("I am hit endpoint get order by id {int}")
    public void iAmHitEndpointGetOrderById(int id) {getorders.HitEndpointGetOrderByID(id);
    }

    // Hit Endpoint invalid id
    @When("I am hit endpoint get order by id {string}")
    public void iAmHitEndpointGetOrderById(String invalidId) {getorders.HitEndpointGetOrderByInvalidID(invalidId);
    }

    @Then("I am get a status code {int} for get oder by id")
    public void iAmGetAStatusCodeForGetOderById(int statuscode) {getorders.validateStatusCodeEndpoint(statuscode);
    }

    @And("Validate response body code {int} message {string} for get order by id {int}")
    public void validateResponseBodyCodeMessageForGetOrderById(int code, String message, int id) {getorders.jsonschemaEndpointGetOrderByIdOrder(code, message, id);
    }

    // invalid id
    @And("Validate response body code {int} message {string} for get order by id")
    public void validateResponseBodyCodeMessageForGetOrderById(int code, String message) {getorders.jsonschemaEndpointGetOrderByIdOrderFailed(code, message);
    }


    //***** GET all order by id group for admin
    @Given("I am successfully login as admin")
    public void iAmSuccessfullyLoginAsAdmin() {getorders.HitEndpointLoginAdmin();
    }

    @When("I am hit endpoint get all order by id {int}")
    public void iAmHitEndpointGetAllOrderById(int id) {getorders.HitEndpointGetAllOrderByIDGroup(id);
    }
    //invalid id
    @When("I am hit endpoint get all order by id {string}")
    public void iAmHitEndpointGetAllOrderById(String invalidId) {getorders.HitEndpointGetAllOrderByInvalidIDGroup(invalidId);
    }

    @Then("I am get a status code {int} for get all order by id")
    public void iAmGetAStatusCodeForGetAllOrderById(int statuscode) {getorders.validateStatusCodeEndpoint(statuscode);
    }

    @And("Validate response body code {int} message {string} for get all order by id {int}")
    public void validateResponseBodyCodeMessageForGetAllOrderById(int code, String message, int id) {getorders.jsonschemaEndpointGetAllOrderByIdGroup(code, message, id);
    }

    //invalid id
    @And("Validate response body code {int} message {string} for get all order by id")
    public void validateResponseBodyCodeMessageForGetAllOrderById(int code, String message) {getorders.jsonschemaEndpointGetAllOrderByIdGroupFailed(code, message);
    }


    //***** GET all order by id user
    @When("I am hit endpoint get all order by user id {int}")
    public void iAmHitEndpointGetAllOrderByUserId(int id) {getorders.HitEndpointGetAllOrderByIDUser(id);
    }

    // invalid id
    @When("I am hit endpoint get all order by user id {string}")
    public void iAmHitEndpointGetAllOrderByUserId(String invalidId) {getorders.HitEndpointGetAllOrderByInvalidIDUser(invalidId);
    }

    @Then("I am get a status code {int} for get ll order by user id")
    public void iAmGetAStatusCodeForGetLlOrderByUserId(int statuscode) {getorders.validateStatusCodeEndpoint(statuscode);
    }

    @And("Validate response body code {int} message {string} for get all order by user id {int}")
    public void validateResponseBodyCodeMessageForGetAllOrderByUserId(int code, String message, int id) {getorders.jsonschemaEndpointGetAllOrderByIduser(code, message, id);
    }

    //invalid id
    @And("Validate response body code {int} message {string} for get all order by user id")
    public void validateResponseBodyCodeMessageForGetAllOrderByUserId(int code, String message) {getorders.jsonschemaEndpointGetAllOrderByIdUserFailed(code, message);
    }
}
