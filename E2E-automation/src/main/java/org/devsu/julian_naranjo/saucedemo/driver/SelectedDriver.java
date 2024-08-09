package org.devsu.julian_naranjo.saucedemo.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectedDriver {
    private static WebDriver driver;
    public static WebDriver getDriver(){
        if (null == driver){
            switch (System.getProperty("browser")){
                case "chrome": {
                    driver = new ChromeDriver();
                    break;
                }
                case "firefox": {
                    driver = new FirefoxDriver();
                    break;
                }
                default:{
                    driver = new ChromeDriver();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
