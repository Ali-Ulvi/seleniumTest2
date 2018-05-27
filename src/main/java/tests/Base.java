package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.Home_Page;

import static utilities.Config.*;

public class Base {
    public static WebDriver driver = null;
    public static WebDriverWait wait;

    public enum Tabs {
        KADIN("item2"),
        ERKEK("item3"),
        COCUK("item4"),
        SPORGIYIM("item5"),
        AYAKKABICANTA("item6"),
        SAATAKSESUAR("item7"),
        KOZMETIK("item8"),
        EVYASAM("item9"),
        HIZLITESLIMAT("item10");

        private String idAttr;

        Tabs(String idAttr) {
            this.idAttr = idAttr;
        }

        public String idAttr() {
            return idAttr;
        }
    }

    static void setUp(String browser) {
        read(); // reads config.properties file
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", firefoxDriver);
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", chromeDriver);
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", IEDriver);
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", edgeDriver);
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }

        wait = new WebDriverWait(driver, 20);
        driver.navigate().to(url);
        try {

            Home_Page.popUpCloseIcon().click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#genderPopup > div")));
        } catch (Exception e) {
        }
    }

    static void tearDown() {
        try {
            Thread.sleep(1111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
        driver.quit();
    }
}
