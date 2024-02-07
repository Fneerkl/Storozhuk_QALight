package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageBookEy {

    @FindBy(xpath = ".//*[@class='auth-popup__bottom-link login-to-register']")
    private WebElement signUpLink;
    @FindBy(xpath = ".//input[@name='USER_LOGIN']")
    private WebElement email;
    @FindBy(xpath = ".//input[@name='USER_PASSWORD']")
    private WebElement password;
    @FindBy(xpath = ".//input[(@type='submit') and (@value='Увійти')]")
    private WebElement signInButton;

    public SignInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SignInPage clickOnSignUpLink() {
        clickOnElement(signUpLink);
        return this;
    }

    public SignInPage enterEmail(String email) {
        enterTextIntoInput(this.email, email);
        return this;
    }

    public SignInPage enterPassword(String password) {
        enterTextIntoInput(this.password, password);
        return this;
    }

    public SignInPage clickOnSignInButton() {
        clickOnElement(signInButton);
        return this;
    }
}
