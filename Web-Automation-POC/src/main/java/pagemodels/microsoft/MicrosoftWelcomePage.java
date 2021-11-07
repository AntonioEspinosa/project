package pagemodels.microsoft;

import com.google.common.io.Resources;
import driver.management.DefaultDriverConfig;
import driver.management.DriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import pagemodels.DefaultModel;

import java.util.ArrayList;
import java.util.List;

public class MicrosoftWelcomePage extends DefaultModel {

    @FindBy(xpath="//div[@class='wf-menu']//div[@class='c-uhf-menu js-nav-menu']")
    WebElement containerMenu;

    @FindBys(@FindBy(xpath="//li[@class='f-sub-menu js-nav-menu nested-menu']//ul)"))
    List<WebElement> subMenuCategories;

    public void clickContainerMenu(){
        containerMenu.click();
    }

    public List<String> getElementsInContainerMenu(){

        List<String> results = new ArrayList<String>();
        /*for(WebElement webElement :   subMenuCategories){
            results.add(webElement.getText());
        }

        subMenuCategories.forEach(webElement -> results.add(webElement.getText()));*/


        return  results;
    }



}
