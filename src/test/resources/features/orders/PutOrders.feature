@PUTOrder

  Feature: Put order for admin
    As a user admin
    I want to change details order
    So that I am success update details order

    #SUCCESS
    Scenario : I want to update order as admin
      Given I am login as a admin
      And I am set body request email "admin@admin.com" password "admin123"
      When I am hit endpoint put update order by 58
      Then I am get a status code 200 for update order
      And validate response body code 200 message "Success Operation" for put update order

    #FAILED
    Scenario : I want to update order as admin
      Given I am login as a admin
      And I am set body request email "admin@admin.com" password "admin123"
      When I am hit endpoint put update order by 133
      Then I am get a status code 400 for update order
      And validate response body failed code 400 message "Data Not Found" for put update order

