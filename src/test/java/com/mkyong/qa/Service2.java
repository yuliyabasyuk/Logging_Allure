package com.mkyong.qa;

import com.mkyong.utils.KCOSUtils;
import org.testng.annotations.Test;

public class Service2 extends BaseTest{

    @Test
    public void test4() {
        logger.debug("DEBUG - " + testMethod);
        logger.info("INFO - " + testMethod);
        logger.warn("WARN - " + testMethod);
        logger.error("ERROR - " + testMethod);
        KCOSUtils.callGeneralMethod(logger);
    }

    @Test
    public void test5() {
        logger.debug("DEBUG - " + testMethod);
        logger.info("INFO - " + testMethod);
        logger.warn("WARN - " + testMethod);
        logger.error("ERROR - " + testMethod);
    }

    @Test
    public void test6() {
        logger.debug("DEBUG - " + testMethod);
        logger.info("INFO - " + testMethod);
        logger.warn("WARN - " + testMethod);
        logger.error("ERROR - " + testMethod);
    }
}
