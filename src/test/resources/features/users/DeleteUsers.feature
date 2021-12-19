@DeleteUsers
Feature: Delete Users
  As a user admin
  i want to delete user account by id
  so that i can delete account customer

  Scenario: I want to delete account by id as admin
    Given I'm login as admin
    When I delete user customer id 35
    Then I get status code 200 for delete users
    And Validate response body 200 and message "Success Operation" for delete users

  Scenario: I want to delete account by id not exist as admin
    Given I'm login as admin
    When I delete user customer id 37
    Then I get status code 400 for delete users
    And Validate failed respon body 400 and message "Data Not Found"

  Scenario: I want to delete account by invalid id as admin
    Given I'm login as admin
    When I delete user customer id "rahmanto"
    Then I get status code 400 for delete users
    And Validate failed respon body 400 and message "Invalid Id"

  Scenario: I want to delete account by id as customer
    Given I'm login as customer
    When I delete user customer id 77
    Then I get status code 400 for delete users
    And Validate failed respon body 400 and message "Access Forbidden"
