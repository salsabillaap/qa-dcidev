#Zakiah
@PostGroupProduct
Feature: POST create group product for customer
  As a user customer
  I want to create group product
  So that i am success create group product

  #Success jika customer buat group
  Scenario: user customer want to create group product
    Given as customer login
    And I am set header
    When I am hit endpoint group product by id product 1
    Then I am get a status code 200 post group product
    And validate response body code 200 message "Success Operation" for post group product

   #Failed jika admin buat group
  Scenario: user customer want to create group product
    Given as admin login
    And I am set header
    When I am hit endpoint group product by id product 1
    Then I am get a status code 400 post group product
    And validate response body failed code 400 message "Access Forbidden" for post group product



