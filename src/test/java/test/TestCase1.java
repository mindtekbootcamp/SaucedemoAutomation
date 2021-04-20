package test;


import org.testng.annotations.Test;
import pages.SauceDemoHomePage;
import pages.SauceDemoLoginPage;
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

            SauceDemoHomePage saucedemoHomePage = new SauceDemoHomePage();
            BrowserUtils.selectDropdownByValue(saucedemoHomePage.filterDropdown,"za");
        }

    }

