package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class MarketPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'G4KLqAT1vi')]/input")
    public WebElement searchField;

    @FindBy(xpath = "//div[contains(@class,'_381y5orjSo _21NjfY1k45')]")
    public WebElement marketMainMenu;


    public MarketPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(searchField));
    }

    public void selectMarketMainMenu(String menuItem){
        marketMainMenu.findElement(By.xpath(".//span[text()='"+menuItem+"']/..")).click();
    }
}
