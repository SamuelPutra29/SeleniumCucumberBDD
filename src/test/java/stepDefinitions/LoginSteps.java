package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

import java.io.File;

public class LoginSteps {

    public WebDriver driver;
    public LoginPage lp;

    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "Drivers" + File.separator + "chromedriver");
        driver = new ChromeDriver();

        lp = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(5000);

    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        lp.setUserName(email);
        lp.setPassword(password);

    }

    @When("Click on Login")
    public void click_on_login() {
        lp.clickBtnLogin();

    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
        if (driver.getPageSource().contains("Login was unsuccessful.")) {
            driver.close();
            Assert.assertTrue(false);
        } else {
            Assert.assertEquals(title, driver.getTitle());
        }

    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        lp.clickBtnLogout();
        Thread.sleep(3000);

    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }
}


