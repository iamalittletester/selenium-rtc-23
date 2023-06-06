package rtc;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.FirstPage;
import utils.BrowserGetter;

import java.io.File;
import java.util.Set;

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
        page.checkbox.click();
        page.radio.click();
        page.buttonToClick.click();

        page.inputToTypeInto.sendKeys("sjnfvjmhfdkh");
        page.textAreaToTypeInto.sendKeys("jmhfdsjhsdfkj");
//        page.inputToTypeInto.sendKeys(Keys.TAB);

        page.inputToTypeInto.clear();
        page.textAreaToTypeInto.clear();
//        page.linkToClick.click();

        Select coffeeDropdown = new Select(page.coffeeSelectElement);
        coffeeDropdown.selectByVisibleText("Latte Machiato");
        Select teaDropdown = new Select(page.teaSelectElement);
        teaDropdown.selectByIndex(2);
        Select refreshmentDropdown = new Select(page.refreshmentSelectElement);
        refreshmentDropdown.selectByValue("1");
        refreshmentDropdown.selectByValue("4");
        refreshmentDropdown.deselectAll();

        for (WebElement element : coffeeDropdown.getOptions()) {
            System.out.println(element.getText());
        }

        System.out.println(page.h5Element.getText());
        System.out.println(page.getAttributeElement.getAttribute("src"));
        System.out.println(page.uncheckedCheckbox.getAttribute("checked"));
        Thread.sleep(5000);

    }

    @Test
    void testForIframes() {
        driver.get(new File("src/test/resources/htmls/withIframes.html").getAbsolutePath());

        //
        driver.switchTo().frame("frameWithId");
        System.out.println(page.btnForFrameWithId.getText());
        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);
        System.out.println(page.btnForFrameWithIndex.getText());
        driver.switchTo().defaultContent();

        driver.switchTo().frame(page.thirdIframe);
        System.out.println(page.btnForFrameAsWebElement.getText());
        driver.switchTo().defaultContent();
    }

    @Test
    void cookies() {
        driver.get("https://www.example.com");
        driver.manage().addCookie(new Cookie("firstName", "firstValue"));

        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie);
            System.out.println("----------------------");
        }

        System.out.println(driver.manage().getCookieNamed("firstName").getValue());

//        driver.manage().deleteCookieNamed("firstName");
        driver.manage().deleteAllCookies();
        System.out.println(driver.manage().getCookies().size());
    }

    @Test
    void testForWindows() throws InterruptedException {
        driver.get(new File("src/test/resources/htmls/mainPage.html").getAbsolutePath());
        String initialWindowHandle = driver.getWindowHandle();
        System.out.println("initialWindowHandle = " + initialWindowHandle);
        page.listOfLinks.get(0).click();
        //now we have 2 tabs
        for (String allHandles : driver.getWindowHandles()) {
            driver.switchTo().window(allHandles);
            if (driver.getCurrentUrl().contains("secondPage.html")) {
                driver.close();
                driver.switchTo().window(initialWindowHandle);
            }
            ////
//        page.listOfLinks.get(1).click();
        }
        Thread.sleep(10000);
    }

    @Test
    void userPromptsTest() throws InterruptedException {
        driver.get(new File("src/test/resources/htmls/userPrompts.html").getAbsolutePath());
        page.alertButton.click();
        driver.switchTo().alert().accept();

        page.confirmButton.click();
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(3000);
        page.confirmButton.click();
        alert.dismiss();
        Thread.sleep(10000);
    }
}
