package steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BaseSteps {

    protected static WebDriver driver;
    protected static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getDriver() {
        return driver;
    }
    public static String ProdName;
    public static final Map<Object, Object> STASH = new HashMap();

    @Before
    public static void setUp() throws Exception {

        switch (properties.getProperty("browser")) {
            case "firefox":
                System.setProperty("webdriver.geco.driver", properties.getProperty("webdriver.geco.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }

        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @After
    public static void tearDown() throws Exception {
        driver.quit();
    }

    public void fillFiled(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public void moveElement(WebElement element) {
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
    }

    public void waitElementToBeClickable(WebElement element) {
        WebDriverWait waitDriver = new WebDriverWait(driver, 1000);
        waitDriver.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElementToBeVisible(WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElement(Integer sec) {
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
//        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
//        driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
    }

    public void checkFillField(String value, WebElement element) {
        assertEquals(value, element.getAttribute("value"));
    }

    public void checkFieldText(String value, WebElement element) {
        Assert.assertEquals(value, element.getText());
    }

    public void checkFieldErrorMessage(String field, String errorMessage) {
        String xpath = "//span[contains(text(),'" + field + "')]/..//input[contains(@class,'form-control ng-untouched ng-pristine ng-invalid')]/../validation-message/span";
        String actualValue = driver.findElement(By.xpath(xpath)).getText();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }

    public void checkValues (String val1, String val2){
        org.junit.Assert.assertEquals("Значение [%s] не равно [%s]", new BaseSteps().STASH.get(val1), new BaseSteps().STASH.get(val2));
    }

}

