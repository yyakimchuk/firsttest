package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.RegistrationPage;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    CatalogSteps catalogSteps = new CatalogSteps();
    TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
    ChoosingPolicySteps choosingPolicySteps = new ChoosingPolicySteps();
    RegistrationSteps registrationSteps = new RegistrationSteps();


    @When("^нажимается кнопка Закрыть на всплывающем сообщении$")
    public void stepCloseBtnClick(){
        mainSteps.stepCloseBtnClick();
    }

    @When("^выбирается пункт меню \"(.*)\"$")
    public void stepSelectMainMenu(String menuItem){
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^выбирается продукт \"(.*)\" в списке$")
    public void stepSelectSubMenu(String menuItem){
        mainSteps.stepSelectSubMenu(menuItem);
    }

    @When("^выбирается продукт страхования - Страхование для путешественников$")
    public void stepTravelInsuranceLinkClick(){
        catalogSteps.stepTravelInsuranceLinkClick();
    }

    @When("^заголовок страницы равен \"(.*)\"$")
    public void stepAssertTitle(String value) {
        travelInsuranceSteps.stepAssertTitle(travelInsuranceSteps.stepGetTitleText(), value);
    }

    @When("^нажимается кнопка Оформить онлайн$")
    public void stepArrangeOnlineBtnClick(){
        travelInsuranceSteps.stepArrangeOnlineBtnClick();
    }

    @When("^выбирается сумма страховой защиты - Минимальная$")
    public void stepProtectionSumMinClick(){
        choosingPolicySteps.stepProtectionSumMinClick();
    }

    @When("^ожидание, что кнопка Оформить станет кликабельна$")
    public void stepWaitOrderBtnToBeClickable(){
        choosingPolicySteps.stepWaitOrderBtnToBeClickable();
    }

    @When("^наводится курсор на кнопку Оформить$")
    public void stepMoveToOrderBtn(){
        choosingPolicySteps.stepMoveToOrderBtn();
    }

    @When("^нажимается кнопка - Оформить$")
    public void stepOrderBtnClick(){
        choosingPolicySteps.stepOrderBtnClick();
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> registrationSteps.stepFillField(field, value));

    }

    @When("^выбирается поле Фамилия страхователя$")
    public void stepLastNameInsurantClick(){
        registrationSteps.stepLastNameInsurantClick();
    }

    @When("^выбирается поле Серия паспорта$")
    public void stepPassportSeriesClick(){
        registrationSteps.stepPassportSeriesClick();
    }

    @When("^выбирается пол - Женский$")
    public void stepFemaleBtnClick(){
        registrationSteps.stepFemaleBtnClick();
    }

    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> registrationSteps.stepGetFillField(field, value));
    }

    @When("^нажимается кнопка - Продолжить$")
    public void stepNextStepBtnClick(){
        registrationSteps.stepNextStepBtnClick();
    }

    @When("^ожидание отображения сообщения об ошибке$")
    public void stepWaitErroMsgToBeVisible(){
        registrationSteps.stepWaitErroMsgToBeVisible();
    }

    @When("^текст ошибки равен \"(.*)\"$")
    public void stepCheckFieldText(String value){
        registrationSteps.stepCheckFieldText(value, (new RegistrationPage().errorMsg));
    }

    @When("^текст сообщения об ошибке для поля \"(.*)\" равен \"(.*)\"$")
    public void stepCheckFieldText(String field, String errorMsg){
        new BaseSteps().checkFieldErrorMessage(field, errorMsg);
    }
}
