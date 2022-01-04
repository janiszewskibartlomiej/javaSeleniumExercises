package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class HomePage extends AbstractPage {
    final String BASE_URL = "http://automationpractice.com/index.php";
    private final WebDriver driver;
    private final By POPULAR_PRODUCTS = By.cssSelector("#homefeatured > li a.product_img_link > img");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public Object goToHomePage() {
        visit(BASE_URL);
        return this;
    }

    public ArrayList<WebElement> getPopularProductsList() {
        return getElements(POPULAR_PRODUCTS);
    }


    public PopularProductPage goToFirstProductInPopular() {
        ArrayList<WebElement> elementArrayList = getPopularProductsList();
        scrollToElement(elementArrayList.get(0)).click();
        return new PopularProductPage(driver);
    }
}