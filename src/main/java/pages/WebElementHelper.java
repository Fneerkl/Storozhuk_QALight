package pages;

import libs.ConfigProvider;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementHelper {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected WebDriverWait webDriverWait05, webDriverWait15;

    public WebElementHelper(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait05 = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_EXPLICIT_WAIT_LOW()));
    }

    protected void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputted into input" + getElementName(input));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private String getElementName(WebElement webElement) {
        try {
            return webElement.getAccessibleName();
        } catch (Exception e) {
            return null;
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }

    protected void clickOnElement(WebElement element) {
        try {
            webDriverWait05.until(ExpectedConditions.elementToBeClickable(element));
            String elementName = getElementName(element);
            element.click();
            logger.info("Element was clicked " + elementName);
        } catch (Exception e) {
            logger.error("Click operation didn't work; " + e);
            Assert.fail("Click operation didn't; " + e);
        }
    }

    protected String getTextInElement(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            logger.error("Can not get text from element " + e);
            Assert.fail("Can not get text from element " + e);
        }

        return null;
    }

    protected String getAttributeInElement(WebElement element, String attribute) {
        try {
            return element.getAttribute(attribute);
        } catch (Exception e) {
            logger.error("Can not get text from element " + e);
            Assert.fail("Can not get text from element " + e);
        }

        return null;
    }

    protected Boolean waitElementExists(String xpath, int waitSeconds) {
        try {
            Wait<WebDriver> wait =
                    new FluentWait<>(webDriver)
                            .withTimeout(Duration.ofSeconds(waitSeconds))
                            .pollingEvery(Duration.ofMillis(300))
                            .ignoring(NoSuchElementException.class);

            wait.until(driver -> driver.findElement(By.xpath(xpath)).isDisplayed());

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected Boolean waitElementDisappear(WebElement element, int waitSeconds) {
        try {
            Wait<WebDriver> wait =
                    new FluentWait<>(webDriver)
                            .withTimeout(Duration.ofSeconds(waitSeconds))
                            .pollingEvery(Duration.ofMillis(300))
                            .ignoring(NoSuchElementException.class);

            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
