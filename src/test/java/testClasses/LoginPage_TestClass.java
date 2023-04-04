package testClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pomClasses.LoginPage_POMClass;
import testUtility.ReadExcelData;


public class LoginPage_TestClass extends BaseClass{
	LoginPage_POMClass  login;
	ReadExcelData r;
	SoftAssert s = new SoftAssert();	
  @BeforeClass				//In BeforeClass we can write code for handling alert, create object, etc
  public void beforeClass() {		
  }
 
  @Test(priority=0)
  public void VerifyLoginPageWithInvalidDetails1() throws InterruptedException, EncryptedDocumentException, IOException {
		logger = report.createTest("Verify Login Page With Invalid Details");
	  	login = new LoginPage_POMClass(driver);
		login.sendUsername(r.fetchExcelData(2, 0));
		login.sendPassword(r.fetchExcelData(2, 1));	
		login.clickOnLoginButton();
		String ExpectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String CurrentURL = driver.getCurrentUrl();
		s.assertNotEquals(CurrentURL, ExpectedURL);
		s.assertAll();
		//Assert.assertEquals(CurrentURL, ExpectedURL);	
  }
  
  @Test(priority=1)
  public void VerifyLoginPageWithInvalidDetails2() throws InterruptedException, EncryptedDocumentException, IOException {
		logger = report.createTest("Verify Login Page With Invalid Details");
		login = new LoginPage_POMClass(driver);		
		login.ClearBox();
		login.sendUsername(r.fetchExcelData(3, 0));
		login.sendPassword(r.fetchExcelData(3, 1));	
		login.clickOnLoginButton();
		String ExpectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String CurrentURL = driver.getCurrentUrl();
		s.assertNotEquals(CurrentURL, ExpectedURL);
		s.assertAll();
		//Assert.assertEquals(CurrentURL, ExpectedURL);	
  }
  
  @Test(priority=0)
  public void VerifyLoginPage()  {
		logger = report.createTest("Verify Login Page");
		Assert.fail();	
  }
 
@Test(priority=2)
  public void VerifyLoginPageWithValidDetails() throws InterruptedException, EncryptedDocumentException, IOException {
		logger = report.createTest("Verify Login Page With Valid Details");	
		login = new LoginPage_POMClass(driver);		
		login.sendUsername(r.fetchExcelData(1, 0));
		login.sendPassword(r.fetchExcelData(1, 1));	
		login.clickOnLoginButton();
	
		String ExpectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, ExpectedURL);
  }
}
