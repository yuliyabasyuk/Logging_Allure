package com.mkyong;

import com.mkyong.utils.TestListener;
import io.qameta.allure.*;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

@Listeners(TestListener.class)
@Epic("Regression Tests")
@Feature("Login Test")
public class LoginTest {
    final static Logger logger = Logger.getLogger(LoginTest.class);

    @Test (priority = 0, description="Invalid Login Scenario with wrong username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with wrong username and wrong password.")
    public void testLogger(){
        LoginTest obj = new LoginTest();
        obj.runMe("mkyong");

        login("testUser", "testPassword");
    }

    @Test
    public void oneMoreTest() {
        logger.info("Other test");
        byte[] biteArray;
        try {
            biteArray = FileUtils.readFileToByteArray(new File(System.getProperty("user.dir") + "/Log4j/oneMoreTest.log"));
        } catch (IOException ex){
            biteArray = null;
        }
        Allure.getLifecycle().addAttachment("Other Test logs", "text/plain", "log", biteArray);
    }

    private void runMe(String parameter){

        if(logger.isDebugEnabled()){
            logger.debug("This is debug : " + parameter);
        }

        if(logger.isInfoEnabled()){
            logger.info("This is info : " + parameter);
        }

        logger.warn("This is warn : " + parameter);
        logger.error("This is error : " + parameter);
        logger.fatal("This is fatal : " + parameter);
    }

    @Step("Login with username {0}, password {1}")
    public void login(String username, String password){
        logger.info("Log in as " + username);
        Assert.assertTrue(password.equals("1234"));
    }
}
