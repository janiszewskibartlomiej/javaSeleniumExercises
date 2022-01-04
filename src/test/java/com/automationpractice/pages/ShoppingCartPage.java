package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends AbstractPage {
    private final WebDriver driver;
    private final By OK_ICON = By.cssSelector("#layer_cart i.icon-ok");
    private final By MESSAGE = By.cssSelector("#layer_cart h2");
    private final By PRODUCT_NAME = By.cssSelector("#layer_cart_product_title");
    private final By QUANTITY = By.cssSelector("#layer_cart_product_quantity");
    private final By COLOR = By.cssSelector("#layer_cart_product_attributes");
    private final By TOTAL_PRICE = By.cssSelector("#layer_cart_product_price");
    private final By PROCEED_TO_CHECKOUT = By.cssSelector("#layer_cart_product_price");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        waitForElementVisile(OK_ICON);
    }

    public String getCurrentProductName() {
        return getText(PRODUCT_NAME);
    }

    public String getMessageText() {
        return getText(MESSAGE);
    }

    public long getQuantity() {
        return Long.parseLong(getText(QUANTITY));
    }

    public String getColorAndSize() {
        return getText(COLOR);
    }

    public String getTotalPrice() {
        return getText(TOTAL_PRICE);
    }

    public void protectedToCheckout() {
        clickOnElement(PROCEED_TO_CHECKOUT);
    }
}
