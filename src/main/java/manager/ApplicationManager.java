package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.WDListener;

public class ApplicationManager {

    private WebDriver driver;
    public WebDriver getDriver(){
        return driver;
    }

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);


    @BeforeMethod
    public void setUp(){
 //       logger.info("start testing ====================");
        driver = new ChromeDriver();

        WebDriverListener webDriverListener = new WDListener();
        driver =  new EventFiringDecorator<>(webDriverListener).decorate(driver);

        driver.manage().window().maximize();
    }



    @AfterMethod
    public void tearDown(){
 //       logger.info("stop testing ====================");
//        if (driver != null){
//            driver.quit();
//        }
    }
}
