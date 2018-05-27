package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static tests.Base.driver;
import static tests.Base.wait;


public class Product_Page {
    private static WebElement element = null;

    public static String productName() {

        return driver.findElement(By.cssSelector("#productInfoContainer > div > div:nth-child(1) > div > div.product-info-titlebox > h1 > span.product-name-text")).getText();
    }

    public static String brandName() {

        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#productInfoContainer > div > div:nth-child(1) > div > div.product-info-titlebox > h1 > span.product-brand-text"))).getText();
    }

    public static WebElement bedenList() {
        By bedenListLocator = By.cssSelector("#basketForm > div.variant-box > div.btn-group.bootstrap-select.variant-picker-select > button > span.filter-option.pull-left > span");
        return new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(bedenListLocator));
    }

    public static WebElement btnSepeteEkle() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#addToBasketButton > span.add-to-basket-text")));
    }

    public static WebElement cartIcon() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#myBasketListItem > div.icon-container > i")));
    }

    public static WebElement beden() {
        By bedenLocator = By.cssSelector("#mCSB_1 > div.mCSB_container > li:nth-child(2) > a > span.text");
        return new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(bedenLocator));
    }

}
