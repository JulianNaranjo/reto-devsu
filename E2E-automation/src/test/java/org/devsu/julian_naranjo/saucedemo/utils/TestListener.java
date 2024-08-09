package org.devsu.julian_naranjo.saucedemo.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.devsu.julian_naranjo.saucedemo.driver.SelectedDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    protected static final Logger logger = LogManager.getRootLogger();

    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot) SelectedDriver.getDriver())
                .getScreenshotAs(OutputType.FILE);
        String path =System.getProperty("user.dir")+"\\target\\screenshots\\"
                + getCurrentTimeAsString()
                + ".png";
        logger.info("Path: "+ path);
        try {
            FileUtils.copyFile(screenCapture, new File(path));
        }catch (IOException e){
            logger.info("Failed to save screenshot:" + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }

    public  void onTestSuccess(ITestResult iTestResult){
        saveScreenshot();
    }
    public void onTestFailure(ITestResult iTestResult){
        saveScreenshot();
    }

}