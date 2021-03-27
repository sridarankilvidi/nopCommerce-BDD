Feature: nopEcommerce site Login  
Scenario: Successful login with valid credentials  
	Given Launch chrome browser        
    When Open URL "https://admin-demo.nopcommerce.com/login"
    And Enter email as "admin@yourstore.com" and password as "admin"
    And click  Login btn
    Then verify that title should be "Dashboard / nopCommerce administration"
    When click logout link
    Then page title should be "Your store. Login"
    And close browser
   
   Scenario Outline: Login Data driven  
	Given Launch chrome browser        
    When Open URL "https://admin-demo.nopcommerce.com/login"
    And Enter email as "<email>" and password as "<password>"
    And click  Login btn
    Then verify that title should be "Dashboard / nopCommerce administration"
    When click logout link
    Then page title should be "Your store. Login"
    And close browser   
    
    Examples:
    	| email  | password |
    	|admin@yourstore.com |admin|
    	|admin@yourstore.com  |admin123| 
    	|admin@yourstore.com |admin|
    	    