package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import pageObjects.addCustomerPage;
import pageObjects.loginPage;
import pageObjects.searchCustomerPage;
import utilities.ReadConfig;

public class BaseClass {
	public WebDriver driver;
	//String chromepath = "C:\\sridaran\\Selenium-java\\eclipse-workspace\\nopCommerce-BDD\\Drivers\\chromedriver.exe";
	//String log4jpath = "C:\\sridaran\\Selenium-java\\eclipse-workspace\\nopCommerce-BDD\\Configurations\\log4j.properties"; 
	public loginPage lp;
	public addCustomerPage addCust;
	public searchCustomerPage searchCust;
	
	ReadConfig readconfig = new ReadConfig();
	public String chromepath = readconfig.getChromePath();
	public String firefoxpath = readconfig.getFirefoxPath();
	public String edgepath = readconfig.getEdgePath();
	public String log4jpath = readconfig.getLog4jPath();
	public String br=readconfig.getBrowser();
	
	public static Logger log;
	
	public BaseClass(){
		log= Logger.getLogger("nopCommerce-BDD");
		PropertyConfigurator.configure(log4jpath); 
	}
	
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
