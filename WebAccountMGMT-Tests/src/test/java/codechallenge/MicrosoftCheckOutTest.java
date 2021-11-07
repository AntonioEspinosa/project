package codechallenge;

import pagemodels.saucedemo.LoginPage;
import reports.ThymeLeafReports;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pagemodels.DefaultModel;

public class MicrosoftCheckOutTest {

    DefaultModel MsWelcomePage= null;
    LoginPage sauceLabsLoginPage= null;

    @BeforeMethod
    public void initTetsResources(){
        //MsWelcomePage = new DefaultModel();

    }

    @Test
    public void checkOutFlowTest(){
        sauceLabsLoginPage = new LoginPage();
        sauceLabsLoginPage.openPage();
        sauceLabsLoginPage.setUserName("standard_user");
        sauceLabsLoginPage.setUserPasswordInput("secret_sauce");
        sauceLabsLoginPage.clickLoginPage();
    }






}
