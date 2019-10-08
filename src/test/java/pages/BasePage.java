package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import steps.BaseTest;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    public static Logger logger;

    public BasePage(){
        this.driver = BaseTest.getDriver();
        logger = Logger.getLogger(BasePage.class);
    }

    protected Boolean esperaElementoFicarVisivel(WebElement element, long segundos) {
        WebElement webElement = element;
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(segundos))
                    .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class).ignoring(TimeoutException.class);
            try {
                webElement = wait.until(ExpectedConditions.elementToBeClickable(webElement));
            } catch (Exception e) {
                return false;
            }
        } catch (NoSuchElementException e) {
            System.out.println("Elemento não foi encontrado!");
            return false;
        } catch (StaleElementReferenceException e) {
            return false;
        }
        return webElement!=null;
    }

}
