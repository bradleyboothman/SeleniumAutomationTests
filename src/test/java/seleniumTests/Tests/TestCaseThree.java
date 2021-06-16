package seleniumTests.Tests;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;

import seleniumTests.PageObjects.KeyPressesPage;

public class TestCaseThree extends BaseTest {
	
	public String keyPressesPageUrl = "http://the-internet.herokuapp.com/key_presses";
	
	@Test
	public void Escape() throws InterruptedException{
		
		// Load the key presses page
		driver.get(keyPressesPageUrl);
		KeyPressesPage KeyPressesPage = new KeyPressesPage(driver);
		assertTrue(KeyPressesPage.isInitialized());
		
		// Escape key
		KeyPressesPage.enterInput(Keys.ESCAPE);

		// Check for respone
		Boolean EscapeResult = driver.getPageSource().contains("You entered: ESCAPE");
		Assert.assertTrue("Key enetered did not match expected output.", EscapeResult);
	}

	@Test
	public void Control() throws InterruptedException{
		
		// Load the key presses page
		driver.get(keyPressesPageUrl);
		KeyPressesPage KeyPressesPage = new KeyPressesPage(driver);
		assertTrue(KeyPressesPage.isInitialized());
		
		// Control key
		KeyPressesPage.enterInput(Keys.CONTROL);

		// Check for respone
		Boolean ControlResult = driver.getPageSource().contains("You entered: CONTROL");
		Assert.assertTrue("Key enetered did not match expected output.", ControlResult);
	}
	
	@Test
	public void Tab() throws InterruptedException{
		
		// Load the key presses page
		driver.get(keyPressesPageUrl);
		KeyPressesPage KeyPressesPage = new KeyPressesPage(driver);
		assertTrue(KeyPressesPage.isInitialized());
		
		// Tab key
		KeyPressesPage.enterInput(Keys.TAB);

		// Check for respone
		Boolean TabResult = driver.getPageSource().contains("You entered: TAB");
		Assert.assertTrue("Key enetered did not match expected output.", TabResult);
	}
	
	@Test
	public void Shift() throws InterruptedException{
		
		// Load the key presses page
		driver.get(keyPressesPageUrl);
		KeyPressesPage KeyPressesPage = new KeyPressesPage(driver);
		assertTrue(KeyPressesPage.isInitialized());
		
		// Shift key
		KeyPressesPage.enterInput(Keys.SHIFT);

		// Check for respone
		Boolean ShiftResult = driver.getPageSource().contains("You entered: SHIFT");
		Assert.assertTrue("Key enetered did not match expected output.", ShiftResult);
	}
	
}