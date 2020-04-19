package com.mkyong.utils;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigureAppender {
    private static final Logger LOG = Logger.getLogger(ConfigureAppender.class);
    private static String fileAppenderName = "file";

    public static Logger configureLogger(String testMethod) {
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.DEBUG);
        PatternLayout layout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");

        Logger logger = Logger.getLogger(testMethod);
        String filePath = getLogfilePath(testMethod);
        try {
            Files.deleteIfExists(Paths.get(filePath));
            RollingFileAppender fileAppender = new RollingFileAppender(layout, filePath);
            fileAppender.setName(fileAppenderName);
            logger.addAppender(fileAppender);
        } catch (IOException e) {
            logger.error("Failed to add file appender " + filePath);
        }

        return logger;
    }

    public static void configureLogger1(String testMethod) {
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.DEBUG);
        PatternLayout layout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");

        String filePath = getLogfilePath(testMethod);
        try {
            //todo: check System.getProperty("user.dir") in qa module
            Files.deleteIfExists(Paths.get(filePath));
            rootLogger.removeAppender(fileAppenderName);
            RollingFileAppender fileAppender = new RollingFileAppender(layout, filePath);
            fileAppender.setName(fileAppenderName);
            rootLogger.addAppender(fileAppender);
        } catch (IOException e) {
            rootLogger.error("Failed to add file appender " + filePath);
        }
    }

    public static void configureFileAppender(String filePath) {
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.DEBUG);

        PatternLayout layout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");

        try {
            //todo: check System.getProperty("user.dir") in qa module
            Files.deleteIfExists(Paths.get(filePath));
            RollingFileAppender fileAppender = new RollingFileAppender(layout, filePath);
            fileAppender.setName(fileAppenderName);
            rootLogger.addAppender(fileAppender);
        } catch (IOException e) {
            LOG.error("Failed to add file appender " + filePath);
        }
    }

    public static void addAllureFileAttachment(String testMethod) {
        String filePath = getLogfilePath(testMethod);
        byte[] content = new byte[0];
        try {
            content = FileUtils.readFileToByteArray(new File(filePath));
        } catch (IOException ex){
            LOG.error("Failed to read file " + filePath);
        }
        Allure.getLifecycle().addAttachment(testMethod, "text/plain", "log", content);
    }

    private static String getLogfilePath (String logfileName) {
        return System.getProperty("user.dir") + "/Log4j/" + logfileName + ".log";
    }
}
