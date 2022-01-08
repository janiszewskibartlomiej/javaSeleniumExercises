package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartSummaryPage extends AbstractPage {
    private final WebDriver driver;
    private final By PRODUCT_NAME = By.cssSelector(".cart_description > .product-name > a");
    private final By QUANTITY = By.cssSelector("input[name^='quantity']:not(input[type='hidden'])");
    private final By COLOR_AND_SIZE = By.cssSelector(".cart_description > small > a");
    private final By TOTAL_PRICE = By.cssSelector("span[id^='total_product_price']");

    public ShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        waitForElementVisible(PRODUCT_NAME);
    }

    public String getCurrentProductName() {
        return getText(PRODUCT_NAME);
    }

    public long getQuantity() {
        return Long.parseLong(getElement(QUANTITY).getAttribute("value"));
    }

    public String getColorAndSize() {
        return getText(COLOR_AND_SIZE);
    }

    public String getTotalPrice() {
        return getText(TOTAL_PRICE);
    }

}
