package steps;

import org.openqa.selenium.WebDriver;
import pages.CatalogPage;
import ru.yandex.qatools.allure.annotations.Step;

public class CatalogSteps {

    @Step("Выбрано Страхование для путешественников")
    public void stepTravelInsuranceLinkClick(){
        CatalogPage catalogPage = new CatalogPage();
        new CatalogPage().travelInsuranceLink.click();
    }

}
