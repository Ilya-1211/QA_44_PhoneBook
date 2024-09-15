package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends ApplicationManager {

    @Test
    public void loginPositiveTest(){
        boolean result = new HomePage(getDriver()).clickBtnLoginHeder()
                .typeLoginForm("mio0931211@gmail.com","Ilya1983!")
                .clickBtnLoginPositive()
                .isElementContactPresent();
        Assert.assertTrue(result);

    }
}
