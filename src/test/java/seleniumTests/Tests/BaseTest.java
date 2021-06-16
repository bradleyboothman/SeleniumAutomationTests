package seleniumTests.Tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// This class is here to hold all of the driver lifecycle management code

public class BaseTest {
	
    protected static WebDriver driver;

    @BeforeClass
    public static void setUp(){
    	
		System.setProperty("webdriver.chrome.driver", "src/test/resources/windows/chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
