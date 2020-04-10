package com.mkyong.utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

import java.io.IOException;

public class ConfigureAppender {
    private static final Logger LOG = Logger.getLogger(ConfigureAppender.class);

    public static void configureFileAppender(String logFilename) {
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.DEBUG);

        PatternLayout layout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");

        try
        {
            RollingFileAppender fileAppender =
                    new RollingFileAppender(layout, System.getProperty("user.dir") + "/Log4j/"+ logFilename +".log");
            fileAppender.setMaxFileSize("5MB");
            fileAppender.setMaxBackupIndex(10);
            rootLogger.addAppender(fileAppender);
        }
        catch (IOException e)
        {
            LOG.error("Failed to add file appender " + logFilename);
        }

    }

}
