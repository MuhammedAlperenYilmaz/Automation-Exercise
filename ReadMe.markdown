# Automation Exercise Test Cases

This README file contains the test cases and project structure for the project named "Automation Exercise".

## Project Description

This project performs automation testing of a web application using Selenium WebDriver.

## Project Structure

The project consists of the following components:

### 1. automationExercise.java

This file contains Java code that performs a series of automation operations using the Selenium WebDriver and Actions class.

### 2. Libraries Used

- io.github.bonigarcia.wdm
- org.openqa.selenium
- java.time.Duration

## Test Scenarios

The following test scenarios are performed in this project:

### 1. Login Test

- Scenario:** User logs in.
- Steps:**
  1. The page opens.
  2. Enter the e-mail address.
  3. Tab key is pressed
  4. Enter password information.
  5. Login button is pressed.

### 2. Test to prevent clicks on adverts

- Scenario:** User displays a specific advertisement.
- Steps:**
  1. Open the page.
  2. Scroll down until the link to be clicked is at the top of the page.

### 3. Product Purchase Test

- Scenario:** The user adds a specific product to the basket and buys it.
- Steps:**
  1. Page opens.
  2. Enter the quantity for the selected product.
  2. the selected product is added to the basket.
  3. Payment is made.

### 4. Entering Payment Information

- Scenario:** User enters payment information and makes payment.
- Steps:**
  1. The page opens.
  2. Enter payment information. (Switch between forms by pressing the Tab Key)
  3. Payment is made.

## How to Run?

Follow the steps below by installing WebDriver and necessary libraries together with the project codes:

1. Install the browser driver using WebDriverManager.
2. Start WebDriver and open the page.
3. Run the defined test cases.

## Important Notes

- For some test scenarios to be successful, the page structure may need to remain unchanged.
- An internet connection may be required for the tests to run properly.


