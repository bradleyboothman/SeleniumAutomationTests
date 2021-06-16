package seleniumTests.PageObjects;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//Page Object Modal - http://the-internet.herokuapp.com/login

public class LoginPage extends BasePage {

	// Username field
	@FindBy(id="username")
	private WebElement usernameField;
	
	// Password field
	@FindBy(id="password")
	private WebElement passwordField;

	// Login form
	@FindBy(id="login")
	private WebElement LoginForm;

	// Constructor
	public LoginPage(WebDriver driver) {
	    super(driver);
	    assertTrue(usernameField.isDisplayed());
	}
	
	// Verify the page is ready before testing
	public boolean isInitialized() {
		return usernameField.isDisplayed();
	}
	
	// Populate Username field
	public void enterUsername(String username){
		this.usernameField.clear();
		this.usernameField.sendKeys(username);
	}

	// Populate Password field
	public void enterPassword(String password){
		this.passwordField.clear();
		this.passwordField.sendKeys(password);
	}
	
	// Submit the login form
	public void SubmitForm(){
		this.LoginForm.submit();
	}
	
}
