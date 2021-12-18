package starter.steps.users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

public class deleteUsersSteps extends BaseTest {

    @Given("I'm login as admin")
    public void iMLoginAsAdmin() {
        deleteUser.HitEndpointLoginAdmin();
    }
    @Given("I'm login as customer")
    public void iMLoginAsCustomer() {
        deleteUser.HitEndpointLoginCustomer();
    }

    @When("I delete user customer id {int}")
    public void iDeleteUserCustomerId(int id) {
        deleteUser.HitEndpointDeleteUserSuccess(id);
    }
    @Then("I get status code {int} for delete users")
    public void iGetStatusCodeForDeleteUsers(int statuscode) {
        deleteUser.validateStatusCodeEndpointDeleteUser(statuscode);
    }
    @And("Validate response body {int} and message {string} for delete users")
    public void validateResponseBodyAndMessageForDeleteUsers(int code, String message) {
        deleteUser.JsonschemaEndpointDeleteUserSuccess(code, message);
    }

    @And("Validate failed respon body {int} and message {string}")
    public void validateFailedResponBodyAndMessage(int code, String message) {
        deleteUser.JsonschemaEndpointDeleteUserFailed(code,message);
    }

    @When("I delete user customer id {string}")
    public void iDeleteUserCustomerId(String invalidId) {
        deleteUser.HitEndpointDeleteUserFailed(invalidId);
    }

}
