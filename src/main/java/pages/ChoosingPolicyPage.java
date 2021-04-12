package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChoosingPolicyPage {

    @FindBy(xpath = "//h2[contains(text(),'Страхование путешественников')]")
    WebElement titlePolicy;

    @FindBy(xpath = "//h3[contains(text(),'Минимальная')]")
    public WebElement protectionSumMin;

    @FindBy(xpath = "//button[text()='Оформить']")
    public WebElement orderBtn;

    public ChoosingPolicyPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver,5,1000);
        wait.until(ExpectedConditions.visibilityOf(titlePolicy));
    }

}
