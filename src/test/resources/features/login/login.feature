@authentication
Feature: Authentication Functionality
  As a user
  I want to be able to login
  so that i success login

  Scenario Outline: Check response and status code with valid body request and valid header
    Given I am set valid body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint
    Then I am get a status code 200 and valid response
    Examples:
      | email            | password |
      | user@example.com | user123  |
      | admin@admin.com  | admin123 |

