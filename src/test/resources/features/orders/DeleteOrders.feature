@DeleteOrders
Feature: Delete Orders
  As a admin
  i want to delete order by id order
  so that i can delete order

  Scenario: I want to delete order by id as admin
    Given I'm a admin
    When I delete order with id 55
    Then I get status code 200 for delete order
    And Validate response body 200 and message "Success Operation" for delete order

  Scenario: I want to delete order by id not exist as admin
    Given I'm a admin
    When I delete order with id 1000
    Then I get status code 400 for delete order
    And Validate failed delete order respon body 400 and message "Data Not Found"

  Scenario: I want to delete order by invalid id as admin
    Given I'm a admin
    When I delete order with id "rahmanto"
    Then I get status code 400 for delete order
    And Validate failed delete order respon body 400 and message "Invalid Id"

  Scenario: I want to delete order by id as customer
    Given I'm a customer
    When I delete order with id 40
    Then I get status code 400 for delete order
    And Validate failed delete order respon body 400 and message "Access Forbidden"