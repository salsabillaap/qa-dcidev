@Login
Feature: POST Login get token for access to account
  As a user
  I want to be able to login
  so that i success login

  #Success #Test_1
  Scenario Outline: login with valid email and password
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 200
    And valid response success
    Examples:
      | email           | password |
      | admin@admin.com | admin123 |
      | wahyu@gmail.com | wahyu123 |

  #Failed #Test_2
  Scenario Outline: login with invalid email and valid password
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
  Scenario Outline: login with valid email and invalid password
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
  Scenario Outline: login with invalid email and password
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

  #Failed #Test_5
  Scenario Outline: login with valid email and password but without header
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
  Scenario: login with empty email and password
    Given I am set body request email "" and password ""
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And valid response failed