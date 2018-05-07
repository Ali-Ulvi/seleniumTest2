package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Home_Page {
    private static WebElement element = null;

    public static List<WebElement> article_News(ChromeDriver driver){

        List<WebElement> elements = driver.findElements(By.cssSelector("#root > div > div > div:nth-child(5) > div:nth-child(2) > div > div > div > article"));

        return elements;

    }

    public static  WebElement  article_FirstNews(ChromeDriver driver){

          element = driver.findElement(By.cssSelector("#root > div > div > div:nth-child(5) > div:nth-child(2) > div > div > div > article"));

        return element;

    }
}
