package StepDefinitions;

import Locators.ProductPageLocators;
import Screens.ProductScreens;
import Screens.ScreenshotUtil;
import io.cucumber.java.en.*;

import static StepDefinitions.BasePage.driver;

public class ProductPageFunctionalities {
    ScreenshotUtil screenshotUtil;
    ProductScreens productScreens;
    public ProductPageFunctionalities(ScreenshotUtil screenshotUtil) {
        this.screenshotUtil = screenshotUtil;
        this.productScreens = new ProductScreens(screenshotUtil);  // Pass to ProductScreens
    }



    @Then("User adds {string} products to my cart")
    public void user_adds_products_to_my_cart(String string) {
        // Write code here that turns the phrase above into concrete actions
        productScreens.userAddsProductsToMyCart(string);



    }
    @And("User Clicks on Cart Page")
    public void user_clicks_on_cart_page() {
        // Write code here that turns the phrase above into concrete actions
    	productScreens.userClicksOnCartPage();
    	
    }
    @And("User Click on {string}")
    public void user_click_on(String button) {
        productScreens.userClickOnButton(button);
        // Write code here that turns the phrase above into concrete actions
        
    }
    @And("User provides {string},{string} and {string}")
    public void user_provides_and(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
        productScreens.userEntersDetails(string, string2, string3);
    }
    @And("User Verifies the Products")
    public void user_verifies_the_products() {
        // Write code here that turns the phrase above into concrete actions
        productScreens.userVerifiesTheProducts();
    }
    @And("Verify that Order has been placed Successfully")
    public void verify_that_order_has_been_placed_successfully() {
        // Write code here that turns the phrase above into concrete actions
        productScreens.userVerifiesOrderConfirmation();
    }
    @Then("Sort the products as {string}")
    public void sort_the_products_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        
    }

}
