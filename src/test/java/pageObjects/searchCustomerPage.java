package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class searchCustomerPage {
	
	WebDriver ldriver;
	
	public searchCustomerPage(WebDriver driver){
    this.ldriver = driver;
    //This initElements method will create all WebElements
    PageFactory.initElements(driver, this);
	}
	
	By txtEmail =By.xpath("//input[@id='SearchEmail']");
	By txtFirstName =By.xpath("//input[@id='SearchFirstName']");
	By txtLastName =By.xpath("//input[@id='SearchLastName']");
	By btnSearch =By.xpath("//button[@id='search-customers']");
	
	//By Table =By.xpath("//*[@id='customers-grid']/tbody/tr[1]/td[2]");
	By Table =By.xpath("//*[@id='customers-grid']");
	By tableRows =By.xpath("//*[@id='customers-grid']//tbody/tr");
	By tableColumns =By.xpath("//*[@id='customers-grid']//tbody/tr/td");
	
	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setFirstName(String fn) {
		ldriver.findElement(txtFirstName).sendKeys(fn);
	}
	
	public void setLastName(String ln) {
		ldriver.findElement(txtLastName).sendKeys(ln);	
	}
	
	public void clickSearch() {
		ldriver.findElement(btnSearch).click();
		
	}
	
	public int getNoOfRows() {
		List <WebElement> rowlist = ldriver.findElements(tableRows);
		return (rowlist.size());
	}
	
	public int getNoOfColumns() {
		List <WebElement> columnlist = ldriver.findElements(tableColumns);
		return (columnlist.size());
	}
	
	public boolean verifyCustomerEmail(String email) {
		boolean found = false;
		//WebElement table = ldriver.findElement(Table);
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		// This  will scroll down the page by  1000 pixel vertical		
        js.executeScript("window.scrollBy(0,1000)");
		for (int i=1; i<=getNoOfRows(); i++) {
			//String actEmail= table.findElement(By.xpath("//*[@id='customers-grid']//tbody/tr[i]/td[2]")).getText();
			WebElement td= ldriver.findElement(By.xpath("//*[@id='customers-grid']//tbody/tr["+i+"]/td[2]"));
			String actEmail=td.getText();
			if (actEmail.equalsIgnoreCase(email)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public boolean verifyCustomerName(String fn, String ln) {
		boolean found = false;
		//WebElement table = ldriver.findElement(Table);
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		// This  will scroll down the page by  1000 pixel vertical		
        js.executeScript("window.scrollBy(0,1000)");
		for (int i=1; i<=getNoOfRows(); i++) {
			//String actEmail= table.findElement(By.xpath("//*[@id='customers-grid']//tbody/tr[i]/td[2]")).getText();
			WebElement td= ldriver.findElement(By.xpath("//*[@id='customers-grid']//tbody/tr["+i+"]/td[3]"));
			String name=td.getText();
			String names[] = name.split(" ");
			if (names[0].equals(fn) && names[1].equals(ln)) {
				found = true;
				break;
			}
		}
		return found;
	}
}
