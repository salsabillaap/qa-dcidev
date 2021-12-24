@Signup
Feature: Signup Functionality
  As a user
  I want to be able to register
  so that i success register


  Scenario Outline: Check response and status code with valid body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 200 signup
    And validate response success signup
    Examples:
      | name    | email             | password   | phone           |
      | prayoga | prayoga@gmail.com | prayoga123 | +62851073029876 |

  Scenario Outline: Check response and status code with exist email body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Email or Telephone Number Already Exist"
    Examples:
      | name     | email              | password | phone          |
      | testing2 | prayoga@gmail.com | testing2 | +6285190909090 |

  Scenario Outline: Check response and status code with exist phone number body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Email or Telephone Number Already Exist"
    Examples:
      | name     | email              | password | phone          |
      | testing3 | testing3@gmail.com | testing3 | +62851073029876 |

  Scenario Outline: Check response and status code with exist password body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 200 signup
    And validate response success signup
    Examples:
      | name | email          | password   | phone           |
      | luna | luna@gmail.com | prayoga123 | +62851543945613 |

  Scenario Outline: Check response and status code with exist name body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 200 signup
    And validate response success signup
    Examples:
      | name | email           | password | phone           |
      | luna | luna1@gmail.com | luna123  | +62851534639858 |

  Scenario Outline: Check response and status code with invalid name body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Invalid Name"
    Examples:
      | name | email              | password  | phone          |
      |      | testing0@gmail.com | testing15 | +6285153407654 |

  Scenario Outline: Check response and status code with password less than 6 caracter body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Password must consist of 6 characters or more"
    Examples:
      | name     | email              | password | phone          |
      | testing6 | testing6@gmail.com | test     | +6285187563298 |

  Scenario Outline: Check response and status code with empty name body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Invalid Name"
    Examples:
      | name | email              | password | phone         |
      |      | testing7@gmail.com | testing7 | +628565739274 |

  Scenario Outline: Check response and status code with empty email body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Invalid Email"
    Examples:
      | name     | email | password | phone          |
      | testing8 |       | testing8 | +6285165494765 |

  Scenario Outline: Check response and status code with empty password body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Invalid Password"
    Examples:
      | name     | email              | password | phone           |
      | testing9 | testing9@gmail.com |          | +62851532469458 |

  Scenario Outline: Check response and status code with empty phone number body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Invalid Telephone Number"
    Examples:
      | name      | email               | password  | phone |
      | testing10 | testing10@gmail.com | testing10 |       |

  Scenario Outline: Check response and status code with invalid phone number body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Invalid Telephone Number"
    Examples:
      | name      | email               | password  | phone        |
      | testing11 | testing11@gmail.com | testing11 | 085155007862 |

  Scenario Outline: Check response and status code with valid body request and without header
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "" with fill ""
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Invalid Name"
    Examples:
      | name      | email               | password  | phone         |
      | testing12 | testing12@gmail.com | testing12 | +627853926537 |

  # wahyu wahyu@gmail.com wahyu123 +6285155001234 registered
  # nusantara nusantara@gmail.com nusantara123 +6285155009876 registered