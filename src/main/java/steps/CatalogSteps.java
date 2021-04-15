package steps;

import pages.CatalogPage;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class CatalogSteps extends BaseSteps {

    @Step("Выбрано Страхование для путешественников")
    public void stepTravelInsuranceLinkClick(){
        new CatalogPage(driver).travelInsuranceLink.click();
    }

}
