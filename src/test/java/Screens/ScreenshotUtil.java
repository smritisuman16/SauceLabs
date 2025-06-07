package Screens;


import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import static StepDefinitions.BasePage.*;

public class ScreenshotUtil {
    protected  PdfDocument pdf;
    public  Document document;
    protected  String pdfPath = null;
    public  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
    public ScreenshotUtil() {}


    public void initializePDF(Scenario scenario){
        pdfPath = "test-output/" + scenario.getName().replaceAll("\\s+", "_") + "_" + formatter.format(new Date()) + ".pdf";
        try {
            PdfWriter writer = new PdfWriter(pdfPath);
            pdf = new PdfDocument(writer);
            document = new Document(pdf);
            document.add(new Paragraph(scenario.getName())
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER)
                    .setUnderline().
                    setStrokeColor(ColorConstants.BLUE)
                    .setBackgroundColor(ColorConstants.YELLOW));
            System.out.println("PDF Report Initialized: " + pdfPath);
        } catch (IOException e) {
            System.out.println("Error in Initializing PDF");
            e.printStackTrace();
        }

    }

    public void closePDF(Scenario scenario){
        try {
            if(!scenario.isFailed())
                document.add(new Paragraph("Scenario is passed with no errors").setBold().setBackgroundColor(ColorConstants.GREEN));
            else
                document.add(new Paragraph("Scenario is failed with errors").setBold().setBackgroundColor(ColorConstants.RED));
            if (document != null) {
                document.close();
                pdf.close();
                System.out.println("PDF Report Saved: " + pdfPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 📌 New: Clear out instance variables after each scenario
            document = null;
            pdf = null;
        }

    }


    public void takeScreenshot(String scenarioName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String imagePath = "screenshots/" + scenarioName.replaceAll("\\s+", "_") + "_" + formatter.format(new Date()) + ".png";
            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(srcFile.toPath(), Paths.get(imagePath));

            // Add Screenshot to PDF
            ImageData imageData = ImageDataFactory.create(imagePath);
            Image img = new Image(imageData);
            img.setAutoScale(true); // Fit the image in PDF
            if (document == null) {
                System.out.println("Document is not initialized. Screenshot will not be added to PDF.");
                return;
            }
            document.add(new Paragraph(scenarioName));
            document.add(img);

            System.out.println("Screenshot captured & added to PDF: " + scenarioName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addDataInPDF(String data) {
        try {

            if (document == null) {
                System.out.println("Document is not initialized. Screenshot will not be added to PDF.");
                return;
            }
            document.add(new Paragraph(data));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}