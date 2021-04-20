package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceDemoLoginPage;
import utilities.Configuration;
import utilities.TestBase;

import java.util.List;

public class TestCase5 extends TestBase {
    double priceForTwoItems;
    double actualResultTotal;
    @Test
    public void testCase5() {
        driver.get (Configuration.getProperty ("SaucedemoURL"));
        SauceDemoLoginPage saucedemoLoginPage = new SauceDemoLoginPage ();
        saucedemoLoginPage.username.sendKeys (Configuration.getProperty ("SaucedemoUsername"));
        saucedemoLoginPage.password.sendKeys (Configuration.getProperty ("SaucedemoPassword"));
        saucedemoLoginPage.loginButton.click ();
        driver.findElement (By.id ("add-to-cart-sauce-labs-backpack")).click ();
        driver.findElement (By.id ("add-to-cart-sauce-labs-bike-light")).click ();
        driver.findElement (By.xpath ("//a[@class='shopping_cart_link']")).click ();
        driver.findElement (By.id ("checkout")).click ();
        driver.findElement (By.id ("first-name")).sendKeys (Configuration.getProperty ("firstName"));
        driver.findElement (By.id ("last-name")).sendKeys (Configuration.getProperty ("lastName"));
        driver.findElement (By.id ("postal-code")).sendKeys (Configuration.getProperty ("postalCode"));
        driver.findElement (By.id ("continue")).click ();
        List<WebElement> prices =driver.findElements (By.xpath ("//div[@class='inventory_item_price']"));
        for(int i=0;i<prices.size();i++){
            double price1=Double.parseDouble(prices.get(0).getText().substring(1));
            double price2=Double.parseDouble(prices.get(1).getText().substring(1));
            priceForTwoItems=price1+price2;
        }
        String taxString =driver.findElement (By.xpath ("//div[@class='summary_tax_label']")).getText ();
        double tax =Double.parseDouble (taxString.substring (taxString.indexOf ("$")+1));

        actualResultTotal=priceForTwoItems+tax;
        double expectedResultTotal = 43.18;
        Assert.assertEquals (actualResultTotal,expectedResultTotal);






    }
}