@PUTProduct
Feature: PUT update product for admin
  As a user admin
  I want to change details product
  So that I am success update details product

  @TC_11
  Scenario: I want to update product except photo as admin
    Given I'm already logged in as admin
    And I am set body request name product "Tiktok Premium" detail product "bebas joget" price 2000 limit 2
    When I am hit endpoint put update product by 3
    Then I am get a status code 200 for update product
    And validate response body code 200 message "Success Operation" for put update product

  @TC_12
  Scenario: I want to update product by id not exist as admin
    Given I'm already logged in as admin
    And I am set body request name product "Tiktok Premium" detail product "aplikasi joget" price 2001 limit 2
    When I am hit endpoint put update product by 133
    Then I am get a status code 400 for update product
    And validate response body failed code 400 message "Data Not Found" for put update product

  @TC_13
  Scenario: I want to update product by invalid id as admin
    Given I'm already logged in as admin
    And I am set body request name product "Tiktok Premium" detail product "aplikasi joget" price 2001 limit 2
    When I am hit endpoint put update product by "lima"
    Then I am get a status code 400 for update product
    And validate response body failed code 400 message "Invalid Id" for put update product

  @TC_14
  Scenario: I want to update product except photo as customer
    Given I am already logged in as customer
    And I am set body request name product "Tiktok Premium" detail product "aplikasi joget" price 2001 limit 2
    When I am hit endpoint put update product by 13
    Then I am get a status code 400 for update product
    And validate response body code 400 message "Access Forbidden" for put update product
