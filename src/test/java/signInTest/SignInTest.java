package signInTest;

import common.tests.BaseSeleniumTest;
import org.junit.Assert;
import org.junit.Test;

import static data.TestData.*;

public class SignInTest extends BaseSeleniumTest {

    @Test
    public void signIn() {
        pageProvider.pageBookEy().openPage();
        pageProvider.pageBookEy().clickOnSignInOrSignUpButton();
        pageProvider.signInPage().enterEmail(VALID_EMAIL_UI);
        pageProvider.signInPage().enterPassword(VALID_PASSWORD_UI);
        pageProvider.signInPage().clickOnSignInButton();

        //Assert
        Assert.assertTrue("Welcome message didn't appear", pageProvider.pageBookEy().waitWelcomeMessage(VALID_NAME_UI, 5));
    }
}
