package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class BasePage {
    WebDriver driver;

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
}
