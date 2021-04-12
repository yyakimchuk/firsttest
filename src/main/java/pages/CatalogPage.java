package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage {

    @FindBy(xpath = "//*[contains(text(),'Страхование для путешественников')]/parent::a")
    public WebElement travelInsuranceLink;

    public CatalogPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver,5,1000);
        wait.until(ExpectedConditions.visibilityOf(travelInsuranceLink));
    }

}
