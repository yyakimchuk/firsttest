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

public class SelectedCategoryPage extends BasePage {

    @FindBy(xpath = "//span[text()='Все фильтры']/..")
    public WebElement allFiltersBtn;

    @FindBy(xpath = "//div[@class='_2Qo3ODl0by cia-vs']")
    public WebElement searchResult;

    @FindBy(xpath = "//input[@id='header-search']")
    public WebElement searchField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchBtn;


    public SelectedCategoryPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(searchBtn));
    }

    public void tVSetPageClick(){
        allFiltersBtn.click();
    }

    public void selectNameElementSearch(String name, String number){
        new BaseSteps().STASH.put(name, searchResult.findElement(By.xpath(".//article[@class='_1_IxNTwqll cia-vs cia-cs']["+number+"]//div[@class='_1OAvzJPfIW']//h3/a")).getAttribute("title"));
    }

    public void setNameElementInSearchField(String name){
        fillField(searchField, (String) new BaseSteps().STASH.get(name));
    }

    public void searchFieldClick(){
        searchField.click();
    }

    public void searchBtnClick(){
        searchBtn.click();
    }

    public void waitSearchResult(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(searchResult));
    }

}
