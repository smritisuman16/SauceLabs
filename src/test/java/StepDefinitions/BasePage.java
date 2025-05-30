package StepDefinitions;

import Locators.LoginPageLocators;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BasePage {
    public static WebDriver driver;
    static PDDocument document = new PDDocument();


    @Before
    public static void before(){
        System.setProperty("webdriver.chrome.driver","C:\\SAF\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();


    }
    @After
    public static void After(){

        driver.quit();
    }
    public static String takeScreenshot(String scenarioName) throws IOException {
        String imagePath1 = takeScreenshot("LoginPage");

        // Add Screenshot to PDF
        addScreenshotToPDF(imagePath1, "Login Scenario: Page Captured");
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String imagePath = "screenshots/" + scenarioName + ".png";
        File destFile = new File(imagePath);
        destFile.getParentFile().mkdirs(); // Create directories if needed
        ImageIO.write(ImageIO.read(srcFile), "png", destFile);
        return imagePath;
    }

    // Method to Add Screenshot to PDF
    public static void addScreenshotToPDF(String imagePath, String scenarioTitle) throws IOException {

        PDPage page = new PDPage();
        document.addPage(page);

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
            contentStream.beginText();
            contentStream.setLeading(20);
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText(scenarioTitle);
            contentStream.endText();

            BufferedImage image = ImageIO.read(new File(imagePath));
            PDImageXObject pdImage = PDImageXObject.createFromFile(imagePath, document);
            contentStream.drawImage(pdImage, 100, 300, image.getWidth() / 2, image.getHeight() / 2);
        }
    }

    // Method to Save PDF File
    public static void saveAndClosePDF(String fileName) throws IOException, IOException {
        document.save(fileName);
        document.close();
        System.out.println("PDF Report Generated: " + fileName);
    }

}
