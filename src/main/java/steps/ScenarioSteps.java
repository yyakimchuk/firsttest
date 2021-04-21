package steps;

import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class ScenarioSteps {

    BaseSteps baseSteps = new BaseSteps();
    MainSteps mainSteps = new MainSteps();
    MarketPageSteps marketPageSteps = new MarketPageSteps();
    ElectronicsPageSteps electronicsPageSteps = new ElectronicsPageSteps();
    SelectedCategoryPageSteps selectedCategoryPageSteps = new SelectedCategoryPageSteps();
    AllFiltersPageSteps allFiltersPageSteps = new AllFiltersPageSteps();


    @When("^выбирается пункт меню Маркет$")
    public void stepSelectMarketMenu() {
        final Set<String> oldWindowsSet = BaseSteps.getDriver().getWindowHandles();
        mainSteps.stepSelectMarketMenu();
        String newWindow = (new WebDriverWait(BaseSteps.getDriver(), 10))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );

        BaseSteps.getDriver().switchTo().window(newWindow);

    }

    @When("^выбирается пункт меню \"(.*)\"$")
    public void stepSelectMainMenu(String menuItem) {
        marketPageSteps.stepSelectMarketMainMenu(menuItem);
    }

    @When("^выбирается категория \"(.*)\"$")
    public void stepSelectMarketCategoryMenu(String menuItem) {
        electronicsPageSteps.stepSelectMarketCategoryMenu(menuItem);
    }

    @When("^нажимается кнопка - Все фильтры$")
    public void stepTVSetPageClick() {
        selectedCategoryPageSteps.stepTVSetPageClick();
    }

    @When("^поле Цена, от - заполняется значением \"(.*)\"$")
    public void stepSetPriceFromInput(String price) {
        allFiltersPageSteps.stepSetPriceFromInput(price);
    }

    @When("^выбирается производитель \"(.*)\"$")
    public void stepSelectProducer(String producer) {
        allFiltersPageSteps.stepSelectProducer(producer);
    }

    @When("^нажимается кнопка - Применить фильтры$")
    public void stepApplyFilterBtnClick() {
        allFiltersPageSteps.stepApplyFilterBtnClick();
    }

    @When("^наводится курсор на производителя$")
    public void stepMoveToProducer(){
        allFiltersPageSteps.stepMoveToProducer();
    }

    @When("^сохраняется в переменную \"(.*)\" наименование продукта под номером \"(.*)\"$")
    public void stepSelectNameElementSearch(String name, String number){
        selectedCategoryPageSteps.stepSelectNameElementSearch(name, number);
    }

    @When("^заполняется поле Поиск значением переменной \"(.*)\"$")
    public void stepSetNameElementInSearchField(String name){
        selectedCategoryPageSteps.stepSetNameElementInSearchField(name);
    }

    @When("^ожидание результата поиска$")
    public void stepWaitSearchResult(){
        selectedCategoryPageSteps.stepWaitSearchResult();
    }

    @When("^выбирается поле Поиск$")
    public void stepSearchFieldClick(){
        selectedCategoryPageSteps.stepSearchFieldClick();
    }

    @When("^нажимается кнопка Найти$")
    public void stepSearchBtnClick(){
        selectedCategoryPageSteps.stepSearchBtnClick();
    }

    @When("^ожидание (\\d+) секунд$")
    public void stepWaitElement(Integer sec){
        baseSteps.waitElement(sec);
    }

    @When("^сравнить значение переменной \"(.*)\" с \"(.*)\"$")
    public void stepcheckValues(String val1, String val2){
        baseSteps.checkValues(val1, val2);
    }

    @When("^прокрутить страницу вниз до поля поиска производителя$")
    public void stepScrollPageToProducerViewAll(){
        allFiltersPageSteps.stepScrollPageToProducerViewAll();
    }

    @When("^поле Поиск в секции Производитель заполняется значением \"(.*)\"$")
    public void stepSetInputProducer(String value){
        allFiltersPageSteps.stepSetInputProducer(value);
    }

    @When("^ожидается появление на странице Производителя \"(.*)\"$")
    public void stepWaitProducerVisible(String producer){
        allFiltersPageSteps.stepWaitProducerVisible(producer);
    }
}
