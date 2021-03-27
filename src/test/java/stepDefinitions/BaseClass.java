package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.addCustomerPage;
import pageObjects.loginPage;
import pageObjects.searchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	String chromepath = "C:\\sridaran\\Selenium-java\\eclipse-workspace\\nopCommerce-BDD\\Drivers\\chromedriver.exe";
	public loginPage lp;
	public addCustomerPage addCust;
	public searchCustomerPage searchCust;
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
}
