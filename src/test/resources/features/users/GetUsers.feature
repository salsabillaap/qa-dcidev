Feature: GET users
  As a admin
  I want to get all data users and detail users by id
  So that I am success get data as admin

  #GET All Users Success
  Scenario: I want to get all users as admin
    Given I am success login as admin
    When I am hit endpoint get all users
    Then I am get a status code 200 for get all users
    And validate response body code 200 message "Success Operation" for get all users

  #GET All Users Failed
  Scenario: I want to get all users as customer
    Given I am success login as customer
    When I am hit endpoint get all users
    Then I am get a status code 400 for get all users
    And validate response body failed code 400 message "Access Forbidden" for get all users

  Scenario: I want to get users by ID as admin
    Given I am success login as admin
    When I am hit endpoint get user by id 12
    Then I am get a status code 200 for get users by id
    And validate response body code 200 message "Success Operation" for get users by id 12
