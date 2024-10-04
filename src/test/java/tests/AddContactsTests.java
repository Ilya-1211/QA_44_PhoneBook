package tests;

import dto.ContactDtoLombok;
import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddPage;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;
import utils.HeaderMenuItem;

import static pages.LoginPage.clickButtonOnHeader;
import static utils.RandomUtils.*;

public class AddContactsTests extends ApplicationManager {

    UserDto user = new UserDto("mio0931211@gmail.com","Ilya1983!");
    AddPage addPage;

    @BeforeMethod
    public void login(){
        new HomePage(getDriver());
        LoginPage loginPage = clickButtonOnHeader(HeaderMenuItem.LOGIN);
        loginPage.typeLoginForm(user).clickBtnLoginPositive();
        addPage = clickButtonOnHeader(HeaderMenuItem.ADD);

    }

    @Test
    public void addNewContactPositiveTest(){
        ContactDtoLombok contact = ContactDtoLombok.builder()
                .name(generateString(5))
                .lastname(generateString(10))
                .phone(generatePhone(10))
                .email(generateEmail(12))
                .address(generateString(20))
                .description(generateString(10))
                .build();
        Assert.assertTrue(addPage.fillContactForm(contact).clickBtnSaveContactPositive()
                .isLastPhoneEquals(contact.getPhone()));


    }
}
