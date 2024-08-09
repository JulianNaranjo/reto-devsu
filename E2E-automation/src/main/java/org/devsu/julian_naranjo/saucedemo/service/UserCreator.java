package org.devsu.julian_naranjo.saucedemo.service;

import org.devsu.julian_naranjo.saucedemo.model.User;

public class UserCreator {
    private static final String TESDATA_USER_NAME = "testdata.user.name";
    private static final String TESDATA_USER_PASSWORD = "testdata.user.password";

    public static User credentials(){
        return new User(TestDataReader.getTestData(TESDATA_USER_NAME),TestDataReader.getTestData(TESDATA_USER_PASSWORD));
    }

}
