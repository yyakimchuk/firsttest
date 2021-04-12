package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'active')]//a[text()='Оформление']")
    WebElement titleOrdering;

    @FindBy(id = "surname_vzr_ins_0")
    public WebElement surnameInsured;

    @FindBy(id = "name_vzr_ins_0")
    public WebElement nameInsured;

    @FindBy(id = "birthDate_vzr_ins_0")
    public WebElement dateOfBirthInsured;

    @FindBy(id = "person_lastName")
    public WebElement lastNameInsurant;

    @FindBy(id = "person_firstName")
    public WebElement firstNameInsurant;

    @FindBy(id = "person_middleName")
    public WebElement middleNameInsurant;

    @FindBy(id = "person_birthDate")
    public WebElement dateOfBirthInsurant;

    @FindBy(id = "passportSeries")
    public WebElement passportSeries;

    @FindBy(id = "passportNumber")
    public WebElement passportNumber;

    @FindBy(id = "documentDate")
    public WebElement documentDate;

    @FindBy(id = "documentIssue")
    public WebElement issuedBy;

    @FindBy(xpath = "//label[text()='Женский']")
    public WebElement femaleBtn;

    @FindBy(xpath = "//button[contains(text(),'Продолжить')]")
    public WebElement nextStepBtn;

    @FindBy(xpath = "//div[contains(@class,'alert-form')]")
    public WebElement errorMsg;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(titleOrdering));
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                fillField(surnameInsured, value);
                break;
            case "Имя застрахованного":
                fillField(nameInsured, value);
                break;
            case "Дата рождения застрахованного":
                fillField(dateOfBirthInsured, value);
                break;
            case "Фамилия страхователя":
                fillField(lastNameInsurant, value);
                break;
            case "Имя страхователя":
                fillField(firstNameInsurant, value);
                break;
            case "Отчество страхователя":
                fillField(middleNameInsurant, value);
                break;
            case "Дата рождения страхователя":
                fillField(dateOfBirthInsurant, value);
                break;
            case "Серия":
                fillField(passportSeries, value);
                break;
            case "Номер":
                fillField(passportNumber, value);
                break;
            case "Дата выдачи":
                fillField(documentDate, value);
                break;
            case "Кем выдан":
                fillField(issuedBy, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }


    public String getFillField(String fieldName) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                return surnameInsured.getAttribute("value");
            case "Имя застрахованного":
                return nameInsured.getAttribute("value");
            case "Дата рождения застрахованного":
                return dateOfBirthInsured.getAttribute("value");
            case "Фамилия страхователя":
                return lastNameInsurant.getAttribute("value");
            case "Имя страхователя":
                return firstNameInsurant.getAttribute("value");
            case "Отчество страхователя":
                return middleNameInsurant.getAttribute("value");
            case "Дата рождения страхователя":
                return dateOfBirthInsurant.getAttribute("value");
            case "Серия":
                return passportSeries.getAttribute("value");
            case "Номер":
                return passportNumber.getAttribute("value");
            case "Дата выдачи":
                return documentDate.getAttribute("value");
            case "Кем выдан":
                return issuedBy.getAttribute("value");
        }

        throw new AssertionError("Поле не объявлено на странице");
    }

    public void checkFieldErrorMessage(String field, String errorMessage) {
        String xpath = "//span[contains(text(),'" + field + "')]/..//input[contains(@class,'form-control ng-untouched ng-pristine ng-invalid')]/../validation-message/span";
        String actualValue = driver.findElement(By.xpath(xpath)).getText();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }
}
