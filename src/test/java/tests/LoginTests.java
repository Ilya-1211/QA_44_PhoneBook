package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.TestNGListener;

@Listeners(TestNGListener.class)

public class LoginTests extends ApplicationManager {

    @Test
    public void loginPositiveTest(){
        boolean result = new HomePage(getDriver()).clickBtnLoginHeder()
                .typeLoginForm("mio0931212@gmail.com","Ilya1983!")
                .clickBtnLoginPositive()
                .isElementContactPresent();
        Assert.assertTrue(result);

    }

    @Test
    public void loginNegativeTest_wrongPassword(){
        Assert.assertTrue(new HomePage(getDriver()).clickBtnLoginHeder()
                .typeLoginForm("mio0931212@gmail.com","Ilya1983!---")
                .clickBtnLoginNegative().closeAllert()
                .isTextElementPresent_errorMessage());
    }

        @Test
        public void loginNegativeTest_wrongEmailUnregemail() {
            Assert.assertTrue(new HomePage(getDriver()).clickBtnLoginHeder()
                    .typeLoginForm("qa_W@gmail.com", "Qwer431!")
                    .clickBtnLoginNegative().closeAllert()
                    .isTextElementPresent_errorMessage());
    }

    @Test
    public void loginNegativeTest_wrongEmailWOAt() {
        Assert.assertTrue(new HomePage(getDriver()).clickBtnLoginHeder()
                .typeLoginForm("qa_Wgmail.com", "Qwer431!")
                .clickBtnLoginNegative().closeAllert()
                .isTextElementPresent_errorMessage());
    }
}
