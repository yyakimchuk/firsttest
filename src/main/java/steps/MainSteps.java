package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps {

    @Step("Закрыто всплывающее сообщение")
    public void stepCloseBtnClick(){
        new MainPage().closeBtn.click();
    }

    @Step("Выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem){
        new MainPage().selectMainMenu(menuItem);
    }

    @Step("Выбран пункт Перейти в каталог {0}")
    public void stepSelectSubMenu(String menuItem){
        new MainPage().selectSubMenu(menuItem);
    }
}
