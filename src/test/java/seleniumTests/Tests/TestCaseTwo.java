package seleniumTests.Tests;

import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Test;

import seleniumTests.PageObjects.InfiniteScrollPage;
import org.openqa.selenium.JavascriptExecutor;

public class TestCaseTwo extends BaseTest {
	
	public String infiniteScrollPageUrl = "http://the-internet.herokuapp.com/infinite_scroll";
	public JavascriptExecutor JSExecutor;
	
	@Test
	public void TestInfiniteScroll() throws InterruptedException{
		
		// Load infinite Scroll page
		driver.get(infiniteScrollPageUrl);
		InfiniteScrollPage InfiniteScrollPage = new InfiniteScrollPage(driver);
		assertTrue(InfiniteScrollPage.isInitialized());
		
		// Count text divs before scrolling
		int countPreScroll = InfiniteScrollPage.countDivs();
		
		// Scroll to bottom of page, parameter is # of times
		InfiniteScrollPage.scrollToBottomOfPage(2);
		
		// Scroll to top of page, parameter is # of times
		InfiniteScrollPage.scrollToTopOfPage(1);
		
	    // Count text divs after scrolling
	    int countPostScroll = InfiniteScrollPage.countDivs();
	    
	    // Asset more text divs after scrolling
	    Assert.assertTrue("Scrolling to the bottom of the page twice did not generate new 'jscroll-added' divs.", countPostScroll > countPreScroll);

	}
	
}