package rtc;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.FirstPage;
import utils.BrowserGetter;

import java.io.File;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTest {
    WebDriver driver;
    BrowserGetter browserGetter = new BrowserGetter();
    FirstPage page;

    @BeforeAll
    void beforeAll() {
        driver = browserGetter.getDriver();
        page = PageFactory.initElements(driver, FirstPage.class);
    }

    @AfterAll
    void afterAll() {
        driver.quit();
    }

    @Test
    void firstTest() throws InterruptedException {
//        driver.get("https://www.google.com");
        driver.get("file:///absolute path here");
        Thread.sleep(10000);
        page.container.findElement(By.tagName("img"));
        //#idModule img
    }

    @Test
    void secondTest() throws InterruptedException {
        driver.get(new File("src/test/resources/htmls/interactions.html").getAbsolutePath());
        Thread.sleep(5000);
        page.checkbox.click();
        page.radio.click();
        page.buttonToClick.click();
        Thread.sleep(5000);
        page.linkToClick.click();
        Thread.sleep(5000);
    }
}
