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

public class AllFiltersPage extends BasePage {

    @FindBy(xpath = "//h4[contains(text(),'Цена')]/ancestor::div[1]//div[@data-prefix='от']/input")
    public WebElement priceFromInput;

    @FindBy(xpath = "//div[@data-filter-id='7893318']//div[@data-filter-id='7893318']")
    public WebElement producerChkBox;

    @FindBy(xpath = "//a[@class='_2qvOOvezty _3qN-vKmEan _1Rc6LxE3Tr']")
    public WebElement applyFilterBtn;

    @FindBy(xpath = "//input[@class='_34OG20yGDA']")
    public WebElement inputProducer;



    public AllFiltersPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(priceFromInput));
    }

    public void selectProducer(String producer){
        producerChkBox.findElement(By.xpath(".//div[contains(text(),'"+producer+"')]/..")).click();
    }

    public void waitProducerVisible(String producer){
        new BaseSteps().waitElementToBeVisible(producerChkBox.findElement(By.xpath(".//div[contains(text(),'"+producer+"')]/..")));
    }

    public void setPriceFromInput(String price){
        fillField(priceFromInput, price);
    }

    public void applyFilterBtnClick(){
        applyFilterBtn.click();
    }

    public void setInputProducer(String value){
        inputProducer.sendKeys(value);
    }

    public void inputProducerClick(){
        inputProducer.click();
    }


}
