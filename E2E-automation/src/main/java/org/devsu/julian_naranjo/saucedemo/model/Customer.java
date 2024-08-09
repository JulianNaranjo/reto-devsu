package org.devsu.julian_naranjo.saucedemo.model;

public class Customer {

    private String firstName;
    private String lastName;
    private String zipCode;

    public Customer(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = postalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPostalCode() {
        return zipCode;
    }

    public void setPostalCode(String postalCode) {
        this.zipCode = zipCode;
    }
}
