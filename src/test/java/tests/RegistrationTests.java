package tests;

import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.TestNGListener;

import static utils.RandomUtils.generateEmail;
import static utils.RandomUtils.generateString;

@Listeners(TestNGListener.class)

public class RegistrationTests extends ApplicationManager {

    @Test
    public void registrationPositiveTestPositive(){
        Assert.assertTrue(new HomePage(getDriver()).clickBtnLoginHeder()
                .typeLoginForm("my_qa_email0102@mail.com", "Password123_!")
                .clickBtnRegistrationPositive()
                .isElementContactPresent());

    }

    @Test
    public void registrationNegativeWrongEmail(){
        String email = generateString(10);
        UserDto user = new UserDto(email,"Qwer431!");
        new HomePage(getDriver()).clickBtnLoginHeder()
                .typeLoginForm(user)
                .clickBtnRegistrationNegative()
                .closeAllert()
                .isTextElementPresent_errorMessage("Registration failed with code 400");

    }
}
