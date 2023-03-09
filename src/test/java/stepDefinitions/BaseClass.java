package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class BaseClass {
    public WebDriver driver;
    public LoginPage lp;
    public AddCustomerPage addcust;


    // Created for generating random string for Unique email
    public static String randomestring()
    {
        String generatedString1 = RandomStringUtils.randomAlphabetic(5);
        return (generatedString1);
    }





}
