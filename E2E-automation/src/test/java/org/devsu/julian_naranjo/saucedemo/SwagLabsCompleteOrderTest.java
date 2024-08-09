package org.devsu.julian_naranjo.saucedemo;

import org.devsu.julian_naranjo.saucedemo.model.Customer;
import org.devsu.julian_naranjo.saucedemo.model.User;
import org.devsu.julian_naranjo.saucedemo.pages.SwagLabsLogin;
import org.devsu.julian_naranjo.saucedemo.service.CustomerCreator;
import org.devsu.julian_naranjo.saucedemo.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SwagLabsCompleteOrderTest extends BaseTest {
    private  final String completeOrder = "Thank you for your order!";

    @Test
    public void completeOrder(){
        User testUser = UserCreator.credentials();
        Customer testCustomer = CustomerCreator.personalInformationCustomer();
        String completeOrderAssert = new SwagLabsLogin(getDriver())
                .openPage()
                .login(testUser)
                .goCart()
                .confirmOrder()
                .setPersonalInformation(testCustomer)
                .finishedOrder()
                .completeOrder();

        assertEquals(completeOrderAssert, completeOrder );
    }
}
