package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageBookEy extends ParentPage {
    @FindBy(xpath = ".//span[@class='header-bottom__login-txt' and contains(text(), 'Увійти або Зареєструватися')]")
    private WebElement signInOrSignUpButton;
    @FindBy(xpath = ".//*[@class='ctlg-left__link' and contains(text(), 'Дитяча література')]")
    private WebElement kidsLiteratureCategoryLink;
    @FindBy(xpath = ".//*[@class='header__catalog-btn' and contains(text(), 'Каталог товарів')]")
    private WebElement categoryDropdownButton;
    @FindBy(xpath = ".//*[@class='product__btn-text' and contains(text(), 'Купити')]")
    private WebElement buyButton;
    @FindBy(xpath = ".//*[@class='header-bottom__basket-quant']")
    private WebElement cartLabel;

    public PageBookEy(WebDriver webDriver) {
        super(webDriver);
    }

    public PageBookEy openPage() {
        try {
            webDriver.get(baseUrl);
            logger.info("Sign Up page was opened " + baseUrl);
        } catch (Exception e) {
            logger.error("Can not open Sign Up Page");
            Assert.fail("Can not open Sign Up Page");
        }
        return this;
    }

    public PageBookEy clickOnSignInOrSignUpButton() {
        clickOnElement(signInOrSignUpButton);
        return this;
    }

    public String getCartLabelText() {
        return getTextInElement(cartLabel);
    }

    public Boolean waitWelcomeMessage(String name, int waitSeconds) {
        String welcomeMsgXPath = String.format(".//span[@class='header-bottom__login-txt' and contains(text()[2], '%s')]", name);
        return waitElementExists(welcomeMsgXPath, waitSeconds);
    }

    public PageBookEy clickOnListOfCategoriesDropDownButton() {
        clickOnElement(categoryDropdownButton);
        return this;
    }

    public PageBookEy clickOnKidsLiteratureCategoryMenu() {
        clickOnElement(kidsLiteratureCategoryLink);
        return this;
    }

    public PageBookEy clickOnBuyButton() {
        clickOnElement(buyButton);
        return this;
    }
}
