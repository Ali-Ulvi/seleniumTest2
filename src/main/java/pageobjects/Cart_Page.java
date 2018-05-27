package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static tests.Base.driver;
import static tests.Base.wait;


public class Cart_Page {


    public static List<WebElement> brandNameSpans() {
        return new WebDriverWait(driver, 50).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#basketContent > div.col-lg-12.col-md-12.col-xs-12.grid-pad-top-bottom-20.basketList > div > ul > li > div.productsContainer > div.col-lg-6.col-md-6.col-xs-6.no-padding-left.productInfo > a > span.title")));
    }

    public static List<WebElement> productNameSpans() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#basketContent > div.col-lg-12.col-md-12.col-xs-12.grid-pad-top-bottom-20.basketList > div > ul > li > div.productsContainer > div.col-lg-6.col-md-6.col-xs-6.no-padding-left.productInfo > a > span.description")));
    }


}
