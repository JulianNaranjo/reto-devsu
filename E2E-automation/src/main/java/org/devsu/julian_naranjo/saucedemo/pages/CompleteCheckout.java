package org.devsu.julian_naranjo.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompleteCheckout extends BasePage{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));

    @FindBy(className = "complete-header")
    private WebElement completeOrder;

    public CompleteCheckout(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private String getCompleteOrder(){
        wait.until(ExpectedConditions.visibilityOf(completeOrder));
        return completeOrder.getText();
    }

    public String completeOrder(){
        return getCompleteOrder();
    }


}
