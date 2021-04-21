package steps;

import pages.ElectronicsPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ElectronicsPageSteps {

    @Step("Выбрана категория {0}")
    public void stepSelectMarketCategoryMenu(String menuItem){
       new ElectronicsPage().selectMarketCategoryMenu(menuItem);
    }

}
