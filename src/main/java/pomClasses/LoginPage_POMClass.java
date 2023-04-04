package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomUtility.WaitElement;

public class LoginPage_POMClass {
WebDriver driver;
	
	@FindBy(xpath="//input[@name='username']") 
	private WebElement Username;
	
	@FindBy(xpath="//input[@name='password']") 
	private WebElement Password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginButton;
	
	public LoginPage_POMClass(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}		
	/*Constructor in POM Class:
	 * Reason why we create constructor in POM class:
	 * 1. We declare constructor in POM class so that we can use instance of Web Driver in all the WebPages 
	 * so that when ever we are running any script it should run in one or same browser only, it should not open 
	 * differennt browser for different pages.
	 * 2. If we are using PageFactory which will help us to initailize all the Web Elements that we have written
	 * using @FindBy annotation in that same class by using init element method of PageFactory
	 * 
	 * When we create object of this class i.e. LogInPage_OrangeHRM it is automaticlly going to call this constructor and same instance
	 * is used in that class as well
	 */
	
	public void sendUsername(String userName) {
		WaitElement.waitForElement("//input[@name='username']", 20, driver);		//Calling method for Explicit Wait
		Username.sendKeys(userName);
	}
	
	public void sendPassword(String pwd) {
		Password.sendKeys(pwd);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void ClearBox() {
		Username.clear();
	}
}
