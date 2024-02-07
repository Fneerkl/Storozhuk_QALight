package cartTest;

import common.tests.BaseSeleniumTest;
import org.junit.Assert;
import org.junit.Test;

public class CartTest extends BaseSeleniumTest {

    @Test
    public void putItemToCart() {
        pageProvider.pageBookEy().openPage();
        pageProvider.pageBookEy().clickOnListOfCategoriesDropDownButton();
        pageProvider.pageBookEy().clickOnKidsLiteratureCategoryMenu();
        pageProvider.pageBookEy().clickOnBuyButton();
        pageProvider.cartPage().clickOnSettleOrderButton();

        Assert.assertEquals("1", pageProvider.pageBookEy().getCartLabelText());
    }

    @Test
    public void changeNumberOfItemsInTheCart() throws InterruptedException {
        pageProvider.pageBookEy().openPage();
        pageProvider.pageBookEy().clickOnListOfCategoriesDropDownButton();
        pageProvider.pageBookEy().clickOnKidsLiteratureCategoryMenu();
        pageProvider.pageBookEy().clickOnBuyButton();
        pageProvider.cartPage().clickOnIncreaseItems();

        //wait until calculation completed
        Thread.sleep(2000);

        Assert.assertEquals("2", pageProvider.cartPage().getNumberOfItemsInCart());
        double itemPrice = pageProvider.cartPage().getItemCartPrice();
        double totalPrice = pageProvider.cartPage().getTotalCartPrice();

        Assert.assertEquals(totalPrice, itemPrice * 2, 0);
    }

    @Test
    public void deleteItemsInTheCart() {
        pageProvider.pageBookEy().openPage();
        pageProvider.pageBookEy().clickOnListOfCategoriesDropDownButton();
        pageProvider.pageBookEy().clickOnKidsLiteratureCategoryMenu();
        pageProvider.pageBookEy().clickOnBuyButton();
        pageProvider.cartPage().clickOnDeleteButton();

        //Assert
        Assert.assertTrue("Cart modal window wasn't closed", pageProvider.cartPage().waitCartModalDisappear());
    }
}
