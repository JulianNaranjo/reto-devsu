package org.devsu.julian_naranjo.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Overview extends BasePage{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));

    @FindBy(id = "finish")
    private WebElement finishButton;

    public Overview(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    private void clickFinishButton(){
        wait.until(ExpectedConditions.elementToBeClickable(finishButton));
        finishButton.click();
    }

    public CompleteCheckout finishedOrder(){
        clickFinishButton();
        return new CompleteCheckout(driver);
    }

}
