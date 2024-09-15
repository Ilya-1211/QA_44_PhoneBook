package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class RegistrationTests extends ApplicationManager {

    @Test
    public void registrationPositiveTestPositive(){
        Assert.assertTrue(new HomePage(getDriver()).clickBtnLoginHeder()
                .typeLoginForm("my_qa_email0101@mail.com", "Password123_!")
                .clickBtnRegistrationPositive()
                .isElementContactPresent());

    }
}
