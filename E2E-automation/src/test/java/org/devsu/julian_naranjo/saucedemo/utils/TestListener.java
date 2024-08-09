package org.devsu.julian_naranjo.saucedemo.utils;

import org.apache.commons.io.FileUtils;
import org.devsu.julian_naranjo.saucedemo.driver.SelectedDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public void onTestFailure(ITestResult iTestResult){
        saveScreenshot();
    }

    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot) SelectedDriver.getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(".//target/screenshots/"
                    + getCurrentTimeAsString()
                    + ".png"));
        }catch (IOException e){
            System.out.println("Failed to save screenshot:" + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uu uu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}