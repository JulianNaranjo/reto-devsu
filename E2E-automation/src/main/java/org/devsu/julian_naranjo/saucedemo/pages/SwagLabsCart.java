package org.devsu.julian_naranjo.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwagLabsCart extends BasePage{

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));

    @FindBy(id = "checkout")
    private WebElement checkout;

    public SwagLabsCart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private void selectedCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(checkout));
        System.out.println("esto es una prueba");
        checkout.click();
    }

    public PersonalInformation confirmOrder(){
        selectedCheckout();
        return new PersonalInformation(driver);
    }

}
