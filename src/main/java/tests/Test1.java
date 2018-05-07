package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObjects.Home_Page;
import pageObjects.NewsDetail_Page;
import utilities.BrokenLinks;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Test1 {
    final static String url = "https://techcrunch.com/";


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver.navigate().to(url);

        //Get news list
        List<WebElement> elements = Home_Page.article_News(driver);
        java.util.Iterator<WebElement> i = elements.iterator();
        while (i.hasNext()) {
            WebElement element = i.next();
            if (element.isDisplayed()) {
                //Verify that each news has an author
                assertTrue(element.findElement(By.className("river-byline__authors")).findElement(By.cssSelector("a[aria-label~=Posts]")).getText().length()>0, "Author of news not found");
                //Verify that each news has an image
                assertTrue(element.findElement(By.tagName("img")).getAttribute("src").startsWith("http"), "Image of news not found");

            }

            //Click one of them to reach the full content
            Home_Page.article_FirstNews(driver).click();

            //Verify that the browser title is the same with the news title
            assertEquals(driver.getTitle(),NewsDetail_Page.h1_ArticleTitle(driver).getText()+" | TechCrunch","Browser and news title are not the same");

            //Verify the links within the news content
            BrokenLinks.Execute(driver);

        }


        driver.close();
        driver.quit();

    }
}
