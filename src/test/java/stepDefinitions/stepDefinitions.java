package stepDefinitions;

//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import junit.framework.Assert;
import pageObjects.addCustomerPage;
import pageObjects.loginPage;
import pageObjects.searchCustomerPage;

public class stepDefinitions extends BaseClass{
		
	@Given("Launch specific browser")
	public void launch_specific_browser() {
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromepath);  
	   	 	driver = new ChromeDriver();
	   	 	log.info("Chrome Browser is used....");
		}else if(br.equals("firefox")) {
			 System.setProperty("webdriver.gecko.driver", firefoxpath);  
	    	 driver = new FirefoxDriver();
	    	 log.info("Firefox Browser is used....");
	     }else if (br.equalsIgnoreCase("edge")) {
	    	// Set the driver path
	    	 System.setProperty("webdriver.edge.driver", edgepath);
	    	 driver = new EdgeDriver();
	    	 log.info("Edge Browser is used....");
	     }
		
   	 	lp = new loginPage(driver);
	 
	}

	@When("Open URL {string}")
	public void open_url(String strURL) {
		log.info("opening nopCommerce website.......");
	    driver.get(strURL);
	}

	@When("Enter email as {string} and password as {string}")
	public void enter_email_as_and_password_as(String strEmail, String strpwd) {
	    lp.setUserName(strEmail);
	    lp.setPassword(strpwd);
	}

	@When("click  Login btn")
	public void click_login_btn() throws InterruptedException {
		lp.clickLogin(); 
		Thread.sleep(3000);
	}

	@Then("verify that title should be {string}")
	public void verify_that_title_should_be(String strTitle) {
		if (driver.getPageSource().contains("Login was unsuccessful"))
		{
			log.info("Wrong credentials. Login Failed. Please Try again.......");
			driver.close();
			Assert.assertTrue(false);
		}else {
			log.info("Login Successful. Welcome to nopCommercer Site!");
			Assert.assertEquals(strTitle, driver.getTitle());
		}	
	}

	@When("click logout link")
	public void click_logout_link() throws InterruptedException {
		log.info("Logging out of the application. Good Bye.......");
		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String strTitle) {
		if (driver.getPageSource().contains("Welcome, please sign in!"))
		{
			Assert.assertEquals(strTitle, driver.getTitle());		
			//Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		//driver.close();
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}
	
	// add cutomer methods are implemented below

	@Then("view Dashboard")
	public void view_dashboard() {
		addCust = new addCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
	}
	@When("click on cutomers menu")
	public void click_on_cutomers_menu() {
		addCust.clickCustomersMenu();
	}
	@When("click on customers menu item")
	public void click_on_customers_menu_item() {
	   addCust.clickCustomersMenuItem();
	}
	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
	   addCust.clickAddNewCustomer();
	   Thread.sleep(3000);
	}
	
	// verify page
	@Then("view Add new customer page")
	public void view_add_new_customer_page() {
	    Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}
	
	@When("enter customer informations")
	public void enter_customer_informations() throws InterruptedException {
		String email = randomestring();
		addCust.setEmail(email.concat("@gmail.com"));
		addCust.setPassword("test123");
		addCust.setFirstName("Sridaran");
		addCust.setLastName("kilvidi");
		addCust.setGender("male");
		addCust.setdob("8/19/1980");//mm/dd/yyyy
		addCust.setCompany("Ecomwise");
		addCust.setNewsletter("Your store name");
		addCust.setCustomerRole("Guests");
		addCust.setVendor("Vendor 2");
		addCust.setAdminComments("Adding a new customer.......");
		
	}
	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
	    addCust.clickSave();
	    Thread.sleep(5000);
	}
	@Then("verify confirmation message {string}")
	public void verify_confirmation_message(String msg) {
		log.info("New customer added.......");
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(msg));
	}
	
// search by customer email 
		

	@When("enter customer email")
	public void enter_customer_email() {
		searchCust = new searchCustomerPage(driver);
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
		
	}
	@Then("click search btn")
	public void click_search_btn() throws InterruptedException {
	   searchCust.clickSearch();
	   Thread.sleep(3000);
	}
	@And("validate email add in the search result table")
	public void validate_email_add_in_the_search_result_table() {
	    boolean status = searchCust.verifyCustomerEmail("victoria_victoria@nopCommerce.com");
	    Assert.assertEquals(true, status);
	    log.info("Customer email Search was successful.......");
	}

// search by customer fname and lname
	
	@When("enter customer firstname {string}")
	public void enter_customer_firstname(String fname) {
		searchCust = new searchCustomerPage(driver);
		searchCust.setFirstName(fname);
	}
	@When("enter customer lastname {string}")
	public void enter_customer_lastname(String lname) {
	    searchCust.setLastName(lname);
	}
	@Then("validate fname {string} and lname {string} in the search result table")
	public void validate_fname_and_lname_in_the_search_result_table(String fn, String ln) {
	    boolean found = searchCust.verifyCustomerName(fn,ln);
	    Assert.assertTrue(found);
	    log.info("Customer fname and lname Search was successful.......");
	}


}
