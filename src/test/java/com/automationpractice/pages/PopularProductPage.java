package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopularProductPage extends AbstractPage {
    private final WebDriver driver;
    private final By IFRAME_PRODUCTS_CART = By.cssSelector("iframe[id^='fancybox-frame']");
    private final By CLOSE_PRODUCT_CART = By.cssSelector("a[title='Close']");
    private final By NAME_OF_PRODUCT = By.cssSelector("#product h1[itemprop='name']");
    private final By PRICE_OF_PRODUCT = By.cssSelector("#our_price_display");
    private final By QUANTITY_PRODUCT_INPUT = By.cssSelector("#quantity_wanted");
    private final By SIZE_OF_PRODUCTS_SELECT = By.cssSelector("#group_1");
    private final By SECOND_COLOR_OF_PRODUCT = By.cssSelector("#color_to_pick_list li:not(.selected)");
    private final By ADD_TO_CART_BUTTON = By.cssSelector("#add_to_cart button[name='Submit']");


    public PopularProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebElement switchToIframeProductCart() {
        waitForElementVisible(CLOSE_PRODUCT_CART);
        return switchToIframe(getElement(IFRAME_PRODUCTS_CART));
    }

    public void setQuantity(String quantity) {
        typeInto(QUANTITY_PRODUCT_INPUT, quantity);
    }

    public void changeColor() {
        clickOnElement(SECOND_COLOR_OF_PRODUCT);
    }

    public void addToCart() {
        clickOnElement(ADD_TO_CART_BUTTON);
    }

    public void selectSize() {
        selectValueByLastIndex(SIZE_OF_PRODUCTS_SELECT);
    }

    public String getNameOfProduct() {
        return getText(NAME_OF_PRODUCT);
    }

    public String getPriceOfProduct() {
        return getText(PRICE_OF_PRODUCT);
    }

    public String getTotalPrice(Long quantity) {
        float price = Float.parseFloat(getPriceOfProduct().substring(1));
        float totalPrice = (price * quantity);
        return "$" + totalPrice;

    }
}
