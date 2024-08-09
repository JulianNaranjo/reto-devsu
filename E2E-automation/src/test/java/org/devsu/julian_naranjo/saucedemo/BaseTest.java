package org.devsu.julian_naranjo.saucedemo;

import org.devsu.julian_naranjo.saucedemo.driver.SelectedDriver;
import org.devsu.julian_naranjo.saucedemo.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = SelectedDriver.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        SelectedDriver.closeDriver();
    }

    public WebDriver getDriver(){
        return this.driver;
    }
}
