package steps;

import pages.ChoosingPolicyPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ChoosingPolicySteps extends BaseSteps {

    @Step("Выбираем сумму страховой защиты – Минимальная")
    public void stepProtectionSumMinClick(){
        new ChoosingPolicyPage(driver).protectionSumMin.click();
    }

    @Step("Ожидаем, что кнопка Оформить станет кликабельна")
    public void stepWaitOrderBtnToBeClickable(){
        waitElementToBeClickable(new ChoosingPolicyPage(driver).orderBtn);
    }

    @Step("Наводим курсор на кнопку Оформить")
    public void stepMoveToOrderBtn(){
        moveElement(new ChoosingPolicyPage(driver).orderBtn);
    }

    @Step("Нажимаем на кнопку Оформить")
    public void stepOrderBtnClick(){
        new ChoosingPolicyPage(driver).orderBtn.click();
    }
}
