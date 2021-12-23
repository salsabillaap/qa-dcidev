@PUTOrder
Feature: PUT order for admin
  As a user admin
  I want to change details order
  So that I am success update details order

  #success
  Scenario: I want to update order by id order as admin
    Given I am login as a admin
    And I am set body request details "Email:admin@gmail.com,Password:password123"
    When I am hit endpoint put update order by id 58
    Then I am get a status code 200 for update order
    And validate response body code 200 message "Success Operation" for put update order

  #failed
  Scenario: I want to update order by id order not exist as admin
    Given I am login as a admin
    And I am set body request details "Email:admin@gmail.com,Password:password123"
    When I am hit endpoint put update order by id 500
    Then I am get a status code 400 for update order
    And validate response body failed code 400 message "Data Not Found" for put update order

  #failed
  Scenario: I want to update order by id order with empty details as admin
    Given I am login as a admin
    And I am set body request details ""
    When I am hit endpoint put update order by id 58
    Then I am get a status code 400 for update order
    And validate response body failed code 400 message "Details Can't Be Empty" for put update order

  #failed
  Scenario: I want to update order by invalid id order as admin
    Given I am login as a admin
    And I am set body request details "Email:admin@gmail.com,Password:password123"
    When I am hit endpoint put update order by id "lima"
    Then I am get a status code 400 for update order
    And validate response body failed code 400 message "Invalid Id" for put update order

  #failed
  Scenario: I want to update order by id order as customer
    Given I am login as a customer
    And I am set body request details "Email:admin@gmail.com,Password:password123"
    When I am hit endpoint put update order by id 58
    Then I am get a status code 400 for update order
    And validate response body failed code 400 message "Access Forbidden" for put update order

  #failed
  Scenario: I want to update order by id order not exist as customer
    Given I am login as a customer
    And I am set body request details "Email:admin@gmail.com,Password:password123"
    When I am hit endpoint put update order by id 500
    Then I am get a status code 400 for update order
    And validate response body failed code 400 message "Access Forbidden" for put update order

  #failed
  Scenario: I want to update order by invalid id order as customer
    Given I am login as a customer
    And I am set body request details "Email:admin@gmail.com,Password:password123"
    When I am hit endpoint put update order by id "lima"
    Then I am get a status code 400 for update order
    And validate response body failed code 400 message "Access Forbidden" for put update order

  #failed
  Scenario: I want to update order by id order with empty details as customer
    Given I am login as a customer
    And I am set body request details ""
    When I am hit endpoint put update order by id 58
    Then I am get a status code 400 for update order
    And validate response body failed code 400 message "Access Forbidden" for put update order


