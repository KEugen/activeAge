package framework.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Setup {

    public static WebDriver driver;

    public static String getUrl() {
        return "http://activeage1.qa.lan";
    }

    public static String getAdminUrl() {
        return "http://admin.activeage1.qa.lan/journal/article";
    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        else {
            throw new IllegalStateException("Driver has not been initialized. ");
        }
    }

    @BeforeClass
    public static void setupBeforeClass () throws IOException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void teardownAfterClass() throws IOException {
       // driver.quit();
    }

}
