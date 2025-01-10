package screenshotmanager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotManager {

    private static final Logger logger = LoggerFactory.getLogger(ScreenshotManager.class);
    private final WebDriver driver;
    private final String screenshotDir;

    public ScreenshotManager(WebDriver driver, String screenshotDir) {
        this.driver = driver;
        this.screenshotDir = screenshotDir;
    }

    /**
     * Takes a screenshot of the current browser state.
     *
     * @param testName the name of the test case
     * @return the screenshot file path
     */
    public String takeScreenshot(String testName) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String screenshotName = testName + "_" + timestamp + ".png";
        String screenshotPath = screenshotDir + File.separator + screenshotName;

        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File targetFile = new File(screenshotPath);
            org.apache.commons.io.FileUtils.copyFile(screenshot, targetFile);
            logger.info("Screenshot saved: " + targetFile.getAbsolutePath());
            return targetFile.getAbsolutePath();
        } catch (IOException e) {
            logger.error("Failed to take screenshot for test: " + testName, e);
            return null;
        }
    }

    /**
     * Annotates the screenshot with test details (optional).
     *
     * @param filePath the path of the screenshot file
     * @param annotation the annotation text to add
     */
    public void annotateScreenshot(String filePath, String annotation) {
        try {
            BufferedImage image = ImageIO.read(new File(filePath));
            Graphics2D graphics = image.createGraphics();
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Arial", Font.BOLD, 20));
            graphics.drawString(annotation, 10, 25); // Example: Top-left corner
            graphics.dispose();
            ImageIO.write(image, "png", new File(filePath));
            logger.info("Annotated screenshot saved: " + filePath);
        } catch (IOException e) {
            logger.error("Failed to annotate screenshot: " + filePath, e);
        }
    }
}
