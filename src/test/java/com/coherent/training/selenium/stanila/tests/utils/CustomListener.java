package com.coherent.training.selenium.stanila.tests.utils;

import com.coherent.training.selenium.stanila.tests.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Screenshot.screenshotPerform(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
