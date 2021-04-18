package steps;

import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class TravelInsuranceSteps {

    @Step("Получаем текст заголовка")
    public String stepGetTitleText(){
       String titleText = new TravelInsurancePage().title.getText();
       return titleText;
    }

    @Step("Проверяем, что текст заголовка {0} равен {1}")
    public void stepAssertTitle(String actualTitle, String expectedTitle){
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",actualTitle,expectedTitle),actualTitle.contains(expectedTitle));
    }

    @Step("Нажимаем кнопку Оформить онлайн")
    public void stepArrangeOnlineBtnClick(){
        new TravelInsurancePage().arrangeOnlineBtn.click();
    }
}
