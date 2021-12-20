@GETgroupproduct

Feature: GET Group Product and by ID
  As a user
  I want to see all group product and details group product
  So that I am success get group product

  @TC_1 #SUCCESS
  Scenario: I wont to see all group product
    Given I am set header 'Content-Type' value 'application/json'
    When  I am hit endpoint all group product
    Then I am get status code 200 for get all group product
    And validate response body code 200 message 'Success Operation' for all group product

  @TC_2 #SUCCESS
  Scenario: I wont to see detail group product by id group
    Given I am set header 'Content-Type' value 'application/json'
    When  I am hit endpoint get group product by id 1
    Then I am get status code 200 for get group product by id
    And validate response body code 200 message 'Success Operation' for all group product 1

  @TC_3 #FAILED
  Scenario: I wont to see detail group product by invalid id group
    Given I am set header 'Content-Type' value 'application/json'
    When  I am hit endpoint get group product by id "satu"
    Then I am get status code 400 for get group product by id
    And validate response body failed code 400 message 'Invalid Id' for all group product by id


    #belum bener, mas wahyu tolong haha
  @TC_4 #SUCCESS
  Scenario: I wont to see detail group product by id product
    Given I am set header 'Content-Type' value 'application/json'
    When I am hit endpoint get all group product by id 1
    Then I am get status code 200 for get all group product by id
    And validate response body code 200 message 'Success Operation' for get all group product 1

  @TC_5 #FAILED
  Scenario: I wont to see detail all group product by invalid id product
    Given I am set header 'Content-Type' value 'application/json'
    When I am hit endpoint get all group product by id "dua"
    Then I am get status code 400 for get all group product by id
    And validate response body failed code 400 message 'Invalid Id' for get all group product by id

  @TC_6 #SUCCESS
  Scenario: I wont to see available product
    Given I am set header 'Content-Type' value 'application/json'
    When I am hit endpoint get status product "available"
    Then I am get status code 200 for get status product
    And validate response body code 200 message 'Success Operation' for get status product



