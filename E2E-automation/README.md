## Getting Started

This is the solution to a technical test, which consists of authenticating on the page https://www.saucedemo.com/, adding two products to the cart and then finalizing the purchase order.

## Stack

- Selenium
- TestNG
- log4j2

## Folder Structure

The workspace contains the following folder structure, where:

- `Driver`: Contains a script called SelectedDriver that is responsible for managing the driver for Chrome or Firefox depending on the system variable passed as a parameter.
- `Model`: Contains a script called User that is responsible for setting and getting the user and password.
- `Pages`: Contains the different pages that are part of the automation and that are used to carry it out.
- `Service`: It contains two scripts, one is the TestDataReader which allows me to read the qa.properties file that contains the username and password to use and another script called UserCreator that allows me to obtain the user credentials.
- `Test`: Contains the SwagLabsCompleteOrderTest script which is responsible for running the test
- `utils`: Here is a script that allows me to get a screenshot of where the test fails

## Requirements

Install:
- Java
- Maven

## Run command

mvn -Dbrowser=chrome -Denvironment=qa clean test

Where:
- `-Dbrowser`: It is the system variable that indicates the driver to use, it can be Chrome or Firefox.
- `-Denvironment`: It is the system variable that indicates the .properties file to use, in order to be able to run tests depending on the environment in which I am and I can parameterize the user and password, in this case only one qa.properties file has been defined

## Consideration

- The log4j2 library was implemented to perform very basic flow traceability.
- The ITestListener interface was implemented, which also allows me to capture a screenshot in a very basic way when the test fails.
