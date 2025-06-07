package StepDefinitions;

import SetupFiles.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class BasePage {
    public static WebDriver driver;

    @Before
    public static void before() {
        String browserName=ConfigReader.get("browser");
        if(browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\SAF\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\SAF\\drivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
    }
    @After
    public static void After(){
        driver.quit();
    }



}
