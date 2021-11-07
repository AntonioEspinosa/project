package pagemodels.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pagemodels.DefaultModel;

public class InventoryPage extends DefaultModel {

    @FindBy(xpath = "//div[@class='inventory_item_name' and contains(text(),'Sauce Labs Backpack') ]//ancestor::div[@class='inventory_item']//button")
    private WebElement sauceLabsTshirtButton;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement goToCheckOut;


    private By inventoryTable = By.xpath("//div[@id='inventory_container']//div[@class='inventory_list']");

    private By inventoryTableItem = By.xpath("//div[@class='inventory_item']");

    public InventoryPage clickAddToCartASauceLabsTshirt() {
        sauceLabsTshirtButton.click();
        return this;
    }

    public InventoryPage clickGoToCheckOutPage() {
        goToCheckOut.click();
        return this;
    }

    public static InventoryPage getPage() {
        return new InventoryPage();
    }

    public InventoryPage waitUntilIntentoryLoads() {
        getWebDriverWait().until(ExpectedConditions.presenceOfNestedElementsLocatedBy(inventoryTable, inventoryTableItem));
        return this;
    }


}
