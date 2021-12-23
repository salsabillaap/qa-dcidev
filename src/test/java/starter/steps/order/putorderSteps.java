package starter.steps.order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

public class putorderSteps extends BaseTest {
    @Given("I am login as a admin")
    public void iAmLoginAsAAdmin() {putorders.HitEndpointLoginAdmin();
    }

    @And("I am set body request email {string} password {string}")
    public void iAmSetBodyRequestEmailPassword(String email, String password) {putorders.setRequestPayloadUpdateOrder(email, password);
    }

    @When("I am hit endpoint put update order by {int}")
    public void iAmHitEndpointPutUpdateOrderBy(int id) {putorders.HitEndpointPutOrderByID(id);
    }

    //invalid
    @When("I am hit endpoint put update order by {string}")
    public void iAmHitEndpointPutUpdateOrderBy(String invalidId) {putorders.HitEndpointPutOrderByIDFailed(invalidId);
    }

    @Then("I am get a status code {int} for update order")
    public void iAmGetAStatusCodeForUpdateOrder(int statuscode) {putorders.validateStatusCodeEndpoint(statuscode);
    }

    @And("validate response body code {int} message {string} for put update order")
    public void validateResponseBodyCodeMessageForPutUpdateOrder(int code, String message) {putorders.JsonschemaEndpointPutOrderSuccess(code, message);
    }

    @And("validate response body failed code {int} message {string} for put update order")
    public void validateResponseBodyFailedCodeMessageForPutUpdateOrder(int code, String message) {putorders.JsonschemaEndpointPutOrderFailed(code, message);
    }


}
