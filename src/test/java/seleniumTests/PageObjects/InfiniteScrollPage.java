package seleniumTests.PageObjects;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;

// Page Object Modal - http://the-internet.herokuapp.com/infinite_scroll

public class InfiniteScrollPage extends BasePage {

	public JavascriptExecutor JSExecutor;
	
	// Parent div that generated divs are contained within
	@FindBy(className="jscroll-inner")
	private WebElement parentDiv;
	
	// Array of webelements with class 'jscroll-added' - these are added as user scrolls down
	@FindBy(xpath = "//div[@class='jscroll-inner']//div[@class='jscroll-added']")
	private List<WebElement> scrollGeneratedDivs;
	
	// Page footer
	@FindBy(id="page-footer")
	private WebElement pageFooter;
	
	// Constructor
	public InfiniteScrollPage(WebDriver driver) {
	    super(driver);
	    assertTrue(parentDiv.isDisplayed());
	}

	// Verify the page is ready before testing
	public boolean isInitialized() {
		return parentDiv.isDisplayed();
	}
	
	// Scroll to bottom of page
	public void scrollToBottomOfPage(int times) throws InterruptedException{
		for(int i = 0; i < times; ++i) {
			Thread.sleep(1000);
			JSExecutor = (JavascriptExecutor) driver;
		    JSExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}
	}
	
	// Scroll to top of page
	public void scrollToTopOfPage(int times) throws InterruptedException{
		for(int i = 0; i < times; ++i) {
			Thread.sleep(1000);
			JSExecutor = (JavascriptExecutor) driver;
			JSExecutor.executeScript("window.scrollTo(0, 0);");
		}	
	}
	
	// To access the size of 'jscroll-added' array
	public int countDivs(){
		return this.scrollGeneratedDivs.size();
	}
		
}
