import org.junit.Test;
import pages.*;

import static org.junit.Assert.assertTrue;

public class RefactoringInsuranceTest extends BaseTest {

    @Test
    public void RefactoringInsuranceTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.closeBtn.click();
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Перейти в каталог");

        new CatalogPage(driver).travelInsuranceLink.click();

        TravelInsurancePage travelInsurancePage = new TravelInsurancePage(driver);
        travelInsurancePage.title.click();
        String actualTitle = travelInsurancePage.title.getText();
        String expectedTitle = "Страхование путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",actualTitle,expectedTitle),actualTitle.contains(expectedTitle));
        travelInsurancePage.arrangeOnlineBtn.click();

        ChoosingPolicyPage choosingPolicyPage = new ChoosingPolicyPage(driver);
        choosingPolicyPage.protectionSumMin.click();
        waitElementToBeClickable(choosingPolicyPage.orderBtn);
        moveElement(choosingPolicyPage.orderBtn);
        choosingPolicyPage.orderBtn.click();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillField("Фамилия застрахованного","Иванов");
        registrationPage.fillField("Имя застрахованного","Иван");
        registrationPage.fillField("Дата рождения застрахованного","02.02.1991");
        registrationPage.lastNameInsurant.click();
        registrationPage.fillField("Фамилия страхователя","Иванова");
        registrationPage.fillField("Имя страхователя","Иванна");
        registrationPage.fillField("Отчество страхователя","Ивановна");
        registrationPage.fillField("Дата рождения страхователя","01.01.1991");
        registrationPage.passportSeries.click();
        registrationPage.fillField("Серия","5005");
        registrationPage.fillField("Номер","321456");
        registrationPage.fillField("Дата выдачи","01.01.2012");
        registrationPage.issuedBy.click();
        registrationPage.fillField("Кем выдан","УФМС России по Какой-то области в Другом районе");
        registrationPage.femaleBtn.click();

        checkFillField("Иванов", registrationPage.surnameInsured);
        checkFillField("Иван", registrationPage.nameInsured);
        checkFillField("02.02.1991", registrationPage.dateOfBirthInsured);
        checkFillField("Иванова", registrationPage.lastNameInsurant);
        checkFillField("Иванна", registrationPage.firstNameInsurant);
        checkFillField("Ивановна", registrationPage.middleNameInsurant);
        checkFillField("01.01.1991", registrationPage.dateOfBirthInsurant);
        checkFillField("5005", registrationPage.passportSeries);
        checkFillField("321456", registrationPage.passportNumber);
        checkFillField("01.01.2012", registrationPage.documentDate);
        checkFillField("УФМС России по Какой-то области в Другом районе", registrationPage.issuedBy);

        registrationPage.nextStepBtn.click();

        waitElementToBeVisible(registrationPage.errorMsg);
        checkFieldText("При заполнении данных произошла ошибка", registrationPage.errorMsg);

        checkFieldErrorMessage("Мобильный телефон","Поле не заполнено.");
        checkFieldErrorMessage("Электронная почта","Поле не заполнено.");
        checkFieldErrorMessage("Повтор электронной почты","Поле не заполнено.");
    }
}
