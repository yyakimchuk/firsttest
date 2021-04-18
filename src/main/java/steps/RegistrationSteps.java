package steps;

import org.openqa.selenium.WebElement;
import pages.RegistrationPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class RegistrationSteps {

    @Step("Поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value){
        new RegistrationPage().fillField(field, value);
    }

    @Step("Заполняются поля:")
    public void stepFillFields(HashMap<String, String> fields){
        fields.forEach((field, value) -> stepFillField(field, value));
    }

    @Step("Поле {0} заполнено значением {1}")
    public void stepGetFillField(String field, String value){
        new RegistrationPage().getFillField(field, value);
    }

    @Step("Сравниваем значения полей:")
    public void stepGetFillFields(HashMap<String, String> fields){
        fields.forEach((field, value) -> stepGetFillField(field, value));
    }

    @Step("Переводим курсор в поле Фамилия страхователя")
    public void stepLastNameInsurantClick(){
        new RegistrationPage().lastNameInsurant.click();
    }

    @Step("Переводим курсор в поле Серия паспорта")
    public void stepPassportSeriesClick(){
        new RegistrationPage().passportSeries.click();
    }

    @Step("Выбираем пол - женский")
    public void stepFemaleBtnClick(){
        new RegistrationPage().femaleBtn.click();
    }

    @Step("Нажимаем кнопку - Продолжить")
    public void stepNextStepBtnClick(){
        new RegistrationPage().nextStepBtn.click();
    }

    @Step("Проверяем, что значение поля {0} заполняется значением {1}")
    public void stepCheckFillField(String field, String value){
        new RegistrationPage().fillField(field, value);
    }

    @Step("Ожидаем отображения сообщения об ошибке")
    public void stepWaitErroMsgToBeVisible(){
        new BaseSteps().waitElementToBeVisible(new RegistrationPage().errorMsg);
    }

    @Step("Проверяем, что текст сообщения об ошибке равен {0}")
    public void stepCheckFieldText(String value, WebElement element){
        new BaseSteps().checkFieldText(value, element);
    }

    @Step("Проверяем текст сообщения об ошибке для поля {0}")
    public void stepСheckFieldErrorMessage(String field, String errorMsg){
        new BaseSteps().checkFieldErrorMessage(field, errorMsg);
    }

}
