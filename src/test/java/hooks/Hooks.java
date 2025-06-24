package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.DriverFactory;

public class Hooks {
        WebDriver driver;

        @Before
        public void setUp() {
            String browser = System.getProperty("browser", "chrome"); // default is chrome

            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }

            driver.manage().window().maximize();
            DriverFactory.setDriver(driver);
        }

        @After
        public void tearDown(Scenario scenario) {
            if (driver != null) {
                driver.quit();
            }
        }
    }


