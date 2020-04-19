package com.mkyong.utils;

import org.apache.log4j.Logger;

public class KCOSUtils {
    final static Logger LOG = Logger.getLogger(KCOSUtils.class);

    public static void callGeneralMethod(Logger logger) {
        logger.info("Checking logger from src/main");
    }

    public static void callGeneralMethod1() {
        LOG.info("Checking logger from src/main");
    }

    public static void callGeneralMethod2() {
        LOG.debug("Checking logger from src/main");
    }
}
