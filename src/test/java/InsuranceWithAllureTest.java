import org.junit.Test;
import pages.RegistrationPage;
import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class InsuranceWithAllureTest extends BaseSteps {

    @Test
    @Title("Страхование путешественников в Сбербанке")
    public void testInsurance() {
        MainSteps mainSteps = new MainSteps();
        CatalogSteps catalogSteps = new CatalogSteps();
        TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
        ChoosingPolicySteps choosingPolicySteps = new ChoosingPolicySteps();
        RegistrationSteps registrationSteps = new RegistrationSteps();


        mainSteps.stepCloseBtnClick();
        mainSteps.stepSelectMainMenu("Страхование");
        mainSteps.stepSelectSubMenu("Перейти в каталог");

        catalogSteps.stepTravelInsuranceLinkClick();

        travelInsuranceSteps.stepAssertTitle(travelInsuranceSteps.stepGetTitleText(), "Страхование путешественников");
        travelInsuranceSteps.stepArrangeOnlineBtnClick();

        choosingPolicySteps.stepProtectionSumMinClick();
        choosingPolicySteps.stepWaitOrderBtnToBeClickable();
        choosingPolicySteps.stepMoveToOrderBtn();
        choosingPolicySteps.stepOrderBtnClick();

        HashMap<String, String> insuredData = new HashMap <>();
        insuredData.put("Фамилия застрахованного", "Иванов");
        insuredData.put("Имя застрахованного","Иван");
        insuredData.put("Дата рождения застрахованного","02.02.1991");
        registrationSteps.stepFillFields(insuredData);

        registrationSteps.stepLastNameInsurantClick();
        HashMap<String, String> insurantData = new HashMap <>();
        insurantData.put("Фамилия страхователя","Иванова");
        insurantData.put("Имя страхователя","Иванна");
        insurantData.put("Отчество страхователя","Ивановна");
        insurantData.put("Дата рождения страхователя","01.01.1991");
        registrationSteps.stepFillFields(insurantData);

        registrationSteps.stepPassportSeriesClick();
        HashMap<String, String> passportData = new HashMap <>();
        passportData.put("Серия","5005");
        passportData.put("Номер","321456");
        passportData.put("Дата выдачи","01.01.2012");
        passportData.put("Кем выдан","УФМС России по Какой-то области в Другом районе");
        registrationSteps.stepFillFields(passportData);

        registrationSteps.stepFemaleBtnClick();
        HashMap<String, String> testData = new HashMap <>();
        testData.put("Фамилия застрахованного", "Иванов");
        testData.put("Имя застрахованного","Иван");
        testData.put("Дата рождения застрахованного","02.02.1991");
        testData.put("Фамилия страхователя","Иванова");
        testData.put("Имя страхователя","Иванна");
        testData.put("Отчество страхователя","Ивановна");
        testData.put("Дата рождения страхователя","01.01.1991");
        testData.put("Серия","5005");
        testData.put("Номер","321456");
        testData.put("Дата выдачи","01.01.2012");
        testData.put("Кем выдан","УФМС России по Какой-то области в Другом районе");
        registrationSteps.stepGetFillFields(testData);

        registrationSteps.stepNextStepBtnClick();

        registrationSteps.stepWaitErroMsgToBeVisible();
        registrationSteps.stepCheckFieldText("При заполнении данных произошла ошибка", (new RegistrationPage(driver).errorMsg));

        registrationSteps.stepСheckFieldErrorMessage("Мобильный телефон","Поле не заполнено.");
        registrationSteps.stepСheckFieldErrorMessage("Электронная почта","Поле не заполнено.");
        registrationSteps.stepСheckFieldErrorMessage("Повтор электронной почты","Поле не заполнено.");

    }
}
