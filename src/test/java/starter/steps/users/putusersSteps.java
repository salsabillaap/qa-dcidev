package starter.steps.users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

public class putusersSteps extends BaseTest {

    @Given("login as admin")
    public void loginAsAdmin() {
        putusers.HitEndpointLoginAdmin();
    }

    @Given("login as customer")
    public void loginAsCustomer() {
        putusers.HitEndpointLoginCustomer();
    }

    @And("I am update data {string} {string} {string} {string}")
    public void iAmUpdateData(String name, String email, String password, String phone) {
        putusers.setRequestPayloadUpdateUsers(name, email, password, phone);
    }

    @When("I am hit endpoint put users by id {int}")
    public void iAmHitEndpointPutUsersById(int id) {
        putusers.HitEndpointUpdateUsers(id);
    }

    //invalid id
    @When("I am hit endpoint put users by id {string}")
    public void iAmHitEndpointPutUsersById(String invalidId) {
        putusers.HitEndpointUpdateUsersFailed(invalidId);
    }

    @Then("I am get a status code {int} for update users")
    public void iAmGetAStatusCodeForUpdateUsers(int statuscode) {
        putusers.validateEndpointUpdateUsers(statuscode);
    }

    @And("validate response body code {int} message {string} for update users")
    public void validateResponseBodyCodeMessageForUpdateUsers(int code, String message) {
        putusers.JsonschemaEndpointUpdateUsersSuccess(code, message);
    }

    @And("validate response body failed code {int} message {string} for update users")
    public void validateResponseBodyFailedCodeMessageForUpdateUsers(int code, String message) {
        putusers.JsonschemaEndpointUpdateUsersFailed(code, message);
    }
}
