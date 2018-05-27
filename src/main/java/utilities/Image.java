package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;

import static tests.Base.driver;

public class Image {

    private static boolean isLoadedCheckWithJS(WebElement image) {
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript
                ("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image);

        return ImagePresent;
    }

    public static Boolean CheckLoaded(WebElement Im, String MarkerForRelativeUrls) {
        int Response;
        String Source = "";
        try {
            Source = Im.getAttribute("src");
            if (Source.equals("#")) {
                Log.error("Invalid Image Source: #");
                return false;
            }
            if (Source.startsWith(MarkerForRelativeUrls)) {
                String BaseUrl = new URL(driver.getCurrentUrl()).getHost();
                Source = BaseUrl + Source;
            }
            HttpURLConnection Connect = (HttpURLConnection) (new URL(Source)).openConnection();
            Response = Connect.getResponseCode();


            if (!((Response + "").startsWith("4") || (Response + "").startsWith("5"))) {

                if (!Im.isDisplayed()) {

                    Log.error("Img isDisplayed() is false " + ((Source == null) ? "null" : Source));
                    return false;

                }
                if (!isLoadedCheckWithJS(Im)) {

                    Log.error("Image Load Check with JS failed " + ((Source == null) ? "null" : Source));
                    return false;

                }

                if (!((Im.getAttribute("class") != null && Im.getAttribute("class").contains("loaded")) || (Im.getAttribute("lazy") != null && Im.getAttribute("lazy").contains("loaded")))) {

                    Log.error("Img has not CSS attribute value 'loaded'. " + ((Source == null) ? "null" : Source));
                    return false;

                }
                //ImageIO.read(new URL(Source)); //no exception means valid image
                return true;
            } else {
                Log.error("Invalid Image Source Response: " + Response + " " + ((Source == null) ? "null" : Source));
                return false;
            }
        } catch (Exception e) {
            Log.error(e.toString() + " Exception checking Image:" + ((Source == null) ? "null" : Source));
            e.printStackTrace();
            return false;
        }
    }

}
