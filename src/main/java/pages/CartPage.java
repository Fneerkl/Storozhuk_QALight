package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBookEy {
    @FindBy(xpath = ".//*[@class='modal-content__btn-secondary btn--broad btn--active pull-right button' and contains(text(), 'Оформити замовлення')]")
    private WebElement settleOrderButton;
    @FindBy(xpath = ".//*[@class='number-picker__btn number-picker__btn--plus' and contains(text(), '+')]")
    private WebElement increaseItemsButton;
    @FindBy(xpath = ".//div[@class='checkout__price-new']")
    private WebElement itemPrice;
    @FindBy(xpath = ".//td[@class='checkout__td']/div[@class='font--big']")
    private WebElement totalPrice;
    @FindBy(xpath = ".//div[@class='number-picker']/input[(@type='text' and @class='number-picker__input')]")
    private WebElement numberCartItemsLabel;
    @FindBy(xpath = ".//td[@class='checkout__td']/div[@class='checkout__icon']")
    private WebElement deleteItemButton;
    @FindBy(xpath = ".//div[@class='modal-content modal-content--padding']/p[contains(text(), 'Товар доданий у кошик')]")
    private WebElement cartModalWindow;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CartPage clickOnSettleOrderButton() {
        clickOnElement(settleOrderButton);
        return this;
    }

    public CartPage clickOnIncreaseItems() {
        clickOnElement(increaseItemsButton);
        return this;
    }
    public double getItemCartPrice()
    {
        return getPriceDouble(getTextInElement(itemPrice));
    }

    public double getTotalCartPrice()
    {
        return getPriceDouble(getTextInElement(totalPrice));
    }

    public String getNumberOfItemsInCart() {
        return getAttributeInElement(numberCartItemsLabel, "value");
    }

    private double getPriceDouble(String priceMsg)
    {
        return Double.parseDouble(priceMsg.replace(" грн", ""));
    }

    public CartPage clickOnDeleteButton() {
        clickOnElement(deleteItemButton);
        return this;
    }

    public Boolean waitCartModalDisappear() {
        return waitElementDisappear(cartModalWindow, 5);
    }

}
