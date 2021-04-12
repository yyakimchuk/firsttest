import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class InsuranceTest extends BaseTest{

    @Test
    @Ignore
    public void testInsurance() {
        driver.get(baseUrl);
        //закрываем всплывающее сообщение
        driver.findElement(By.xpath("//button[text()='Закрыть']")).click();
        //Нажать на – Страхование
        driver.findElement(By.xpath("//a[@aria-label='Страхование']")).click();
        //Нажать на – Перейти в каталог
        driver.findElement(By.xpath("//*[contains(text(),'Перейти в каталог')]")).click();

        //Ожидаем когда кнопка Страхование путешественников станет видна, Нажать на - Страхование путешественников
        Wait<WebDriver> wait = new WebDriverWait(driver,5,1000);
        WebElement travelInsuranceLink = driver.findElement(By.xpath("//*[contains(text(),'Страхование для путешественников')]/parent::a"));
        wait.until(ExpectedConditions.visibilityOf(travelInsuranceLink)).click();

        //Ожидаем пока элемент будет виден. Проверить наличие на странице заголовка – Страхование путешественников
        WebElement title = driver.findElement(By.xpath("//h1[contains(@class,'kitt-heading')]"));
        wait.until(ExpectedConditions.visibilityOf(title));
        Assert.assertEquals("Страхование путешественников", title.getText());

        //Нажать на – Оформить Онлайн
        driver.findElement(By.xpath("//*[contains(text(),'Оформить онлайн')]/parent::a")).click();

        //Ожидаем открытия страницы. На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        WebElement titlePolicy = driver.findElement(By.xpath("//h2[contains(text(),'Страхование путешественников')]"));
        wait.until(ExpectedConditions.visibilityOf(titlePolicy));
        driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
            driver.findElement(By.xpath("//h3[contains(text(),'Минимальная')]")).click();

        //Нажать Оформить (Необходимо сначала навести фокус на кнопку, проверить что она видна, потом нажать)
        Actions builder = new Actions(driver);
        WebElement orderBtn = driver.findElement(By.xpath("//button[text()='Оформить']"));
        builder.moveToElement(orderBtn).build().perform();
        WebDriverWait waitDriver = new WebDriverWait(driver,1000);
        waitDriver.until(ExpectedConditions.elementToBeClickable(orderBtn));
        orderBtn.click();

        //Ожидание открытия страницы
        WebElement orderingPage = driver.findElement(By.xpath("//div[contains(@class,'active')]//a[text()='Оформление']"));
        wait.until(ExpectedConditions.visibilityOf(orderingPage));

        //Заполнить поля: Фамилию и Имя, Дату рождения застрахованных
        fillFiled(By.id("surname_vzr_ins_0"),"Иванов");
        fillFiled(By.id("name_vzr_ins_0"),"Иван");
        fillFiled(By.id("birthDate_vzr_ins_0"),"11.11.1991");

        //Заполнить поля: Данные страхователя: Фамилия, Имя, Отчество, Дата рождения
        driver.findElement(By.id("person_lastName")).click();
        fillFiled(By.id("person_lastName"),"Иванов");
        fillFiled(By.id("person_firstName"),"Иван");
        fillFiled(By.id("person_middleName"),"Иванович");
        fillFiled(By.id("person_birthDate"),"11.11.1991");

        //Заполнить Паспортные данные
        driver.findElement(By.id("passportSeries")).click();
        fillFiled(By.id("passportSeries"),"5005");
        fillFiled(By.id("passportNumber"),"223556");
        fillFiled(By.id("documentDate"),"15.11.2015");
        driver.findElement(By.id("documentIssue")).click();
        fillFiled(By.id("documentIssue"),"УФМС России по Какой-то области в Другом районе");

        //Выбрать пол
        driver.findElement(By.xpath("//label[text()='Женский']")).click();

        //Проверить, что все поля заполнены правильно
        Assert.assertEquals("Иванов",
                driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("Иван",
                driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("11.11.1991",
                driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));

        Assert.assertEquals("Иванов",
                driver.findElement(By.id("person_lastName")).getAttribute("value"));
        Assert.assertEquals("Иван",
                driver.findElement(By.id("person_firstName")).getAttribute("value"));
        Assert.assertEquals("Иванович",
                driver.findElement(By.id("person_middleName")).getAttribute("value"));
        Assert.assertEquals("11.11.1991",
                driver.findElement(By.id("person_birthDate")).getAttribute("value"));

        Assert.assertEquals("5005",
                driver.findElement(By.id("passportSeries")).getAttribute("value"));
        Assert.assertEquals("223556",
                driver.findElement(By.id("passportNumber")).getAttribute("value"));
        Assert.assertEquals("15.11.2015",
                driver.findElement(By.id("documentDate")).getAttribute("value"));
        Assert.assertEquals("УФМС России по Какой-то области в Другом районе",
                driver.findElement(By.id("documentIssue")).getAttribute("value"));

        //Нажать продолжить
        WebElement nextBtn = driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]"));
        builder.moveToElement(nextBtn).build().perform();
        nextBtn.click();

        //Проверить, что появилось сообщение - "При заполнении данных произошла ошибка", "Поле не заполнено"
        WebElement errorMsg = driver.findElement(By.xpath("//div[contains(@class,'alert-form')]"));
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        Assert.assertEquals("При заполнении данных произошла ошибка", errorMsg.getText());

        Assert.assertEquals("Поле не заполнено.",
                driver.findElement(By.xpath("//input-phone2[@name='phone']//validation-message/span")).getText());
        Assert.assertEquals("Поле не заполнено.",
                driver.findElement(By.xpath("//input-email[@name='email']//validation-message/span")).getText());
        Assert.assertEquals("Поле не заполнено.",
                driver.findElement(By.xpath("//input-email[@name='repeatEmail']//validation-message/span")).getText());
    }
}
