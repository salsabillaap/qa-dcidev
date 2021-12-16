@GETproduct
Feature: GET product
  As a user
  I want to see all product and details product
  So that I am success get product

  @TC_6 #SUCCESS
  Scenario: I want to see list all product
    Given I am set header "Content-Type" with value "applicaton/json"
    When I am hit endpoint get all product
    Then I am get a status code 200 for get all product
    And validate response body code 200 message "Success Operation" for get all product

  @TC_7 #FAILED #tanyakan ke BE mengenai kondisi data not found dan bad request
  Scenario: I want to see all product with invalid endpoint
    Given I am set header "Content-Type" with value "applicaton/json"
    When I am hit invalid endpoint get all product
    Then I am get a status code 400 for get all product
    And validate response body failed code 400 message "Data Not Found" for get all product

  @TC_8 #SUCCESS
  Scenario: I want to see details product by id
    Given I am set header "Content-Type" with value "applicaton/json"
    When I am hit endpoint get product by id 10
    Then I am get a status code 200 for get product by id
    And validate response body code 200 message "Success Operation" for get product by id 10

  @TC_9 #FAILED
  Scenario: I want to see details product by id not found
    Given I am set header "Content-Type" with value "applicaton/json"
    When I am hit endpoint get product by id 100
    Then I am get a status code 400 for get product by id
    And validate response body failed code 400 message "Data Not Found" for get product by id

  @TC_10 #FAILED
  Scenario: I want to see details product by invalid id
    Given I am set header "Content-Type" with value "applicaton/json"
    When I am hit endpoint get product by id "satu"
    Then I am get a status code 400 for get product by id
    And validate response body failed code 400 message "Invalid Id" for get product by id
