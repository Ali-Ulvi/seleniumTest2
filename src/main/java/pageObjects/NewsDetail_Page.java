package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class NewsDetail_Page {

    private static WebElement element = null;

    public static  WebElement  h1_ArticleTitle(ChromeDriver driver){

        element = driver.findElement(By.cssSelector("h1.article__title"));

        return element;

    }
}
