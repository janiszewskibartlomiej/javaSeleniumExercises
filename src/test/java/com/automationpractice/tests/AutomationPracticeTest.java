package com.automationpractice.tests;

import com.automationpractice.steps.UiSteps;
import com.automationpractice.utils.ReadJsonTestData;
import com.automationpractice.utils.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.Map;


public class AutomationPracticeTest {
    private WebDriver driver;
    private Map<String, Object> testData;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = WebDriverFactory.getChromeDriver(false);
    }

    @AfterEach
    void teardown() {
        WebDriverFactory.tearDownDriver();
    }

    @Test
    public void testCartFunctionality() {
        /*
        First scenario

        0. Navigate to the site http://automationpractice.com/index.php
        1. Open any popular product from the main page
        2. Add Quantity as "2" by typing it into the proper field. Choose the biggest size and another color.
        3. Add product to the cart.
        4. Proceed to checkout
        5. Make assertions in tests when it is needed, using your experience.
        6. Add code to Git for review
         */

        //Given
        UiSteps uiSteps = new UiSteps(driver);
        testData = ReadJsonTestData.getJsonObject();
        uiSteps.goToHomePage();
        //When
        uiSteps.openFirstProductInPopular();
        uiSteps.addQuantityToCart((Long) testData.get("quantity"));
        uiSteps.selectBiggestSize();
        uiSteps.chooseAnotherColor();
        String nameOfProduct = uiSteps.getNameOfProduct();
        String expectedTotalPrice = uiSteps.getTotalPrice((Long) testData.get("quantity"));
        uiSteps.addToCart();

        String currentNameOfProduct = uiSteps.getCurrentProductName();
        String currentMessage = uiSteps.getShoppingCartMessageText();
        long currentQuantity = uiSteps.getCurrentQuantity();
        String currentColorAndSize = uiSteps.getCurrentColorAndSize();
        String currentTotalPrice = uiSteps.getCurrentTotalPrice();
        //Then
        Assertions.assertEquals(nameOfProduct, currentNameOfProduct);
        Assertions.assertEquals(expectedTotalPrice, currentTotalPrice);
        Assertions.assertEquals(testData.get("expectedSuccessfullyAddedMessage"), currentMessage);
        Assertions.assertEquals(testData.get("quantity"), currentQuantity);
        Assertions.assertEquals(testData.get("expectedColorAndSize"), currentColorAndSize);
        // When
        uiSteps.protectedToCheckout();

    }
}
