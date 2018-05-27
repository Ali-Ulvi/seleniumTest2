package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static String url,email,password,chromeDriver,IEDriver,firefoxDriver,edgeDriver;
    public static void read(){
    Properties prop = new Properties();
    InputStream input = null;

	try {

        input = new FileInputStream("config.properties");

        prop.load(input);

        url=prop.getProperty("url");
        email=prop.getProperty("email");
        password=prop.getProperty("password");
        chromeDriver=prop.getProperty("chromeDriver");
        IEDriver=prop.getProperty("IEDriver");
        firefoxDriver=prop.getProperty("firefoxDriver");
        edgeDriver=prop.getProperty("EdgeDriver");

    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    }

}
