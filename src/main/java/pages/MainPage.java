package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage extends BasePage{

    @FindBy(xpath = "//ul[contains(@class, 'services-new__list')]/li/a/div[contains(text(),'Маркет')]/..")
    public WebElement mainMenu;

    public MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMarketMenu (){
        mainMenu.click();
    }
}
