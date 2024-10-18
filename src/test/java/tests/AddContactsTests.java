package tests;

import data_providre.DPAddContact;
import dto.ContactDtoLombok;
import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AddPage;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;
import utils.HeaderMenuItem;
import utils.TestNGListener;

import static pages.LoginPage.clickButtonOnHeader;
import static utils.RandomUtils.*;

@Listeners(TestNGListener.class)

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

    @Test
    public void addNewContactNegativeTest_nameIsEmpty(){
        ContactDtoLombok contact = ContactDtoLombok.builder()
                .name("")
                .lastname(generateString(10))
                .phone(generatePhone(10))
                .email(generateEmail(12))
                .address(generateString(20))
                .description(generateString(10))
                .build();
        Assert.assertTrue(addPage.fillContactForm(contact)
                .clickBtnSaveContactPositive()
                .urlContainsAdd())
               ;

    }

    @Test
    public void addNewContactNegativeTest_wrongEmail(){
        ContactDtoLombok contact = ContactDtoLombok.builder()
                .name(generateString(4))
                .lastname(generateString(10))
                .phone(generatePhone(10))
                .email(generateString(12))
                .address(generateString(20))
                .description(generateString(10))
                .build();
        Assert.assertTrue(addPage.fillContactForm(contact)
                .clickBtnSaveContactPositive()
                .isAlertPresent(5))
        ;
    }

    @Test(dataProvider = "addNewContactDP",dataProviderClass = DPAddContact.class)
    public void addNewContactNegativeTest_wrongEmailDP(ContactDtoLombok contact){
        System.out.println("--->"+contact);
        Assert.assertTrue(addPage.fillContactForm(contact)
                .clickBtnSaveContactPositive()
                .isAlertPresent(5))
        ;
    }

    @Test(dataProvider = "addNewContactDPFile",dataProviderClass = DPAddContact.class)
    public void addNewContactNegativeTest_wrongEmailDPFile(ContactDtoLombok contact){
        System.out.println("--->"+contact);
        Assert.assertTrue(addPage.fillContactForm(contact)
                .clickBtnSaveContactPositive()
                .isAlertPresent(5))
        ;
    }
}
