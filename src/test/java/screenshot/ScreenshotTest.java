package screenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import screenshotmanager.ScreenshotManager;

public class ScreenshotTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        ScreenshotManager screenshotManager = new ScreenshotManager(driver, "screenshots");

        try {

            driver.get("https://example.com");
            String screenshotPath = screenshotManager.takeScreenshot("ExampleTest");
            screenshotManager.annotateScreenshot(screenshotPath, "Test Passed!");

        } finally {

            driver.quit();
        }
    }
}
