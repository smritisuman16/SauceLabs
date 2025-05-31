package Screens;

import Locators.ProductPageLocators;
import StepDefinitions.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static StepDefinitions.BasePage.driver;

public class ProductScreens  {
    CommonElements commonElements=new CommonElements();
    ProductPageLocators locators=new ProductPageLocators();
    String productXpath="//*[contains(text(),'Product Name')]/parent::a";
    private final ScreenshotUtil screenshotUtil;
    public ProductScreens(ScreenshotUtil screenshotUtil){
        this.screenshotUtil = screenshotUtil;
        PageFactory.initElements(BasePage.driver, locators);
    }
    public void userAddsProductsToMyCart(String products){
        String[] productsList=products.split(",");
        commonElements.waitForSeconds(10);
        for(String product:productsList){
            driver.findElement(By.xpath(productXpath.replace("Product Name",product))).click();
            commonElements.waitForSeconds(5);
            locators.AddToCart.click();
            screenshotUtil.takeScreenshot("Adding "+ product+" to Cart");
            commonElements.waitForSeconds(5);
            driver.navigate().back();
        }

    }
    public void userClickOnButton(String button){
        try{
            driver.findElement(By.xpath("//button[text()='"+button+"']")).click();
        } catch (Exception e) {
            System.out.println("Not able to click on "+button);
        }
        screenshotUtil.takeScreenshot("Click on "+button);
    }

}
