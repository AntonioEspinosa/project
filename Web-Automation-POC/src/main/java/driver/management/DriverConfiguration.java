package driver.management;

import initialization.ReadConfigFiles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

public class DriverConfiguration {

    private DriverConfiguration() {

    }

    public static WebDriver getMeADriver(Properties testProperties) {

        return BrowserPlatForm(testProperties.getProperty("browserPlatform"));

    }

    private static WebDriver BrowserPlatForm(String browser) {
        switch (browser) {

            default:
                System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                return new ChromeDriver(options);
        }
    }

}
