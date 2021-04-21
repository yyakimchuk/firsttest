package steps;

import pages.SelectedCategoryPage;
import ru.yandex.qatools.allure.annotations.Step;

public class SelectedCategoryPageSteps {

    @Step("Нажимается кнопка - Все фильтры")
    public void stepTVSetPageClick(){
        new SelectedCategoryPage().tVSetPageClick();
    }

    @Step("Запоминается наименование товара под номером {0} из списка")
    public void stepSelectNameElementSearch(String name, String number){
        new SelectedCategoryPage().selectNameElementSearch(name, number);
    }


    @Step("Заполняется поле поиска значением переменной {0}")
    public void stepSetNameElementInSearchField(String name){
        new SelectedCategoryPage().setNameElementInSearchField(name);
    }

    @Step("Выбирается поле Поиск")
    public void stepSearchFieldClick(){
        new SelectedCategoryPage().searchFieldClick();
    }

    @Step("Нажимается кнопка Найти")
    public void stepSearchBtnClick(){
        new SelectedCategoryPage().searchBtnClick();
    }

    @Step("Ожидаем отображения результатов поиска")
    public void stepWaitSearchResult(){
        new SelectedCategoryPage().waitSearchResult();
    }

}
