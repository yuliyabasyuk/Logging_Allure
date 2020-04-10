package com.mkyong.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub
        attachLogsToAllure("onFinish");
    }

    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    public void onTestFailure(ITestResult iTestResult) {
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");

        AllureLifecycle allureLifecycle = Allure.getLifecycle();
        byte[] biteArray;
        try {
            biteArray = FileUtils.readFileToByteArray(new File(System.getProperty("user.dir") + "/Log4j/log4j-application.log"));
        } catch (IOException ex){
            biteArray = null;
        }
        allureLifecycle.addAttachment("Test logs", "text/plain", "log", biteArray);

        attachLogsToAllure("onTestFailure");
    }

    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    public void onTestSuccess(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Attachment(value = "0", type = "text/plain")
    private static String saveTextLog(String message){
        return message;
    }

    @Attachment()
    private static void attachLogsToAllure(String message){
        AllureLifecycle allureLifecycle = Allure.getLifecycle();
        byte[] biteArray;
        try {
            biteArray = FileUtils.readFileToByteArray(new File(System.getProperty("user.dir") + "/Log4j/log4j-application.log"));
        } catch (IOException ex){
            biteArray = null;
        }
        allureLifecycle.addAttachment("Logs attachment " + message, "text/plain", "log", biteArray);
    }

    private static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();

    }
}
