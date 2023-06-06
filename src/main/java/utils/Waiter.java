package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
    private WebDriver driver;

    public void click(WebElement elementToClick, int specificTimeout) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(specificTimeout));
        ExpectedCondition<Boolean> condition = arg -> {
                try {
                    elementToClick.click();
                    return true;
                } catch (Exception e) {
                    return false;
                }
            };
            wait.until(condition);
    }

    public void sendKeys(WebElement inputToTypeInto, String text) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(30));
        ExpectedCondition<Boolean> condition = arg -> {
            try {
                inputToTypeInto.clear();
                inputToTypeInto.sendKeys(text);
                inputToTypeInto.sendKeys(Keys.TAB);
                Thread.sleep(1000);
                return inputToTypeInto.getAttribute("value").equals(text);
            } catch (Exception e) {
                return false;
            }
        };
        wait.until(condition);
    }

    public void example(WebElement elementToClick, int specificTimeout) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(specificTimeout));
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
