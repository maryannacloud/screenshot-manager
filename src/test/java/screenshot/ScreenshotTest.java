package screenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotTest {

    public static void main(String[] args) {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Initialize ScreenshotManager
        ScreenshotManager screenshotManager = new ScreenshotManager(driver, "screenshots");

        try {
            // Open a website
            driver.get("https://example.com");

            // Take a screenshot
            String screenshotPath = screenshotManager.takeScreenshot("ExampleTest");

            // Annotate the screenshot (optional)
            screenshotManager.annotateScreenshot(screenshotPath, "Test Passed!");
        } finally {
            // Quit the driver
            driver.quit();
        }
    }

}
