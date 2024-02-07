package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class PageProvider {
    private WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());

    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public SignUpPage signUpPage() {
        return new SignUpPage(webDriver);
    }

    public SignInPage signInPage() {
        return new SignInPage(webDriver);
    }

    public CartPage cartPage() {
        return new CartPage(webDriver);
    }

    public PageBookEy pageBookEy() {
        return new PageBookEy(webDriver);
    }
}
