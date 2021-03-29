Feature: Customers

Background:
	Given Launch specific browser        
    When Open URL "https://admin-demo.nopcommerce.com/login"
    And Enter email as "admin@yourstore.com" and password as "admin"
    And click  Login btn
    Then view Dashboard   

@sanity 
Scenario: Add New Customer   
    When click on cutomers menu
    And click on customers menu item
    And click on Add new button
    Then view Add new customer page
    When enter customer informations
    And click on save button
    Then verify confirmation message "The new customer has been added successfully."
    When click logout link
    Then page title should be "Your store. Login"
    And close browser
 
 @regression 
 Scenario: Search Customer by email    
    When click on cutomers menu
    And click on customers menu item
    When  enter customer email 
    Then click search btn
    And validate email add in the search result table
     When click logout link
    Then page title should be "Your store. Login"
    And close browser
   
   @regression
    Scenario: Search Customer by firstname and lastname   
    When click on cutomers menu
    And click on customers menu item
    When  enter customer firstname "Victoria"
    And  enter customer lastname "Terces"
    Then click search btn
    And validate fname "Victoria" and lname "Terces" in the search result table
     When click logout link
    Then page title should be "Your store. Login"
    And close browser