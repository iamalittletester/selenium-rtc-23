package rtc;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import utils.BrowserGetter;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTest {
    WebDriver driver;
    BrowserGetter browserGetter = new BrowserGetter();

    @BeforeAll
    void beforeAll() {
        driver = browserGetter.getDriver();
    }

    @AfterAll
    void afterAll() {
        driver.quit();
    }

    @Test
    void firstTest() throws InterruptedException {
        driver.get("https://www.google.com");
        Thread.sleep(10000);
    }
}
