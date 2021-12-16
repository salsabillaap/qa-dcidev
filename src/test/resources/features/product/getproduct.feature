Feature: GET product
  fdsafd
  fafa
  fdsaf

  Scenario: I want to see list all product
    Given I am set header "Content-Type" with value "applicaton/json"
    When I am hit endpoint get all product
    Then I am get a status code 200 for get all product
    And validate response success get all product

  Scenario: