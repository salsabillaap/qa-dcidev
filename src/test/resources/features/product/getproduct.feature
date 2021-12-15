Feature: GET product
  fdsafd
  fafa
  fdsaf

  Scenario: Check response and status code by id
    Given I want to see detail product by id
    When I am hit endpoint product method get by id 5
    Then I am get a status code 200 get product
    And validate response success product by id