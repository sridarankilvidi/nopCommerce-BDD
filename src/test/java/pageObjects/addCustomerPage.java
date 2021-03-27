package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//import com.sun.tools.javac.util.List;

public class addCustomerPage {

		WebDriver ldriver;
		
		public addCustomerPage(WebDriver driver){
        this.ldriver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
		
		// here we are not using findBy to find the location of webelements in the page.
		// but we are only storing the xpath of webelements in the variables- 
		// example: lnkCustomers_menu is the variable which is assigned the xpath of that element 
	//By lnkCutomers_menu=By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
		
	By lnkCutomers_menu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCutomers_menuItem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	By btnAddNew = By.xpath("//a[@href='/Admin/Customer/Create']");
	
	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");
	By txtFirstname = By.xpath("//input[@id='FirstName']");
	By txtLastname = By.xpath("//input[@id='LastName']");
	
	By radioMale = By.xpath("//input[@id='Gender_Male']");
	By radioFemale = By.xpath("//input[@id='Gender_Female']");
	
	By txtDOB = By.xpath("//input[@id='DateOfBirth']");
	By txtCompany = By.xpath("//input[@id='Company']");
	
	By drpNews =By.xpath("//ul[@id='SelectedNewsletterSubscriptionStoreIds_taglist']/ancestor::div/div[@class='k-widget k-multiselect k-multiselect-clearable']");
	
	By drpNewsYourStore =By.xpath("//ul/li[contains(text(),'Your store name')]");
	By drpNewsTestStore2 =By.xpath("//ul/li[contains(text(),'Test store 2')]");
		
	//By chkActive = By.xpath("//input[@id='Active']");
		
	By drpCustomerRole = By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']/ancestor::div/div[@class='k-widget k-multiselect k-multiselect-clearable']");
	
	By Admin_menuItem = By.xpath("//*[@id='SelectedCustomerRoleIds_listbox']/li[1]"); 
	By Moderator_menuItem = By.xpath("//*[@id='SelectedCustomerRoleIds_listbox']/li[2]");
	By Guests_menuItem = By.xpath("//*[@id='SelectedCustomerRoleIds_listbox']/li[3]");
	By Registered_menuItem = By.xpath("//*[@id='SelectedCustomerRoleIds_listbox']/li[4]");
	By Vendors_menuItem = By.xpath("//*[@id='SelectedCustomerRoleIds_listbox']/li[5]");
	
	By drpVendor = By.xpath("//select[@id='VendorId']");
	By txtAdminComment = By.xpath("//textarea[@name='AdminComment']");
	
	By btnSave = By.xpath("//button[@name='save']");
	
	By lnkLogout = By.xpath("//a[@class='nav-link'][@href='/logout']");
	
	// implement the methods for each element whose xpath locators are saved in
	//variables above - note that only in the method implementation we actually 
	// find the elements and act on them - This is a different approach from the previous login page
	// where we actually find the element and store them before the methods are acting on them
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	public void clickCustomersMenu() {
		ldriver.findElement(lnkCutomers_menu).click();
	}
	
	public void clickCustomersMenuItem() {
		ldriver.findElement(lnkCutomers_menuItem).click();
	}
		
	public void clickAddNewCustomer() {
		ldriver.findElement(btnAddNew).click();
	}
	
	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		ldriver.findElement(txtPassword).sendKeys(pwd);
	}
	
	public void setFirstName(String fn) {
		ldriver.findElement(txtFirstname).sendKeys(fn);
	}
	
	public void setLastName(String ln) {
		ldriver.findElement(txtLastname).sendKeys(ln);
	}
	
	public void setGender(String gender) {
		if (gender.equals("male")) {
			ldriver.findElement(radioMale).click();
		}else if(gender.equals("female")) {
			ldriver.findElement(radioFemale).click();
		}else {
			ldriver.findElement(radioMale).click();
		}
	}
	
	public void setdob(String dob) {
		ldriver.findElement(txtDOB).sendKeys(dob);
	}
	
	public void setCompany(String company) {
		ldriver.findElement(txtCompany).sendKeys(company);
	}
	
	/*public void setNewsletter2(String news) {	
		ldriver.findElement(drpNews).click();
		Select drp;
		if (news.equalsIgnoreCase("Your store name")) {
			drp = new Select (ldriver.findElement(drpNewsYourStore));
		}else {
			drp = new Select (ldriver.findElement(drpNewsTestStore2));
		}
		drp.selectByVisibleText(news);
	}*/
	
	public void setNewsletter(String news) throws InterruptedException {
		// the newsletter bootstrap dropdown is off the screen
		// so before clicking on it scroll down to make it visible
		JavascriptExecutor Js1 = (JavascriptExecutor) ldriver;
		Js1.executeScript("window.scrollBy(0,1000)");
		ldriver.findElement(drpNews).click();
		Thread.sleep(2000);
		if (news.equalsIgnoreCase("Your store name")) {
			ldriver.findElement(drpNewsYourStore).click();
		}else {
			ldriver.findElement(drpNewsTestStore2).click();;
		}
		
	}
	
	public void setCustomerRole(String role) throws InterruptedException {
		String attr = null;
		WebElement listitem = null;
		ldriver.findElement(drpCustomerRole).click();
		Thread.sleep(2000);
		List<WebElement> drpCustomerRoleList = ldriver.findElements(By.xpath("//*[@id='SelectedCustomerRoleIds_listbox']/li")); 
		// find whether any of the listitem is already selected
		for (WebElement x:drpCustomerRoleList) {
			attr = x.getAttribute("aria-selected");
			if (attr.equalsIgnoreCase("true"))
				break;			
		}
		if (!attr.equalsIgnoreCase("true")) {
			if (role.equals("Registered")) {
				listitem = ldriver.findElement(Registered_menuItem);
			}else if(role.equals("Administrators")) {
				listitem=ldriver.findElement(Admin_menuItem);
			}else if(role.equals("Forum Moderators")) {
				listitem=ldriver.findElement(Moderator_menuItem);
			}else if(role.equals("Guests")) {
				listitem=ldriver.findElement(Guests_menuItem);
			}else if(role.equals("Vendors")) {
				listitem=ldriver.findElement(Vendors_menuItem);
			}
			//listitem.click();
			//Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) ldriver;
			js.executeScript("arguments[0].click();", listitem);
	
		}
		
	}  
	
	/*public void setCustoreRole(String role) {	
		Select drp = new Select (ldriver.findElement(CustomerRole));
		if (!role.equals("Registered"))
			drp.selectByVisibleText(role);
	}*/
	
	//select[@id='VendorId']
	
	public void setVendor(String vendor) {	
		Select drp = new Select (ldriver.findElement(drpVendor));
		if (!vendor.equals("Not a vendor"))
			drp.selectByVisibleText(vendor);
	}
	
	public void setAdminComments(String comments) {
		ldriver.findElement(txtAdminComment).sendKeys(comments);
	}
	
	public void clickSave() {
		ldriver.findElement(btnSave).click();
	}
	
	public void clickLogout() {
		ldriver.findElement(lnkLogout).click();
	}
	
	
	
	
	
}
