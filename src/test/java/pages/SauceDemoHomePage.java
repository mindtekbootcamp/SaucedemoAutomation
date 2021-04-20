package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.Driver;

import java.util.List;

public class SauceDemoHomePage {

    public SauceDemoHomePage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//select[@class='product_sort_container']")
    public WebElement filterDropdown;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> prices;


}

