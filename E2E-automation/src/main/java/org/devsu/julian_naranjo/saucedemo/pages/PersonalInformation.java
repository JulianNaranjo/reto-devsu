package org.devsu.julian_naranjo.saucedemo.pages;

import io.qameta.allure.Step;
import org.devsu.julian_naranjo.saucedemo.model.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalInformation extends BasePage{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public PersonalInformation(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    private void setFirstName(String firstNameModel){
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(firstNameModel);
    }

    private void setLastName(String lastNameModel){
        wait.until(ExpectedConditions.visibilityOf(lastName));
        lastName.sendKeys(lastNameModel);
    }

    private void setPostalCode(String postalCodeModel){
        wait.until(ExpectedConditions.visibilityOf(lastName));
        postalCode.sendKeys(postalCodeModel);
    }

    private void clickContinueButton(){
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }

    @Step("Fill customer information")
    public Overview setPersonalInformation(Customer customer){
        setFirstName(customer.getFirstName());
        setLastName(customer.getLastName());
        setPostalCode(customer.getPostalCode());
        logger.info("Added persona information with First Name: ["+ customer.getFirstName() +
                "] and Last Name: [" + customer.getLastName() +
                "] and Postal Code: [" + customer.getPostalCode() + "]");
        clickContinueButton();
        return new Overview(driver);
    }



}
