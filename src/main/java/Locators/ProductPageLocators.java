package Locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageLocators {
    @FindBy(xpath="//button[text()='ADD TO CART']")
    public WebElement AddToCart;
    @FindBy (xpath="//a[@class='shopping_cart_link fa-layers fa-fw']")
    public WebElement cartImage;
    @FindBy (xpath="'//a[@class='btn_action checkout_button']'")
    public WebElement checkOutButton;
    @FindBy (xpath="//input[@id='first-name']")
    public WebElement firstName;
    @FindBy (xpath="//input[@id='last-name']")
    public WebElement lastName;
    @FindBy (xpath="//input[@id='postal-code']")
    public WebElement postalCode;
    @FindBy (xpath="//div[@class='inventory_item_name']")
    public List<WebElement> cartProductName;
    @FindBy (xpath="//h2[text()='THANK YOU FOR YOUR ORDER']")
    public WebElement verifyOrder;
    @FindBy (xpath="//select[@class = 'product_sort_container']")
    public WebElement sortProducts;
}
