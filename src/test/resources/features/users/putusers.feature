@PUTUsers
Feature: PUT Users
  as a users
  I want to update my data account
  So that i am success update data account

  #SUCCESS
  Scenario Outline: I want to update customer data by id as admin
    Given login as admin
    And I am update data "<name>" "<email>" "<password>" "<phone>"
    When I am hit endpoint put users by id 9
    Then I am get a status code 200 for update users
    And validate response body code 200 message "Success Operation" for update users
    Examples:
      | name   | email            | password  | phone           |
      | sadeli | sadeli@gmail.com | sadeli123 | +62957084366744 |

  #FAILED
  Scenario Outline: I want to update customer data by id
    Given login as admin
    And I am update data "<name>" "<email>" "<password>" "<phone>"
    When I am hit endpoint put users by id "rahmanto"
    Then I am get a status code 400 for update users
    And validate response body failed code 400 message "Invalid Id" for update users
    Examples:
      | name  | email           | password | phone         |
      | manto | manto@gmail.com | manto123 | +629876298628 |

  #FAILED
  Scenario Outline: I want to update customer data by unexist id as admin
    Given login as admin
    And I am update data "<name>" "<email>" "<password>" "<phone>"
    When I am hit endpoint put users by id 500
    Then I am get a status code 400 for update users
    And validate response body failed code 400 message "Data Not Found" for update users
    Examples:
      | name  | email           | password | phone         |
      | manto | manto@gmail.com | manto123 | +629876298628 |

  #FAILED
  Scenario Outline: I want to update customer data by ID to invalid email as admin
    Given login as admin
    And I am update data "<name>" "<email>" "<password>" "<phone>"
    When I am hit endpoint put users by id 9
    Then I am get a status code 400 for update users
    And validate response body failed code 400 message "Invalid Email" for update users
    Examples:
      | name  | email         | password | phone         |
      | manto | mantogmailcom | manto123 | +629876298628 |

  #FAILED
  Scenario Outline: I want to update customer data by ID with empty name as admin
    Given login as admin
    And I am update data "<name>" "<email>" "<password>" "<phone>"
    When I am hit endpoint put users by id 9
    Then I am get a status code 400 for update users
    And validate response body failed code 400 message "Invalid Name" for update users
    Examples:
      | name | email           | password | phone         |
      |      | manto@gmail.com | manto123 | +629876298628 |

  #FAILED
  Scenario Outline: I want to update customer data by ID to invalid name as admin
    Given login as admin
    And I am update data "<name>" "<email>" "<password>" "<phone>"
    When I am hit endpoint put users by id 9
    Then I am get a status code 400 for update users
    And validate response body failed code 400 message "Invalid Name" for update users
    Examples:
      | name | email           | password | phone         |
      |      | manto@gmail.com | manto123 | +629876298628 |

  #FAILED
  Scenario Outline: I want to update customer data by ID with empty password as admin
    Given login as admin
    And I am update data "<name>" "<email>" "<password>" "<phone>"
    When I am hit endpoint put users by id 9
    Then I am get a status code 400 for update users
    And validate response body failed code 400 message "Invalid Password" for update users
    Examples:
      | name  | email           | password | phone         |
      | manto | manto@gmail.com |          | +629876298628 |

  #FAILED
  Scenario Outline: I want to update customer data by ID to password less than six char as admin
    Given login as admin
    And I am update data "<name>" "<email>" "<password>" "<phone>"
    When I am hit endpoint put users by id 9
    Then I am get a status code 400 for update users
    And validate response body failed code 400 message "Password must consist of 6 characters or more" for update users
    Examples:
      | name  | email           | password | phone         |
      | manto | manto@gmail.com | manto    | +629876298628 |

  #FAILED
  Scenario Outline: I want to update customer data by ID to set "0" in first phone number as admin
    Given login as admin
    And I am update data "<name>" "<email>" "<password>" "<phone>"
    When I am hit endpoint put users by id 9
    Then I am get a status code 400 for update users
    And validate response body failed code 400 message "Invalid Telephone Number" for update users
    Examples:
      | name  | email           | password | phone       |
      | manto | manto@gmail.com | manto123 | 09876298628 |

  #FAILED
  Scenario Outline: I want to update customer data code to exist email as admin
    Given login as admin
    And I am update data "<name>" "<email>" "<password>" "<phone>"
    When I am hit endpoint put users by id 9
    Then I am get a status code 400 for update users
    And validate response body failed code 400 message "Email or Telephone Number Already Exist" for update users
    Examples:
      | name  | email           | password | phone         |
      | manto | wahyu@gmail.com | manto123 | +629876298628 |

  #FAILED
  Scenario Outline: I want to update customer data code to exist phone number as admin
    Given login as admin
    And I am update data "<name>" "<email>" "<password>" "<phone>"
    When I am hit endpoint put users by id 9
    Then I am get a status code 400 for update users
    And validate response body failed code 400 message "Email or Telephone Number Already Exist" for update users
    Examples:
      | name  | email           | password | phone         |
      | manto | manto@gmail.com | manto123 | +6285155001234 |

  #NEGATIVE SCENARIO jika password sudah digunakan user lain
  Scenario Outline: I want to update customer data code to exist password as admin
    Given login as admin
    And I am update data "<name>" "<email>" "<password>" "<phone>"
    When I am hit endpoint put users by id 9
    Then I am get a status code 200 for update users
    And validate response body code 200 message "Success Operation" for update users
    Examples: #password user123 #email sadeli@gmail.com
      | name   | email            | password | phone           |
      | sadeli | sadeli@gmail.com | user123  | +62957084366744 |

   #customer ingin ubah data user id lain
  Scenario Outline: I want to update customer data by id as customer
    Given login as customer
    And I am update data "<name>" "<email>" "<password>" "<phone>"
    When I am hit endpoint put users by id 10
    Then I am get a status code 400 for update users
    And validate response body code 400 message "Access Forbidden" for update users
    Examples:
      | name   | email            | password | phone           |
      | sadeli | sadeli@gmail.com | user123  | +62957084366744 |

  @test #customer ingin ubah data user id miliknya
  Scenario Outline: I want to update password by my id as customer
    Given login as customer
    And I am update data "<name>" "<email>" "<password>" "<phone>"
    When I am hit endpoint put users by id 6
    Then I am get a status code 200 for update users
    And validate response body code 200 message "Success Operation" for update users
    Examples:
      | name  | email           | password | phone           |
      | wahyu | wahyu@gmail.com | wahyu123 | +6285155001234 |