package Screens;


import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static StepDefinitions.BasePage.document;
import static StepDefinitions.BasePage.driver;

public class ScreenshotUtil {


    public static void takeScreenshot(String scenarioName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String imagePath = "screenshots/" + scenarioName + ".png";
            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(srcFile.toPath(), Paths.get(imagePath));

            // Add Screenshot to PDF
            ImageData imageData = ImageDataFactory.create(imagePath);
            Image img = new Image(imageData);
            img.setAutoScale(true); // Fit the image in PDF

            document.add(new Paragraph(scenarioName).setBold());
            document.add(img);

            System.out.println("Screenshot captured & added to PDF: " + scenarioName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}