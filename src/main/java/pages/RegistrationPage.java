package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

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

    public RegistrationPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
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


    public void getFillField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                checkFillField(value, surnameInsured);
                break;
            case "Имя застрахованного":
                checkFillField(value, nameInsured);
                break;
            case "Дата рождения застрахованного":
                checkFillField(value, dateOfBirthInsured);
                break;
            case "Фамилия страхователя":
                checkFillField(value, lastNameInsurant);
                break;
            case "Имя страхователя":
                checkFillField(value, firstNameInsurant);
                break;
            case "Отчество страхователя":
                checkFillField(value, middleNameInsurant);
                break;
            case "Дата рождения страхователя":
                checkFillField(value, dateOfBirthInsurant);
                break;
            case "Серия":
                checkFillField(value, passportSeries);
                break;
            case "Номер":
                checkFillField(value, passportNumber);
                break;
            case "Дата выдачи":
                checkFillField(value, documentDate);
                break;
            case "Кем выдан":
                checkFillField(value, issuedBy);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }
}

