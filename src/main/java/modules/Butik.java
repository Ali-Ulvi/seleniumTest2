package modules;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.Butik_Page;
import pageobjects.Product_Page;
import utilities.Image;
import utilities.Log;
import utilities.Utility;

import static tests.Base.driver;

import java.util.List;

public class Butik {


    public static void checkProductImages() {
        List<WebElement> productImgs = Butik_Page.productImgs();
        Log.info("number of product images:" + productImgs.size());
        Boolean succes = true;

        for (WebElement product : productImgs) {
            Utility.scrollToView(product);
            if (!Image.CheckLoaded(product, "/"))
                succes = false;
        }
        if (!succes) {
            Log.error("Some Product image(s) not loaded");
        }
    }

    public static void clickTumButikler(){
        Butik_Page.link_tumButikler().click();
        Log.info("Tum Butikler page opened");
    }

    public static void goToAProduct() {
        Butik_Page.products().get(0).click();
        //check page
        String productName = Product_Page.productName();
        Assert.assertFalse(productName.isEmpty(),"Product name not found in product page.");
    }

}
