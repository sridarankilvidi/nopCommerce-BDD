package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver ldriver;
	
	public loginPage(WebDriver driver){
        this.ldriver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(id="Email")
	@CacheLookup
    WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
    WebElement txtPassword;
	
	@FindBy(xpath="html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	@CacheLookup
    WebElement btnLogin;
	
	// or the following alternate xpath
	/*
	 * @FindBy(xpath="//input[@value='Log in']")
		@CacheLookup
    	WebElement btnLogin
	 * 
	 * 
	 */
	
	@FindBy(linkText="Logout")
	@CacheLookup
    WebElement lnkLogout;
	
	//Set user email in textbox
    public void setUserName(String strEmail){
    	txtEmail.clear();
    	txtEmail.sendKeys(strEmail);     
    }

    //Set password in password textbox

    public void setPassword(String strPassword){
    	txtPassword.clear();
    	txtPassword.sendKeys(strPassword);

    }

    //Click on login button

    public void clickLogin(){

    	btnLogin.click();
    	ldriver.manage().window().maximize();

    }  
    
  //Click on logout link

    public void clickLogout(){

    	lnkLogout.click();

    }  
    

}
