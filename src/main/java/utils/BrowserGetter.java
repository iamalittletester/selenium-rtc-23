package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserGetter {

    public WebDriver getChrome() {
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
