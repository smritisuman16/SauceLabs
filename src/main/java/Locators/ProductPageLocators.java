package Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageLocators {
    @FindBy(xpath="//button[text()='ADD TO CART']")
    public WebElement AddToCart;

}
