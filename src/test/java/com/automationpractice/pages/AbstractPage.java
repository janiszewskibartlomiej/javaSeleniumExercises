package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPage {

    public final int DEFAULT_TIMEOUT = 25;
    private final WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;

    }

    protected void visit(String url) {
        driver.get(url);

    }

    protected ArrayList<WebElement> getElements(By selector) {
        ArrayList elementList = new ArrayList<WebElement>();
        elementList.addAll(driver.findElements(selector));
        return elementList;
    }

    protected WebElement scrollToElement(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: \"end\"});", webElement);
        js.executeScript("arguments[0].scrollIntoView({block: \"center\"});", webElement);
        return webElement;
    }

    protected WebElement switchToIframe(WebElement webElement) {
        driver.switchTo().frame(webElement);
        return webElement;
    }

    protected WebElement getElement(By selector) {
        return driver.findElement(selector);
    }

    protected void typeInto(By selector, String value) {
        WebElement webElement = getElement(selector);
        webElement.clear();
        webElement.sendKeys(value);
    }

    protected void clickOnElement(By selector) {
        getElement(selector).click();
    }

    protected void waitForElementVisible(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    protected void selectValueByLastIndex(By selector) {
        Select select = new Select(getElement(selector));
        List<WebElement> optionList = select.getOptions();
        select.selectByIndex(optionList.size() - 1);
    }

    protected String getText(By selector) {
        return getElement(selector).getText();
    }

    protected boolean elementIsVisible(By selector) {
        waitForElementVisible(selector);
        return getElement(selector).isDisplayed();
    }
}
