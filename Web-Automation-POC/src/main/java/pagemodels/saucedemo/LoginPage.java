package pagemodels.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pagemodels.DefaultModel;

public class LoginPage extends DefaultModel  {

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement userNameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement userPasswordInput;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    public void setUserName(String userName) {
        userNameInput.sendKeys(userName);
    }

    public void clickLoginPage(){
        loginButton.click();
    }

    public void waitUntilPageLoads(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(userNameInput));
    }

    public void setUserPasswordInput(String password) {
        userPasswordInput.sendKeys(password);
    }

    public static LoginPage getPage() {
        return new LoginPage();
    }


}
