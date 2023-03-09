package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
    public WebDriver ldriver;
    public AddCustomerPage(WebDriver rdriver){

        ldriver = rdriver;
        PageFactory.initElements(ldriver,this);
    }

    By lnkCustomers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
    By lnkCustomers_menuitem = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");

    By btnAddnew = By.xpath("//a[@class='btn btn-primary']");
    By txtEmail = By.xpath("//input[@id='Email']");
    By txtPassword = By.xpath("//input[@id='Password']");

    By txtCustomerRoles = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");

    By lstitemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
    By lstitemRegistered = By.xpath("//li[contains(text(),'Registered')]");
    By lstitemGuests = By.xpath("//li[contains(text(),'Guests')]");
    By lstitemvendors = By.xpath("//li[contains(text(),'Vendors')]");
    By drpmgrofVendor= By.xpath("//*[@id='VendorId']");
    By rdMaleGender= By.xpath("//input[@id='Gender_Male']");
    By rdFemaleGender= By.id("//input[@id='Gender_Female']");
    By txtFirstname = By.xpath("//*[@id='FirstName']");
    By txtLastName = By.xpath("//*[@id='LastName']");
    By txtDob = By.xpath("//*[@id='DateOfBirth']");
    By txtCompanyName = By.xpath("//*[@id='Company']");
    By txtAdminContent = By.xpath("//*[@id='AdminComment']");
    By btnSave = By.xpath("//*[@name='save']");
    By custinfo = By.xpath("//div[@class='card-header with-border clearfix']");

    // Action Methods

    public void clickCustomInfo()
    {
        ldriver.findElement(custinfo).click();
    }
    public String getPageTitle(){
        return ldriver.getTitle();
    }
    public void clickOnCustomersMenu()
    {
        ldriver.findElement(lnkCustomers_menu).click();
    }
    public void clickOnCustomersMenuItem()
    {
        ldriver.findElement(lnkCustomers_menuitem).click();
    }
    public void clickOnAddnew()
    {
        ldriver.findElement(btnAddnew).click();
    }
    public void setEmail(String email)
    {
        ldriver.findElement(txtEmail).sendKeys(email);
    }
    public void setPassword(String password)
    {
        ldriver.findElement(txtPassword).sendKeys(password);
    }
    public void setCustomerRoles(String role) throws InterruptedException
    {
        if (!role.equals("vendors")) // if role is vendors should not delete Register
        {
            ldriver.findElement(By.xpath("//*[@id= 'SelectedCustomerRoleIds_taglist']/li/span"));
        }

        ldriver.findElement(txtCustomerRoles).click();

        WebElement listitem;

        Thread.sleep(3000);

        if (role.equals("Adminstrators"))
        {
            listitem=ldriver.findElement(lstitemAdministrators);
        }
        else if (role.equals("Guests"))
        {
            listitem=ldriver.findElement(lstitemGuests);
        }
        else if (role.equals("Registered"))
        {
            listitem=ldriver.findElement(lstitemRegistered);
        }
        else if (role.equals("Vendors"))
        {
            listitem=ldriver.findElement(lstitemvendors);
        }
        else
        {
            listitem=ldriver.findElement(lstitemGuests);
        }

        listitem.click();
        //Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) ldriver;
        js.executeScript("arguments[0].click();", listitem);

    }

    public void setManagerOfVendor(String value)
    {
        Select drp = new Select(ldriver.findElement(drpmgrofVendor));
        drp.selectByVisibleText(value);
    }

    public void setGender(String gender)
    {
        if(gender.equals("Male"))
        {
            ldriver.findElement(rdMaleGender).click();
        } else if (gender.equals("Female"))
        {
            ldriver.findElement(rdFemaleGender).click();
        }
        else
        {
            ldriver.findElement(rdMaleGender).click();//default
        }
    }

    public void setFirstName(String fname)
    {
        ldriver.findElement(txtFirstname).sendKeys(fname);
    }

    public void setLastName(String lname)
    {
        ldriver.findElement(txtLastName).sendKeys(lname);
    }
    public void setDob(String dob)
    {
        ldriver.findElement(txtDob).sendKeys(dob);
    }
    public void setCompanyName(String comname)
    {
        ldriver.findElement(txtCompanyName).sendKeys(comname);
    }
    public void setAdminContent(String content)
    {
        ldriver.findElement(txtAdminContent).sendKeys(content);
    }

    public void clickOnSave()
    {
        ldriver.findElement(btnSave).click();
    }
}
