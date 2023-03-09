package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

import java.io.File;

public class LoginSteps extends BaseClass{


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
    public void click_on_login() throws InterruptedException {
        lp.clickBtnLogin();
        Thread.sleep(3000);

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

    @Then("User can view Dashboard")
    public void user_can_view_dashboard() throws InterruptedException {
        Thread.sleep(2000);
        addcust = new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addcust.getPageTitle());
    }
    @When("User click on customers Menu")
    public void user_click_on_customers_menu() throws InterruptedException {
        Thread.sleep(3000);
        addcust.clickOnCustomersMenu();

    }

    @When("click on customers Menu Item")
    public void click_on_customers_menu_item() throws InterruptedException {
        Thread.sleep(3000);
        addcust.clickOnCustomersMenuItem();

    }
    @When("click on Add new button")
    public void click_on_add_new_button() throws InterruptedException {
        addcust.clickOnAddnew();
        Thread.sleep(2000);
    }
    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration",addcust.getPageTitle());


    }
    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {

        String email = randomestring() + " @gmail.com";
        addcust.setEmail(email);
        addcust.setPassword("test123");
        addcust.setCustomerRoles("Guest");
        Thread.sleep(3000);

        addcust.setManagerOfVendor("Vendor 2");
        addcust.setGender("Male");
        addcust.setFirstName("Pavan");
        addcust.setLastName("kumar");
        addcust.setDob("7/05/1997");
        addcust.setCompanyName("QA");
        addcust.setAdminContent("This is for testing....");
    }
    @When("click on Save button")
    public void click_on_save_button() throws InterruptedException {
        addcust.clickOnSave();
        Thread.sleep(2000);

    }
    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msg) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("the new customer has been added successfully"));
    }

    @And("User click on Customer info")
    public void userClickOnCustomerInfo() {
        addcust.clickCustomInfo();
    }
}


