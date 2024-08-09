package org.devsu.julian_naranjo.saucedemo.service;

import org.devsu.julian_naranjo.saucedemo.model.Customer;

public class CustomerCreator {
    private static final String TESDATA_FIRST_NAME = "testdata.first.name";
    private static final String TESDATA_LAST_PASSWORD = "testdata.last.name";
    private static final String TESDATA_POSTAL_CODE = "testdata.postal.code";

    public static Customer personalInformationCustomer(){
        return new Customer(TestDataReader.getTestData(TESDATA_FIRST_NAME),
                TestDataReader.getTestData(TESDATA_LAST_PASSWORD),
                TestDataReader.getTestData(TESDATA_POSTAL_CODE));
    }
}
