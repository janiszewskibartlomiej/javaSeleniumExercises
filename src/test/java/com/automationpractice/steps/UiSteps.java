package com.automationpractice.steps;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.PopularProductPage;
import com.automationpractice.pages.ShoppingCartPage;
import com.automationpractice.pages.ShoppingCartSummaryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class UiSteps {

    private WebDriver driver;
    private HomePage homePage;
    private PopularProductPage popularProductPage;
    private ShoppingCartPage shoppingCartPage;
    private ShoppingCartSummaryPage shoppingCartSummaryPage;

    public UiSteps(WebDriver driver) {
        this.driver = driver;
    }

    // Region Home Page
    public void goToHomePage() {
        homePage = new HomePage(driver);
        homePage.goToHomePage();
    }

    public ArrayList<WebElement> getPopularProductsList() {
        return homePage.getPopularProductsList();
    }

    public void openFirstProductInPopular() {
        homePage.goToFirstProductInPopular();
    }
    //End region Home Page

    // Region Popular Product Page
    public void addQuantityToCart(Long quantity) {
        popularProductPage = new PopularProductPage(driver);
        popularProductPage.switchToIframeProductCart();
        popularProductPage.setQuantity(String.valueOf(quantity));
    }

    public void selectBiggestSize() {
        popularProductPage.selectSize();
    }

    public void chooseAnotherColor() {
        popularProductPage.changeColor();
    }

    public void addToCart() {
        popularProductPage.addToCart();
    }

    public String getNameOfProduct() {
        return popularProductPage.getNameOfProduct();
    }

    public String getTotalPrice(Long quantity) {
        return popularProductPage.getTotalPrice(quantity);
    }
    // End region Popular Product Page

    //Region Shopping Cart Page
    public String getCurrentProductName() {
        shoppingCartPage = new ShoppingCartPage(driver);
        return shoppingCartPage.getCurrentProductName();
    }

    public String getShoppingCartMessageText() {
        return shoppingCartPage.getMessageText();
    }

    public long getCurrentQuantity() {
        return shoppingCartPage.getQuantity();
    }

    public String getCurrentColorAndSize() {
        return shoppingCartPage.getColorAndSize();
    }

    public String getCurrentTotalPrice() {
        return shoppingCartPage.getTotalPrice();
    }

    public void protectedToCheckout() {
        shoppingCartPage.protectedToCheckout();
    }
    //End region Shopping Cart Page

    //Region Shopping Cart Summary Page
    public String getProductNameOnShoppingCartSummary() {
        shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        return shoppingCartSummaryPage.getCurrentProductName();
    }

    public long getQuantityOnShoppingCartSummary() {
        return shoppingCartSummaryPage.getQuantity();
    }

    public String getColorAndSizeOnShoppingCartSummary() {
        return shoppingCartSummaryPage.getColorAndSize();
    }

    public String getTotalPriceOnShoppingCartSummary() {
        return shoppingCartSummaryPage.getTotalPrice();
    }
}
