@GETgroupproduct

Feature: GET Group Product and by ID
  As a user
  I want to see all group product and details group product
  So that I am success get group product

  @test #SUCCESS
  Scenario: I wont to see all group product
    Given I am set header 'Content-Type' value 'application/json'
    When  I am hit endpoint all group product
    Then I am get status code 200 for get all group product
    And validate response body code 200 message 'Success Operation' for all group product

  #SUCCESS
  Scenario: I wont to see detail group product by id group
    Given I am set header 'Content-Type' value 'application/json'
    When  I am hit endpoint get group product by id 1
    Then I am get status code 200 for get group product by id
    And validate response body code 200 message 'Success Operation' for all group product 1

  #FAILED
  Scenario: I wont to see detail group product by invalid id group
    Given I am set header 'Content-Type' value 'application/json'
    When  I am hit endpoint get group product by id "satu"
    Then I am get status code 400 for get group product by id
    And validate response body failed code 400 message 'Invalid Id' for all group product by id

  #SUCCESS #error validation jsonschema
  Scenario: I wont to see detail group product by id product
    Given I am set header 'Content-Type' value 'application/json'
    When I am hit endpoint get all group product by id 1
    Then I am get status code 200 for get all group product by id

  #FAILED
  Scenario: I wont to see detail all group product by invalid id product
    Given I am set header 'Content-Type' value 'application/json'
    When I am hit endpoint get all group product by id "dua"
    Then I am get status code 400 for get all group product by id
    And validate response body failed code 400 message 'Invalid Id' for get all group product by id

  #SUCCESS
  Scenario: I wont to see available product
    Given I am set header 'Content-Type' value 'application/json'
    When I am hit endpoint get status product "available"
    Then I am get status code 200 for get status product
    And validate response body code 200 message 'Success Operation' for get status product



