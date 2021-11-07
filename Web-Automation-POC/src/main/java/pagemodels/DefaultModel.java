package pagemodels;


import driver.management.DriverConfiguration;
import initialization.DefaultAppConfig;
import initialization.ReadConfigFiles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.util.Properties;

public  class DefaultModel implements DefaultAppConfig,iWebDriverConstants {

    protected static Properties props = ReadConfigFiles.getPropertiesFromFile(DEFAULT_APP_CONFIG_FILE);
    protected static WebDriver driver=DriverConfiguration.getMeADriver(props);



    public DefaultModel(){
         PageFactory.initElements(driver,this);
    }

    public void openPage(){
        driver.get( props.get("testUrl").toString()  );
    }

    public void openPage(String URL){
        driver.get( URL  );
    }

    protected WebDriverWait getWebDriverWait(){
       return new WebDriverWait(driver, ExplicitWaitTime);
    }


    public void finalize(){
       for(String title : driver.getWindowHandles() ){
           driver.switchTo().window(title);
           driver.close();
       }
       driver.quit();
    }



}
