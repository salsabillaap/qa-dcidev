@DeleteGroupProduct
Feature: DELETE group product by id group product for admin
  As a admin
  I want to delete a group product by id group product
  So that i am success delete group product

  #success
  Scenario: I want to delete group product by id group product as admin
    Given I am log in as admin
    When I am hit endpoint delete group product by id group product 21
    Then I am get a status code 200 for delete group product
    And validate response body code 200 message "Success Operation" for delete group product

  #failed
  Scenario: I want to delete group product by id group product as customer
    Given I am log in as customer
    When I am hit endpoint delete group product by id group product 21
    Then I am get a status code 400 for delete group product
    And validate response body code 400 message "Access Forbidden" for delete group product

  #failed
  Scenario: I want to delete group product by id group product not exist as admin
    Given I am log in as admin
    When I am hit endpoint delete group product by id group product 500
    Then I am get a status code 400 for delete group product
    And validate response body code 400 message "Data Not Found" for delete group product

  #failed
  Scenario: I want to delete group product by invalid id group product as admin
    Given I am log in as admin
    When I am hit endpoint delete group product by id group product "lima"
    Then I am get a status code 400 for delete group product
    And validate response body code 400 message "Invalid Id" for delete group product

