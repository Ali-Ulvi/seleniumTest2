package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Log;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

import static tests.Base.driver;
import static tests.Base.wait;


public class Butik_Page {
    private static WebElement element = null;

    public static String butikTitle() {

        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.boutique-title > h1"))).getText();

    }

    public static WebElement link_tumButikler() {
        element = driver.findElement(By.cssSelector("#breadCrumbs > ul > li:nth-child(1) > a"));
        Utility.scrollToView(element);
        return element;

    }

    public static List<WebElement> products() {

        return driver.findElements(By.cssSelector("li.product-box"));

    }

    public static List<WebElement> productImgs() {

        List<WebElement> products = products();
        List<WebElement> productImgs = new ArrayList<WebElement>();
        for (WebElement product : products) {
            try {
                productImgs.add(product.findElement(By.tagName("img")));
            } catch (Exception e) {
                Log.error("Image not found on product with id " + product.getAttribute("data-id"));
            }
        }
        return productImgs;
    }

}
