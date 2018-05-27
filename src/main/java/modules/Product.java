package modules;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.Cart_Page;
import pageobjects.Product_Page;

import java.util.List;

public class Product {

    public static void selectSize() { // selects "Beden" if exists
        try {
            Product_Page.bedenList().click();
            Product_Page.beden().click();
        } catch (Exception e) {
        }
    }

    public static void sepeteEkle() {
        String brandName = Product_Page.brandName();
        String productName = Product_Page.productName();

        WebElement btnSepeteEkle = Product_Page.btnSepeteEkle();
        btnSepeteEkle.click();

        //Go and Check Cart
        Product_Page.cartIcon().click();
        List<WebElement> brandNameSpans = Cart_Page.brandNameSpans();
        List<WebElement> productNameSpans = Cart_Page.productNameSpans();
        Boolean foundInCart = false;
        int index = 0;
        for (WebElement brandNameInCart : brandNameSpans) {
            if (brandNameInCart.getText().equals(brandName)) {
                foundInCart = true;
                break;
            }
            index++;
        }

        Assert.assertTrue(foundInCart, "Brand not found in cart after 'add to cart'");
        Assert.assertTrue(productName.startsWith(productNameSpans.get(index).getText()), "Product not found in cart after 'add to cart'");

    }
}
