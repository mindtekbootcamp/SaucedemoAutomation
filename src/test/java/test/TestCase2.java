package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceDemoLoginPage;
import utilities.Configuration;
import utilities.TestBase;

import java.util.List;

public class TestCase2 extends TestBase {

    int actualResult;
    @Test
    public void validateItems(){
        driver.get(Configuration.getProperty("SaucedemoURL"));

        SauceDemoLoginPage saucedemoLoginPage = new SauceDemoLoginPage();
        saucedemoLoginPage.username.sendKeys(Configuration.getProperty("SaucedemoUsername"));
        saucedemoLoginPage.password.sendKeys(Configuration.getProperty("SaucedemoPassword"));
        saucedemoLoginPage.loginButton.click();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();


        List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        for(int i=0; i< items.size(); i++){
            System.out.println(items.get(i).getText());
            actualResult++;
        }
        int expectedResult = 2;

        Assert.assertEquals(actualResult,expectedResult);


    }
}
