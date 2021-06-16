package seleniumTests.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Test;

import seleniumTests.PageObjects.LoginPage;
import seleniumTests.PageObjects.SecurePage;

public class TestCaseOne extends BaseTest {
	
	public String validUsername = "tomsmith";
	public String validPassword = "SuperSecretPassword!";
	public String invalidUsername = "incorrectusername";
	public String invalidPassword = "incorrectpassword";
	public String loginPageUrl = "http://the-internet.herokuapp.com/login";
	public String ExpectedPostAuthUrl = "http://the-internet.herokuapp.com/secure";
	public String ExpectedPostLogoutUrl = "http://the-internet.herokuapp.com/login";

	// Scenario 1
	@Test
	
	public void UnsuccessfulLoginBadPassword(){
		
		// Load login page
		driver.get(loginPageUrl);
		LoginPage LoginPage = new LoginPage(driver);
		assertTrue(LoginPage.isInitialized());

		// Enter credentials & submit form
		LoginPage.enterUsername(validUsername);
		LoginPage.enterPassword(invalidPassword);
		LoginPage.SubmitForm();

		// Boolean for validation message
		Boolean ValidateErrorMessage = driver.getPageSource().contains("Your password is invalid!");
		
		// Assert 
		Assert.assertTrue("Invalid password error not output.", ValidateErrorMessage);

	}
	
	// Scenario 2
	@Test
	public void UnsuccessfulLoginBadUsername(){
		
		// Load login page
		driver.get(loginPageUrl);
		LoginPage LoginPage = new LoginPage(driver);
		assertTrue(LoginPage.isInitialized());
		
		// Enter credentials & submit form
		LoginPage.enterUsername(invalidUsername);
		LoginPage.enterPassword(validPassword);
		LoginPage.SubmitForm();

		// Boolean for validation message
		Boolean ValidateErrorMessage = driver.getPageSource().contains("Your username is invalid!");
		
		// Assert 
		Assert.assertTrue("Invalid username error not output.", ValidateErrorMessage);

	}
	
	// Scenario 3
	@Test
	public void SuccessfulLogin(){
		
		// Load login page
		driver.get(loginPageUrl);
		LoginPage LoginPage = new LoginPage(driver);
		assertTrue(LoginPage.isInitialized());

		// Enter credentials & submit form
		LoginPage.enterUsername(validUsername);
		LoginPage.enterPassword(validPassword);
		LoginPage.SubmitForm();

		// Load secure page 
		SecurePage SecurePage = new SecurePage(driver);
		
		// Click logout 
		SecurePage.ClickLogout();
		
		// Asset expected log out condition
		assertEquals("Secure page was not reached after expected sucsesful login", ExpectedPostLogoutUrl, driver.getCurrentUrl());
	}	
	

	

}