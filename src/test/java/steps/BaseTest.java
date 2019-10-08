package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    private static WebDriver driver;

    @Before
    public void BeforeTest(){
        String sistemaOperacional =  System.getProperty("os.name");

        if (sistemaOperacional.toUpperCase().contains("WINDOWS")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        }

        if(driver == null){
            System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
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
