package seleniumTests.PageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecurePage extends BasePage {

	// Logout Button
	@FindBy(partialLinkText="Logout")
	private WebElement logoutButton;
	
	// Constructor
	public SecurePage(WebDriver driver) {
	    super(driver);
	    assertTrue(logoutButton.isDisplayed());
	}
	
	// Verify the page is ready before testing
	public boolean isInitialized() {
		return logoutButton.isDisplayed();
	}
		
	// Click logout button
	public void ClickLogout(){
		this.logoutButton.click();
	}
	
	
}
