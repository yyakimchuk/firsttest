package steps;

import org.openqa.selenium.WebElement;
import pages.RegistrationPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class RegistrationSteps extends BaseSteps {

    @Step("Поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value){
        new RegistrationPage(driver).fillField(field, value);
    }

    @Step("Заполняются поля:")
    public void stepFillFields(HashMap<String, String> fields){
        fields.forEach((field, value) -> stepFillField(field, value));
    }

    @Step("Поле {0} заполнено значением {1}")
    public void stepGetFillField(String field, String value){
        new RegistrationPage(driver).getFillField(field, value);
    }

    @Step("Сравниваем значения:")
    public void stepGetFillFields(HashMap<String, String> fields){
        fields.forEach((field, value) -> stepGetFillField(field, value));
    }

    @Step("Переводим курсор в поле Фамилия страхователя")
    public void stepLastNameInsurantClick(){
        new RegistrationPage(driver).lastNameInsurant.click();
    }

    @Step("Переводим курсор в поле Серия паспорта")
    public void stepPassportSeriesClick(){
        new RegistrationPage(driver).passportSeries.click();
    }

    @Step("Выбираем пол - женский")
    public void stepFemaleBtnClick(){
        new RegistrationPage(driver).femaleBtn.click();
    }

    @Step("Нажимаем кнопку - Продолжить")
    public void stepNextStepBtnClick(){
        new RegistrationPage(driver).nextStepBtn.click();
    }

    @Step("Проверяем, что значение поля {0} заполняется значением {1}")
    public void stepCheckFillField(String field, String value){
        new RegistrationPage(driver).fillField(field, value);
    }

    @Step("Ожидаем отображения сообщения об ошибке")
    public void stepWaitErroMsgToBeVisible(){
        waitElementToBeVisible(new RegistrationPage(driver).errorMsg);
    }

    @Step("Проверяем, что текст сообщения об ошибке равен {0}")
    public void stepCheckFieldText(String value, WebElement element){
        checkFieldText(value, element);
    }

    @Step("Проверяем текст сообщения об ошибке для поля {0}")
    public void stepСheckFieldErrorMessage(String field, String errorMsg){
        checkFieldErrorMessage(field, errorMsg);
    }

}
