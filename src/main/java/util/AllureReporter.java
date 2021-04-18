package util;

import gherkin.formatter.model.Result;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import steps.BaseSteps;

public class AllureReporter extends ru.yandex.qatools.allure.cucumberjvm.AllureReporter {

    @Override
    public void result(Result result) {
        if(result.getStatus().equals("failed")){
            takeScreenShot();
        }
        super.result(result);
    }

    @Attachment(type = "image/png", value = "Скриншот при ошибке")
    public byte[] takeScreenShot() {
        return ((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
