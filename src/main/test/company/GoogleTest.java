package company;

import company.random.word.RandomWordExtractor;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class GoogleTest extends BaseTest {

    @Test
    public void shouldSearchRandomWord() throws IOException {
        driver.get(config.getProperty("baseurl"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input")));

        String randomWord = RandomWordExtractor.extract(config.getProperty("random.word.site.url"), "random_word");

        WebElement webElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input"));

        webElement.sendKeys(randomWord);
        driver.findElement(By.xpath("//input[@class=\"gNO89b\"]")).click();
    }
}
