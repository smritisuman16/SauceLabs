package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BasePage {
    public static WebDriver driver;

    @Before
    public static void before(Scenario scenario) {
        System.setProperty("webdriver.chrome.driver", "C:\\SAF\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @After
    public static void After(){

        driver.quit();
    }



}
