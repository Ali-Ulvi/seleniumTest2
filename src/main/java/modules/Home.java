package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageobjects.Butik_Page;
import pageobjects.Home_Page;
import utilities.Image;
import utilities.Log;
import utilities.Utility;

import java.util.List;
import java.util.Random;

import static tests.Base.driver;
import static tests.Base.wait;
import static utilities.Config.email;
import static utilities.Config.password;

public class Home {

    public static void login() {

        Home_Page.logoIcon().click();
        Home_Page.emailBox().sendKeys(email);
        Home_Page.passwordBox().sendKeys(password);
        Home_Page.loginSubmitButton().click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loginSubmit")));
    }


    public static void openTab(String id) {
        WebElement tab = Home_Page.tab(id);
        String tabName = tab.getText();
        tab.click();
        Log.info(id + ": " + tabName + " tab is opened");
        tab = Home_Page.tab(id);
        Assert.assertTrue(tab.getAttribute("class").contains("hoverColor"), "Sayfa gecisinde problem: Gecilen kategori ismi secili(hover) renge sahip degil.");
    }


    public static void checkTabImages() {
        List<WebElement> butikImgs = Home_Page.butikImgs();
        Log.info("number of butik images:" + butikImgs.size());
        Boolean succes = true;

        for (WebElement butik : butikImgs) {
            Utility.scrollToView(butik);
            if (!Image.CheckLoaded(butik, "/"))
                succes = false;
        }
        if (!succes) {
            Log.error("Some Butik image(s) not loaded");
        }
    }


    public static void goToARandomButikOnPage() {
        List<WebElement> butiks = Home_Page.butiks();
        WebElement butik = butiks.get(new Random().nextInt(butiks.size()));
        Utility.scrollToView(butik);

        //wait.until(ExpectedConditions.attributeContains(butik,"class","loaded"));
        butik.click();
        Log.info("Butik opened: " + driver.getTitle().replace(" | Trendyol", "") + " " + driver.getCurrentUrl());
        Assert.assertFalse(Butik_Page.butikTitle().isEmpty(), "Butik title not found");
    }

    public static void checkCartSize(int productCount) {
        String count = String.valueOf(productCount);
        WebElement cart = Home_Page.cart();
        wait.until(ExpectedConditions.textToBePresentInElement(cart, count));
        Assert.assertEquals(cart.getText(), count, "Item count of cart is wrong");
    }
}
