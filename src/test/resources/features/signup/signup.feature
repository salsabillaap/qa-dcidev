@Signup
Feature: Signup Functionality
  As a user
  I want to be able to register
  so that i success register

  @TC_1
  Scenario Outline: Check response and status code with valid body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 200 signup
    And validate response success signup
    Examples:
      | name      | email               | password  | phone         |
      | testing11 | testing11@gmail.com | testing11 | +628517846946 |

  @TC_2
  Scenario Outline: Check response and status code with exist email body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Email or Telephone Number Already Exist"
    Examples:
      | name     | email              | password | phone          |
      | testing2 | testing1@gmail.com | testing2 | +6285190909090 |

  @TC_3
  Scenario Outline: Check response and status code with exist phone number body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Email or Telephone Number Already Exist"
    Examples:
      | name     | email              | password | phone          |
      | testing3 | testing3@gmail.com | testing3 | +6285123450213 |

  @TC_4
  Scenario Outline: Check response and status code with exist password body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 200 signup
    And validate response success signup
    Examples:
      | name      | email               | password  | phone            |
      | testing14 | testing14@gmail.com | testing14 | +628515439487413 |

  @TC_5
  Scenario Outline: Check response and status code with exist name body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 200 signup
    And validate response success signup
    Examples:
      | name      | email               | password  | phone         |
      | testing15 | testing15@gmail.com | testing15 | +628515346597 |

  @TC_6
  Scenario Outline: Check response and status code with invalid name body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate response success signup
    Examples:
      | name   | email               | password  | phone         |
      | $%@#76 | testing17@gmail.com | testing15 | +628515347654 |

  @TC_7
  Scenario Outline: Check response and status code with password less than 6 caracter body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Password must consist of 6 characters or more"
    Examples:
      | name     | email              | password | phone          |
      | testing6 | testing6@gmail.com | test     | +6285187563298 |

  @TC_8
  Scenario Outline: Check response and status code with empty name body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Invalid Name"
    Examples:
      | name | email              | password | phone         |
      |      | testing7@gmail.com | testing7 | +628565739274 |

  @TC_9
  Scenario Outline: Check response and status code with empty email body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Invalid Email"
    Examples:
      | name     | email | password | phone          |
      | testing8 |       | testing8 | +6285165494765 |

  @TC_10
  Scenario Outline: Check response and status code with empty password body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Invalid Password"
    Examples:
      | name     | email              | password | phone           |
      | testing9 | testing9@gmail.com |          | +62851532469458 |

  @TC_11
  Scenario Outline: Check response and status code with empty phone number body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Invalid Telephone Number"
    Examples:
      | name      | email               | password  | phone |
      | testing10 | testing10@gmail.com | testing10 |       |

  @TC_12
  Scenario Outline: Check response and status code with invalid phone number body request
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "Content-Type" with fill "application/json"
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Invalid Telephone Number"
    Examples:
      | name      | email               | password  | phone        |
      | testing11 | testing11@gmail.com | testing11 | 085155007862 |

  @TC_13
  Scenario Outline: Check response and status code with valid body request and without header
    Given I am set body request for signup name "<name>" email "<email>" password "<password>" phone "<phone>"
    And I am set valid header for signup "" with fill ""
    When I am hit endpoint signup
    Then I am get a status code 400 signup
    And validate error message "Invalid Name"
    Examples:
      | name      | email               | password  | phone         |
      | testing12 | testing12@gmail.com | testing12 | +627853926537 |

  #testing4 testing4@gmail.com testing4 +6285123232323 registered
  #testing1 testing1@gmail.com testing1 +6285123450213 registered
  #testing1 testing5@email.com testing5 +6285198786589 registered
  #testing11 testing11@gmail.com testing11  +628517846946 registered
  #testing14 testing14@gmail.com testing14 +628515439487413 registered
  #testing15 testing15@gmail.com testing15 +628515346597 registered
  #$%@#76 testing17@gmail.com testing15 +628515347654 registered