package pages;

import libs.ConfigProvider;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ParentPage extends WebElementHelper {

    final String baseUrl = ConfigProvider.configProperties.base_url();

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    protected void checkCurrentUrl() {
        Assert.assertEquals("Invalid page"
                , baseUrl
                , webDriver.getCurrentUrl()
        );

    }
}


