package Screens;

import StepDefinitions.BasePage;

import static StepDefinitions.BasePage.driver;

public class ProductScreens  {
    public void userAddsProductsToMyCart(){
        System.out.println(driver.getCurrentUrl());
    }
}
