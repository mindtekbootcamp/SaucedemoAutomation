package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceDemoLoginPage;
import utilities.Configuration;
import utilities.TestBase;

import java.util.List;

public class SauceDemoAppTest3 extends TestBase {
    int actualResult;
    @Test
    public void removeItemTest() {
        driver.get(Configuration.getProperty("SauceDemoURL"));
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage();
        sauceDemoLoginPage.username.sendKeys(Configuration.getProperty("SauceDemoUsername"));
        sauceDemoLoginPage.password.sendKeys(Configuration.getProperty("SauceDemoPassword"));
        sauceDemoLoginPage.loginButton.click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        for(int i=0; i< items.size(); i++){
            System.out.println(items.get(i).getText());
            actualResult++;
        }
        int expectedResult = 1;

        Assert.assertEquals(actualResult,expectedResult);

    }
}