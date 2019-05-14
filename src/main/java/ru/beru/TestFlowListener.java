package ru.beru;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestFlowListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        StepListener.screenshot();
    }
}
