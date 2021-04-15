package steps;

import pages.CatalogPage;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps {

    @Step("Закрыто всплывающее сообщение")
    public void stepCloseBtnClick(){
        new MainPage(driver).closeBtn.click();
    }

    @Step("Выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem){
        new MainPage(driver).selectMainMenu(menuItem);
    }

    @Step("Выбран пункт Перейти в каталог {0}")
    public void stepSelectSubMenu(String menuItem){
        new MainPage(driver).selectSubMenu(menuItem);
    }
}
