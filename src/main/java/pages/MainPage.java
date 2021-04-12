package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//ul[contains(@class, 'kitt-top-menu')]")
    WebElement mainMenu;

    @FindBy(xpath = "//a[@aria-expanded='true']/following::div[1]")
    WebElement subMenu;

    @FindBy(xpath = "//button[text()='Закрыть']")
    public WebElement closeBtn;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void selectMainMenu (String menuItem){
        mainMenu.findElement(By.xpath("./li/a[contains(text(),'"+menuItem+"')]")).click();
    }

    public void selectSubMenu (String menuItem){
        subMenu.findElement(By.xpath(".//li/a[contains(text(), '"+menuItem+"')]")).click();
    }
}
