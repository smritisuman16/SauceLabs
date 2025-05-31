package Screens;

import Locators.ProductPageLocators;
import StepDefinitions.BasePage;
import org.openqa.selenium.By;

import static StepDefinitions.BasePage.driver;

public class ProductScreens  {
    CommonElements commonElements=new CommonElements();
    ProductPageLocators locators=new ProductPageLocators();
    String productXpath="//*[contains(text(),'Product Name')]";
    public void userAddsProductsToMyCart(String products){
        String[] productsList=products.split(",");
        for(String product:productsList){
            driver.findElement(By.xpath(productXpath.replace("Product Name",product))).click();
            commonElements.waitForSeconds(5);
            locators.AddToCart.click();
            commonElements.waitForSeconds(5);
            driver.navigate().back();
        }


    }
}
