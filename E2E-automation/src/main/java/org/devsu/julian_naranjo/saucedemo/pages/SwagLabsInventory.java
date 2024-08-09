package org.devsu.julian_naranjo.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwagLabsInventory extends BasePage{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addToCartJacket;

    @FindBy(className = "shopping_cart_link")
    private WebElement cart;

    public SwagLabsInventory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private void addBackpackItemTocart(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBackpack));
        addToCartBackpack.click();
    }

    private void addJacketItemTocart(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartJacket));
        addToCartJacket.click();
    }

    private void selectedCart(){
        wait.until(ExpectedConditions.elementToBeClickable(cart));
        cart.click();
    }

    public SwagLabsCart goCart(){
        addBackpackItemTocart();
        logger.info("Backpack added to cart successfully");
        addJacketItemTocart();
        logger.info("Jacket added to cart successfully");
        selectedCart();
        return new SwagLabsCart(driver);
    }
}
