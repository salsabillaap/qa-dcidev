@PostProduct
Feature: POST create product for admin
  As a user admin
  I want to create product
  So that i am success create product

  @TC_1
  Scenario Outline: user admin want create product
    Given I am logged in as user admin
    And I am set body request "<name_product>" "<detail_product>" price 20000 limit 5
    When I am hit endpoint product method post
    Then I am get a status code 200 post product
    And validate response success create product "Success Operation"
    Examples: #sudah kedaftar
      | name_product | detail_product |
      | Turbo VPN    | lorem ipsum    |

  @TC_2
  Scenario Outline: user customer want create product
    Given I am logged in as user customer
    And I am set body request "<name_product>" "<detail_product>" price 20000 limit 5
    When I am hit endpoint product method post
    Then I am get a status code 400 post product
    And validate response body code 400 message "Access Forbidden"
    Examples:
      | name_product | detail_product |
      | Test 365     | lorem ipsum    |

  @TC_3
  Scenario Outline: user admin create product with input price and limit alphanumeric
    Given I am logged in as user admin
    And I am set body request "<name_product>" "<detail_product>" price "20ribu" limit "lima"
    When I am hit endpoint product method post
    Then I am get a status code 400 post product
    And validate response body code 400 message "Bad Request"
    Examples:
      | name_product | detail_product |
      | Test 365     | lorem ipsum    |

  @TC_4
  Scenario Outline: create product with invalid file extension
    Given I am logged in as user admin
    And I am set body request "<name_product>" "<detail_product>" price 20000 limit 3 "<photo>"
    When I am hit endpoint product method post
    Then I am get a status code 400 post product
    And validate response body code 400 message "File Extension Not Allowed"
    Examples:
      | name_product | detail_product | photo                           |
      | Test 365     | lorem ipsum    | E:/invalidphoto/demoqa.xlsx     |
      | Test 365     | lorem ipsum    | E:/invalidphoto/requirement.txt |

  @TC_5
  Scenario Outline: create product with invalid name header photo
    Given I am logged in as user admin
    And I am set body request "<name_product>" "<detail_product>" price 20000 limit 3 photo "<photo>"
    When I am hit endpoint product method post
    Then I am get a status code 500 post product
    And validate response body code 500 message "Failed to Upload File"
    Examples:
      | name_product | detail_product | photo                       |
      | Test 365     | lorem ipsum    | E:/invalidphoto/demoqa.xlsx |

