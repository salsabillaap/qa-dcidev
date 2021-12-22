@Login
Feature: Login Functionality
  As a user
  I want to be able to login
  so that i success login

  @LoginSuccess #Success #Test_1
  Scenario Outline: Check response and status code with valid body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 200
    And valid response success
    Examples:
      | email           | password |
      | admin@admin.com | admin123 |
      | wahyu@gmail.com | wahyu123 |

  @LoginFailed #Failed #Test_2
  Scenario Outline: Check response and status code with invalid email body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And valid response failed
    Examples:
      | email           | password |
      | userexample.com | user123  |
      | user@examplecom | user123  |
      | userexamplecom  | user123  |
      | @example.com    | user123  |

  #Failed #Test_3
  Scenario Outline: Check response and status code with invalid password body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And valid response failed
    Examples:
      | email             | password |
      | user@example.com  | @#%#     |
      | admin@example.com | tpass    |
      | user@example.com  | gda      |

  #Failed #Test_4
  Scenario Outline: Check response and status code with invalid email and password body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And valid response failed
    Examples:
      | email           | password |
      | userexample.com | @#%#     |
      | user@examplecom | tpass    |
      | userexamplecom  | gda      |
      | @example.com    | zkzkz    |

  @nyoba #Failed #Test_5
  Scenario Outline: Check response and status code with valid body request and without header
    Given I am set body request email "<email>" and password "<password>"
    #And I am set valid header "" with fill ""
    When I am hit endpoint login
    Then I am get a status code 400
    And valid response failed
    Examples:
      | email            | password |
      | user@example.com | user123  |
      | admin@admin.com  | admin123 |

  #Failed #Test_6
  Scenario: Check response and status code without body request
    Given I am set body request email "" and password ""
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And valid response failed