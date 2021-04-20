package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceDemoLoginPage;
import pages.SaucedemoHomePage;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.TestBase;

public class TestCase4 extends TestBase {

//    @Test
//    public void loginFunctionality() {
//        driver.get (Configuration.getProperty ("SaucedemoURL"));
//        SauceDemoLoginPage saucedemoLoginPage = new SauceDemoLoginPage ();
//        saucedemoLoginPage.username.sendKeys (Configuration.getProperty ("SaucedemoUsername"));
//        saucedemoLoginPage.password.sendKeys (Configuration.getProperty ("SaucedemoPassword"));
//        saucedemoLoginPage.loginButton.click ();
//        SaucedemoHomePage saucedemoHomePage = new SaucedemoHomePage ();
//        BrowserUtils.selectDropdownByValue(saucedemoHomePage.filterDropdown,"za");
//    }
    @Test
    public void testCase4(){
        driver.get (Configuration.getProperty ("SaucedemoURL"));
        SauceDemoLoginPage saucedemoLoginPage = new SauceDemoLoginPage ();
        saucedemoLoginPage.username.sendKeys (Configuration.getProperty ("SaucedemoUsername"));
        saucedemoLoginPage.password.sendKeys (Configuration.getProperty ("SaucedemoPassword"));
        saucedemoLoginPage.loginButton.click ();
        driver.findElement (By.id ("add-to-cart-sauce-labs-backpack")).click ();
        driver.findElement (By.id ("add-to-cart-sauce-labs-bike-light")).click ();
        driver.findElement (By.xpath ("//a[@class='shopping_cart_link']")).click ();
        driver.findElement (By.id ("checkout")).click ();
        driver.findElement (By.id ("continue")).click ();
        String expectedResult =driver.findElement (By.xpath ("//div[@class='error-message-container error']")).getText ();
        System.out.println (expectedResult);
        String actualResult = "Error: First Name is required";
        Assert.assertEquals (actualResult,expectedResult);
    }

}
