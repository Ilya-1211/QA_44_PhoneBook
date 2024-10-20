package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        setDriver(driver);
        driver.get("https://telranedu.web.app/home");
        logger.info("URL  ------> "+driver.getCurrentUrl());
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath ="//a[text()='LOGIN']")
    WebElement btnLogin;

    public LoginPage clickBtnLoginHeder(){
        btnLogin.click();
        return new LoginPage(driver);
    }

}
