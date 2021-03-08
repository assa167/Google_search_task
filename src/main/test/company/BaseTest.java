package company;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static company.util.PropertiesLoader.loadProperties;

public class BaseTest {

    public WebDriver driver;
    protected final Properties config = loadProperties("src/main/test/resources/test.properties");

    @Before
    public void setup() {
        WebDriverManager.chromedriver().browserVersion("88.0.4324.190").setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void cleanup() throws InterruptedException {
        Thread.sleep(5000L);
        driver.close();
    }



}
