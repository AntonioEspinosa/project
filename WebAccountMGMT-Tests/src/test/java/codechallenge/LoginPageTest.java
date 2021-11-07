package codechallenge;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pagemodels.saucedemo.CheckOutPage;
import pagemodels.saucedemo.InventoryPage;
import pagemodels.saucedemo.LoginPage;
import reports.ThymeLeafReports;
import tests.behaviour.BaseTest;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.minBy;

public class LoginPageTest extends BaseTest {


    @Test
    public void checkOutFlowTest() {
        LoginPage sauceLabsLoginPage = LoginPage.getPage();
        sauceLabsLoginPage.openPage();
        sauceLabsLoginPage.waitUntilPageLoads();
        sauceLabsLoginPage.setUserName("standard_user");
        sauceLabsLoginPage.setUserPasswordInput("secret_sauce");
        Assert.assertEquals(1, 1);
    }

    @Test
    public void checkOutFlowTest2() throws Exception {
        LoginPage sauceLabsLoginPage = LoginPage.getPage();
        sauceLabsLoginPage.openPage();
        sauceLabsLoginPage.waitUntilPageLoads();
        sauceLabsLoginPage.setUserName("standard_user");
        sauceLabsLoginPage.setUserPasswordInput("secret_sauce");
        sauceLabsLoginPage.clickLoginPage();
        InventoryPage inventoryPage = InventoryPage.getPage();
        inventoryPage.waitUntilIntentoryLoads().clickAddToCartASauceLabsTshirt().clickGoToCheckOutPage();
        CheckOutPage checkOutPage = CheckOutPage.getPage();
        checkOutPage.waitUntilCheckOutSummaryIsVisible();
        Assert.assertTrue(checkOutPage.isCartListVisible());
    }




}