package com.mkyong;

import com.mkyong.utils.TestListener;
import io.qameta.allure.*;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
