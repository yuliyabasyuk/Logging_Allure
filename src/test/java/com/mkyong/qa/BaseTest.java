package com.mkyong.qa;

import com.mkyong.utils.ConfigureAppender;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {
    String testMethod;
    static Logger logger;

    @BeforeMethod
    public void setUp(Method method) {
        testMethod = method.getName();
        logger = ConfigureAppender.configureLogger(testMethod);
    }

    @AfterMethod
    public void tearDown() {
        ConfigureAppender.addAllureFileAttachment(testMethod);
    }
}
