package com.mkyong.qa;

import com.mkyong.utils.ConfigureAppender;
import com.mkyong.utils.KCOSUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Service3 extends BaseTest1 {
    String testMethod;
//    final static Logger LOG = Logger.getLogger(Service3.class);

    final static Logger LOG = Logger.getLogger(Service3.class);

//    @BeforeMethod
//    public void setUp(Method method) {
//        testMethod = method.getName();
//        ConfigureAppender.configureLogger1(testMethod);
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        ConfigureAppender.addAllureFileAttachment(testMethod);
//    }

    @Test
    public void test7() {
        LOG.debug("DEBUG - " + testMethod);
        LOG.info("INFO - " + testMethod);
        LOG.warn("WARN - " + testMethod);
        LOG.error("ERROR - " + testMethod);
        KCOSUtils.callGeneralMethod1();
    }

    @Test
    public void test8() {
        LOG.debug("DEBUG - " + testMethod);
        LOG.info("INFO - " + testMethod);
        LOG.warn("WARN - " + testMethod);
        LOG.error("ERROR - " + testMethod);
    }

    @Test
    public void test9() {
        LOG.debug("DEBUG - " + testMethod);
        LOG.info("INFO - " + testMethod);
        LOG.warn("WARN - " + testMethod);
        LOG.error("ERROR - " + testMethod);
    }
}
