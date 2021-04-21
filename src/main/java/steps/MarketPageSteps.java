package steps;

import pages.MarketPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketPageSteps {

    @Step("Выбран пункт меню {0}")
    public void stepSelectMarketMainMenu(String menuItem){
        new MarketPage().selectMarketMainMenu(menuItem);
    }

}
