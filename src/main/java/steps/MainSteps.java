package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps {

    @Step("Выбран пункт меню {0}")
    public void stepSelectMarketMenu(){
        new MainPage().selectMarketMenu();
    }

}
