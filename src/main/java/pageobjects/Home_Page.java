package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Log;

import java.util.ArrayList;
import java.util.List;

import static tests.Base.driver;
import static tests.Base.wait;


public class Home_Page {
    private static WebElement element = null;

    public static WebElement logoIcon() {

        element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#accountNavigationRoot > div > ul > li.login-register-button-container")));
        return element;

    }


    public static WebElement popUpCloseIcon() {

        element = driver.findElement(By.cssSelector("body > div.fancybox-overlay.fancybox-overlay-fixed > div > div > a"));


        return element;

    }

    public static WebElement emailBox() {
        element = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        return element;

    }

    public static WebElement passwordBox() {

        element = driver.findElement(By.id("password"));
        return element;

    }

    public static WebElement loginSubmitButton() {

        element = driver.findElement(By.id("loginSubmit"));
        return element;

    }

    public static WebElement cart() {

        return driver.findElement(By.id("basketItemCount"));
    }

    public static List<WebElement> butiks() {
        return driver.findElements(By.cssSelector("div.butik > div > a"));
    }

    public static List<WebElement> butikImgs() {
        List<WebElement> butiks = butiks();
        List<WebElement> butikImgs = new ArrayList<WebElement>();
        for (WebElement butik : butiks) {
            try {

                //butikImgs.add(butik.findElement(By.tagName("img")));
                butikImgs.add(wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(butik,By.tagName("img"))));
            } catch (Exception e) {
                Log.error("Image not found on butik with id " + butik.getAttribute("data-id"));
            }

        }
        return butikImgs;

    }
}
