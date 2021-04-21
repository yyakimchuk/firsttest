package steps;

import org.openqa.selenium.JavascriptExecutor;
import pages.AllFiltersPage;
import ru.yandex.qatools.allure.annotations.Step;

public class AllFiltersPageSteps {

    @Step("Заполняется поле Цена, от - значением {0}")
    public void stepSetPriceFromInput(String price){
        new AllFiltersPage().setPriceFromInput(price);
    }

    @Step("Выбирается производитель {0}")
    public void stepSelectProducer(String producer){
        new AllFiltersPage().selectProducer(producer);
    }

    @Step("Нажимается кнопка Применить фильтры")
    public void stepApplyFilterBtnClick(){
        new AllFiltersPage().applyFilterBtnClick();
    }

    @Step("Наводим курсор на производителя")
    public void stepMoveToProducer(){
        new BaseSteps().moveElement(new AllFiltersPage().producerChkBox);
    }

    @Step("Прокрутить страницу вниз до поля поиска производителя")
    public void stepScrollPageToProducerViewAll(){
        JavascriptExecutor je = (JavascriptExecutor) BaseSteps.getDriver();
        je.executeScript("arguments[0].scrollIntoView(true);", new AllFiltersPage().inputProducer);
    }

    @Step("Ввести значение {0} в поле Поиск в серкии Производитель")
    public void stepSetInputProducer(String value){
        new AllFiltersPage().setInputProducer(value);
    }

    @Step("Выбирается поле Поиск в секции Производитель")
    public void stepinputProducerClick(){
        new AllFiltersPage().inputProducerClick();
    }

    @Step("Ожидаем появления на странице Производителя {0}")
    public void stepWaitProducerVisible(String producer){
        new AllFiltersPage().waitProducerVisible(producer);
    }

}
