package seleniumTests.PageObjects;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KeyPressesPage extends BasePage {

	// Input field
	@FindBy(id="target")
	private WebElement inputField;
	
	// Constructor
	public KeyPressesPage(WebDriver driver) {
	    super(driver);
	    assertTrue(inputField.isDisplayed());
	}
	
	// Verify the page is ready before testing
	public boolean isInitialized() {
		return inputField.isDisplayed();
	}
	
	// Send input to input field
	public void enterInput(Keys key){
		this.inputField.clear();
		this.inputField.sendKeys(key);
	}

}
