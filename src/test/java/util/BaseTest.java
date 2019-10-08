package util;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    private static WebDriver driver;

    @Before
    public void BeforeTest(){
        if(driver == null){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    @After
    public void AfterTest(){
        driver.quit();
        driver = null;
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
