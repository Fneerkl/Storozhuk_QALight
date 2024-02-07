package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignUpPage extends ParentPage {
    @FindBy(xpath = ".//input[(@type='submit') and (@value='Зареєструватись')]")
    private WebElement signUpButton;
    @FindBy(xpath = ".//input[@name='REGISTER[NAME]']")
    private WebElement registerName;
    @FindBy(xpath = ".//input[@name='REGISTER[EMAIL]']")
    private WebElement registerEmail;
    @FindBy(xpath = ".//input[@name='REGISTER[PERSONAL_PHONE]']")
    private WebElement registerPhone;
    @FindBy(xpath = ".//input[@name='REGISTER[PASSWORD]']")
    private WebElement registerPassword;
    @FindBy(xpath = ".//input[(@type='checkbox')and not(@value='Y')]")
    private WebElement checkboxAgree;

    public SignUpPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SignUpPage clickOnSignUpButton() {
        clickOnElement(signUpButton);
        return this;
    }

    public SignUpPage enterName(String name) {
        enterTextIntoInput(registerName, name);
        return this;
    }

    public SignUpPage enterEmail(String randomEmail) {
        enterTextIntoInput(registerEmail, randomEmail);
        return this;
    }

    public SignUpPage enterPhone(String mobile) {
        enterTextIntoInput(registerPhone, mobile);
        return this;
    }

    public SignUpPage enterPassword(String password) {
        enterTextIntoInput(registerPassword, password);
        return this;
    }

    public SignUpPage tickAgreementCheckbox(boolean status) {

        if (status != checkboxAgree.isSelected()) {
            checkboxAgree.click();
        }
        return this;
    }
}
