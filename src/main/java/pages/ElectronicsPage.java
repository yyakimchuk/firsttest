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

public class ElectronicsPage extends BasePage{

    @FindBy(xpath = "//div[@data-tid='cb168a42']")
    public WebElement marketCategoryMenu;

    public ElectronicsPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(marketCategoryMenu));
    }

    public void selectMarketCategoryMenu(String menuItem){
        marketCategoryMenu.findElement(By.xpath(".//a[text()='"+menuItem+"']")).click();
    }
}
