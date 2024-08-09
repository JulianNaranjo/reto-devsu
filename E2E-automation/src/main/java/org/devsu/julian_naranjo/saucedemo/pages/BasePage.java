package org.devsu.julian_naranjo.saucedemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 15;
    protected static final Logger logger = LogManager.getRootLogger();

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
