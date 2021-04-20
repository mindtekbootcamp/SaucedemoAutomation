package test;


import org.testng.annotations.Test;
import pages.SaucedemoHomePage;
import pages.SauceDemoLoginPage;
import pages.SaucedemoHomePage;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.TestBase;

public class TestCase1 extends TestBase {

        @Test
        public void loginFunctionality(){

            driver.get(Configuration.getProperty("SaucedemoURL"));

            SauceDemoLoginPage saucedemoLoginPage = new SauceDemoLoginPage();
            saucedemoLoginPage.username.sendKeys(Configuration.getProperty("SaucedemoUsername"));
            saucedemoLoginPage.password.sendKeys(Configuration.getProperty("SaucedemoPassword"));
            saucedemoLoginPage.loginButton.click();

            SaucedemoHomePage saucedemoHomePage = new SaucedemoHomePage();
            BrowserUtils.selectDropdownByValue(saucedemoHomePage.filterDropdown,"za");
        }

    }

