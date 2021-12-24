@DeleteProduct
Feature: Delete Product
  As a Admin
  I want to delete product by id
  So that I am success delete product

  Scenario: I want to delete product by id as admin
    Given I am already logged in as admin
    When I am hit endpoint delete product by id 10
    Then I am get a status code 200 for delete product
    And validate response body code 200 message "Success Operation" for delete product

  Scenario: I want to delete product by id as customer
    Given I'm already logged in as customer
    When I am hit endpoint delete product by id 14
    Then I am get a status code 400 for delete product
    And validate response body code 400 message "Access Forbidden" for delete product

  Scenario: I want to delete product by id not exist as admin
    Given I am already logged in as admin
    When I am hit endpoint delete product by id 14
    Then I am get a status code 400 for delete product
    And validate response body failed code 400 message "Data Not Found" for delete product

  Scenario: I want to delete product by invalid id as admin
    Given I am already logged in as admin
    When I am hit endpoint delete product by id "lima"
    Then I am get a status code 400 for delete product
    And validate response body failed code 400 message "Invalid Id" for delete product