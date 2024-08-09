package org.devsu.julian_naranjo.saucedemo.pages;

import io.qameta.allure.Step;
import org.devsu.julian_naranjo.saucedemo.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwagLabsLogin extends BasePage{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    private final String BASE_URL = "https://www.saucedemo.com/";

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public SwagLabsLogin(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Open Swag Labs page ")
    public SwagLabsLogin openPage(){
        driver.get(BASE_URL);
        return this;
    }

    private void setUserName(String userNameModel){
        wait.until(ExpectedConditions.visibilityOf(userName));
        userName.sendKeys(userNameModel);
    }

    private void setPassword(String passwordModel){
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(passwordModel);
    }

    private void clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    @Step("Login process")
    public SwagLabsInventory login(User user){
        setUserName(user.getUserName());
        setPassword(user.getPassword());
        clickLoginButton();
        logger.info("Login successful with username: ["+ user.getUserName() +
                "] and password: [" + user.getPassword() + "]");
        return new SwagLabsInventory(driver);
    }
}
