package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;
import util.WaitHelper;
public class SearchCustomerPage {

    public WebDriver ldriver;

    WaitHelper waitHelper;

    public SearchCustomerPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(ldriver,this);
        waitHelper = new WaitHelper(ldriver);
    }


}
