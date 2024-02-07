package signUpTest;

import common.tests.BaseSeleniumTest;
import org.junit.Assert;
import org.junit.Test;

import static data.TestData.*;

public class SignUpTest extends BaseSeleniumTest {

    @Test
    public void signUp() {

        pageProvider.pageBookEy().openPage();
        pageProvider.pageBookEy().clickOnSignInOrSignUpButton();
        pageProvider.signInPage().clickOnSignUpLink();
        pageProvider.signUpPage().enterName(VALID_NAME_UI);
        pageProvider.signUpPage().enterEmail(GET_RANDOM_EMAIL_UI());
        pageProvider.signUpPage().enterPhone(GET_MOBILE());
        pageProvider.signUpPage().enterPassword(VALID_PASSWORD_UI);
        pageProvider.signUpPage().tickAgreementCheckbox(true);
        pageProvider.signUpPage().clickOnSignUpButton();

        Assert.assertTrue("Welcome message didn't appear", pageProvider.pageBookEy().waitWelcomeMessage(VALID_NAME_UI, 30));
    }
}
