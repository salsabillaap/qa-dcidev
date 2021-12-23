@GETOrder

Feature: GET order
  As a user
  I want to get all data order and detail order by id
  So that I am success get data order

  #GET order BY id order Success
  Scenario: I want to get order by id order
    Given I am successfully login as customer
    When I am hit endpoint get order by id 58
    Then I am get a status code 200 for get oder by id
    And Validate response body code 200 message "Success Operation" for get order by id 58

  #GET order By id order Failed
  Scenario: I want to get order by invalid id order
    Given I am successfully login as customer
    When I am hit endpoint get order by id "enam"
    Then I am get a status code 400 for get oder by id
    And Validate response body code 400 message "Access Forbidden" for get order by id

  #GET all order by id group for admin
  Scenario: I want to get all order by id group
    Given I am successfully login as admin
    When I am hit endpoint get all order by id 17
    Then I am get a status code 200 for get all order by id
    And Validate response body code 200 message "Success Operation" for get all order by id 17

  #GET all order by Invalid id group for admin
  Scenario: I want to get all order by id group
    Given I am successfully login as admin
    When I am hit endpoint get all order by id "enam"
    Then I am get a status code 400 for get all order by id
    And Validate response body code 400 message "Access Forbidden" for get all order by id

  #GET all order by id user
  Scenario: I want to get all order by id user
    Given I am successfully login as customer
    When I am hit endpoint get all order by user id 38
    Then I am get a status code 200 for get ll order by user id
    And Validate response body code 200 message "Success Operation" for get all order by user id 38

  #GET all order by id user failed
  Scenario: I want to get all order by id user
    Given I am successfully login as customer
    When I am hit endpoint get all order by user id "tiga puluh delapan"
    Then I am get a status code 400 for get ll order by user id
    And Validate response body code 400 message "Access Forbidden" for get all order by user id
