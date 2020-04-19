package com.mkyong.qa;

import org.testng.annotations.Test;

public class Service1 extends BaseTest {
//    private String testMethod;
//    private Logger logger;
//
//    //TODO: move these  @BeforeMethod and @AfterMethod to the BaseTest
//    @BeforeMethod
//    public void setUp(Method method) {
//        testMethod = method.getName();
//        logger = ConfigureAppender.configureLogger(testMethod);
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        ConfigureAppender.addAllureFileAttachment(testMethod);
//    }

    @Test
    public void test1() {
//        final Logger logger = ConfigureAppender.configureLogger(testMethod);

        //TODO: check that trace is not shown
        logger.debug("DEBUG - " + testMethod);
        logger.info("INFO - " + testMethod);
        logger.warn("WARN - " + testMethod);
        logger.error("ERROR - " + testMethod);
    }

    @Test
    public void test2() {
//        String logfilePath = ConfigureAppender.getLogfilePath(testMethod);
//        ConfigureAppender.configureFileAppender(logfilePath);

        //TODO: check that trace is not shown
        logger.debug("DEBUG - " + testMethod);
        logger.info("INFO - " + testMethod);
        logger.warn("WARN - " + testMethod);
        logger.error("ERROR - " + testMethod);

//        ConfigureAppender.addAllureFileAttachment(testMethod);
    }

    @Test
    public void test3() {
//        String logfilePath = ConfigureAppender.getLogfilePath(testMethod);
//////        ConfigureAppender.configureFileAppender(logfilePath);

        //TODO: check that trace is not shown
        logger.debug("DEBUG - " + testMethod);
        logger.info("INFO - " + testMethod);
        logger.warn("WARN - " + testMethod);
        logger.error("ERROR - " + testMethod);

//        ConfigureAppender.addAllureFileAttachment(testMethod);
    }
}
