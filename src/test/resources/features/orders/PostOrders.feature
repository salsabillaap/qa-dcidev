@PostOrders
Feature: Create Order
  As a user customer
  i want to create new order
  so that i can order


  Scenario Outline: I want to create new order as customer with exist id group
    Given As a Customer
    And set request body phone "<phone>"
    When I create new order in id_group 16
    Then I get status code 200 for new order
    And Validate response body new order 200 and message "Success Operation" for order
    Examples:
    |phone|
    |082122122121|

  Scenario Outline: I want to create new order as admin
    Given As a admin
    And set request body phone "<phone>" as admin
    When I create new order in id_group 16
    Then I get status code 400 for new order
    And Validate failed response body new order 400 and message "Access Forbidden" for order
    Examples:
      |phone|
      |082122122121|

  Scenario Outline: I want to create new order as customer with unexis id group
    Given As a Customer
    And set request body phone "<phone>"
    When I create new order in id_group 1000
    Then I get status code 400 for new order
    And Validate failed response body new order 400 and message "Id Group Product Not Found" for order
    Examples:
      |phone|
      |082122122121|

  Scenario Outline: I want to create new order as customer with unavailable slot group product
    Given As a Customer
    And set request body phone "<phone>"
    When I create new order in id_group 14
    Then I get status code 400 for new order
    And Validate failed response body new order 400 and message "Group Product Full" for order
    Examples:
      |phone|
      |082122122121|


  Scenario Outline: I want to create new order as customer with 18 charracter phone number
    Given As a Customer
    And set request body phone "<phone>"
    When I create new order in id_group 2
    Then I get status code 400 for new order
    And Validate failed response body new order 400 and message "Invalid Telephone Number" for order
    Examples:
    |phone|
    |082122122122121111|