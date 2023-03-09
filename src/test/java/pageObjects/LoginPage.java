package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver ldriver;
    public LoginPage(WebDriver rdriver){

        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(xpath = "//input[@id='Email']")
    WebElement txtEmail;
    public void setUserName (String uname)
    {
        txtEmail.clear();
        txtEmail.sendKeys(uname);
    }
    @FindBy(xpath= "//input[@id='Password']")
    WebElement txtPassword;
    public void setPassword (String pwd)
    {
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;
    public void clickBtnLogin ()
    {
        btnLogin.click();
    }

    @FindBy( linkText= "Logout")
    WebElement btnLogout;
    public void clickBtnLogout()
    {
        btnLogout.click();
    }



}
