package pagemodels.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagemodels.DefaultModel;

import java.time.Duration;

public class CheckOutPage extends DefaultModel {


    By cartList = By.xpath("//div[@class='cart_list']");

    @FindBy(xpath="//div[@class='cart_list']")
    WebElement cartListPageFactory;


    public void waitUntilCheckOutSummaryIsVisible(){
        WebElement firstResult = new WebDriverWait(driver,ExplicitWaitTime )
                .until(ExpectedConditions.visibilityOf( driver.findElement( cartList)));
    }

    public boolean isCartListVisible(){
        return cartListPageFactory.isDisplayed();
    }



    public static CheckOutPage getPage(){
        return  new CheckOutPage();
    }

}
