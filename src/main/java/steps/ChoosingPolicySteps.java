package steps;

import pages.ChoosingPolicyPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ChoosingPolicySteps {

    @Step("Выбираем сумму страховой защиты – Минимальная")
    public void stepProtectionSumMinClick(){
        new ChoosingPolicyPage().protectionSumMin.click();
    }

    @Step("Ожидаем, что кнопка Оформить станет кликабельна")
    public void stepWaitOrderBtnToBeClickable(){
        new BaseSteps().waitElementToBeClickable(new ChoosingPolicyPage().orderBtn);
    }

    @Step("Наводим курсор на кнопку Оформить")
    public void stepMoveToOrderBtn(){
        new BaseSteps().moveElement(new ChoosingPolicyPage().orderBtn);
    }

    @Step("Нажимаем на кнопку Оформить")
    public void stepOrderBtnClick(){
        new ChoosingPolicyPage().orderBtn.click();
    }
}
