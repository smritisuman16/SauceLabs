package StepDefinitions;

import com.itextpdf.kernel.pdf.PdfWriter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;

import java.io.IOException;


public class BasePage {
    public static WebDriver driver;
    protected static PdfDocument pdf;
    public static Document document;
    protected static String pdfPath = null;


    @Before
    public static void before(Scenario scenario) {
        System.setProperty("webdriver.chrome.driver", "C:\\SAF\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pdfPath="test-output\\"+scenario.getName()+".pdf";
        if (pdf == null) {
            try {
                PdfWriter writer = new PdfWriter(pdfPath);
                pdf = new PdfDocument(writer);
                document = new Document(pdf);
                System.out.println("PDF Report Initialized.");
            } catch (IOException e) {
                System.out.println("Error in Initializing pdf");
            }

        }
    }
    @After
    public static void After(){
        try {
            if (document != null) {
                document.close();
                pdf.close();
                System.out.println("PDF Report Saved: " + pdfPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }


}
