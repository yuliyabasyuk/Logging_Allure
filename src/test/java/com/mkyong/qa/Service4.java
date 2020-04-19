package com.mkyong.qa;

import com.mkyong.utils.KCOSUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Service4 extends BaseTest1 {
    final static Logger LOG = Logger.getLogger(Service4.class);

    @Test
    public void test10() {
        LOG.debug("DEBUG - " + testMethod);
        LOG.info("INFO - " + testMethod);
        LOG.warn("WARN - " + testMethod);
        LOG.error("ERROR - " + testMethod);
        KCOSUtils.callGeneralMethod2();
    }

    @Test
    public void test11() {
        LOG.debug("DEBUG - " + testMethod);
        LOG.info("INFO - " + testMethod);
        LOG.warn("WARN - " + testMethod);
        LOG.error("ERROR - " + testMethod);
    }

    @Test
    public void test12() {
        LOG.debug("DEBUG - " + testMethod);
        LOG.info("INFO - " + testMethod);
        LOG.warn("WARN - " + testMethod);
        LOG.error("ERROR - " + testMethod);
    }

}
