package common.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageProvider;

import java.util.concurrent.TimeUnit;

public class BaseSeleniumTest {
    protected WebDriver webDriver;
    protected PageProvider pageProvider;
    protected Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() {
        logger.info("------ The test started ------");
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("Chrome was opened");
        pageProvider = new PageProvider(webDriver);
    }

    @Rule
    public TestName testName = new TestName();

    @After
    public void tearDown() {
        logger.info(
                String.format("Finished test: %s", testName.getMethodName()));
        try {
            webDriver.quit();
            logger.info("Browser was closed");
        } catch (Exception e) {
            logger.error(e);
        }
    }
}



