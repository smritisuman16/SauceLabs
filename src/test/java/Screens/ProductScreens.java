package Screens;

import Locators.ProductPageLocators;
import StepDefinitions.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
           WebElement element = driver.findElement(By.xpath("//*[text()='"+button+"' or @*='"+button+"']"));
           ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
           commonElements.waitForSeconds(3);
           element.click();
        } catch (Exception e) {
            System.out.println("Not able to click on "+button);
        }
        screenshotUtil.takeScreenshot("Click on "+button);
    }
    
	
    public void userClicksOnCartPage() {
		// TODO Auto-generated method stub
		try{
    		locators.cartImage.click();
    		commonElements.waitForSeconds(5);
    	}
    	catch(NoSuchElementException e) {
    		System.out.println("Element not found.");
    	}
    	catch(ElementClickInterceptedException e) {
    		System.out.println("Not able to click on Element.");
    	}
    	screenshotUtil.takeScreenshot("Click on Cart Page");
	}

    public void userEntersDetails(String firstName, String lastName, String postalCode) {
    	try{
    		locators.firstName.sendKeys(firstName);
    	locators.lastName.sendKeys(lastName);
    	locators.postalCode.sendKeys(postalCode);
    	screenshotUtil.takeScreenshot("User enters the details.");
    }
    	catch(NoSuchElementException e) {
    		System.out.println("Element not found");
    	}
    }
    
    public void userVerifiesTheProducts() {
    	try {
    	System.out.println("Items added in the cart are: ");
    	for(WebElement element: locators.cartProductName) {
    	System.out.println(element.getText());
    }
    }
    	catch(NoSuchElementException e)
    	{
    		System.out.println("Element not found");
    	}
    }

    
    public void userVerifiesOrderConfirmation() {
    	try {
    	if(driver.getPageSource().contains("THANK YOU FOR YOUR ORDER")) {
    		System.out.println("Order is placed successfully.");
    	}
    	else {
    		System.out.println("Order couldn't be placed, please try again.");
    	}
    	
}
    	catch(NullPointerException e) {
    		System.out.println("Page Source is found Null.");
    	}
    }
}