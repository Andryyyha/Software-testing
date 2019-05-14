package ru.beru;

import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;

public class CustomListener extends TestConfig implements StepLifecycleListener {

    @Override
    public void beforeStepStop(StepResult result) {
        AttachScreenshot a = new AttachScreenshot(driver);
        a.takeScreenshot();
    }
}
