package AvtoTest2015;


import AvtoTest2015.pages.DataProviders;
import AvtoTest2015.pages.RegPage;
import AvtoTest2015.util.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by leoni on 20.12.2015.
 */

//@org.testng.annotations.Listeners(FailTestScreenshotListener.class)
public class AvtoTestNegative extends TestNgTestBase{
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    public RegPage regPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        Log.info("Negative AutoTests started . . .");
        regPage= PageFactory.initElements(driver, RegPage.class);
        Log.info("Open driverPage!");
        regPage.openLoginPage(driver);

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp(){
        driver.manage().window().maximize();

    }

    @Test(groups = {"smoke", "negative"},dataProviderClass = DataProviders.class, dataProvider = "loadInvalidLoginFromFile")
     public void NegativeTestsWithoutElements(String first, String second, String email, String pass) throws IOException, InterruptedException {
        Log.info("DriverPage was opened. Start TestMethods!");
        regPage.waitUntilPageIsLoaded();
        regPage
                .addFirstName(first)
                .addLastName(second)
                .addEmail(email)
                .addPasswords(pass);
        regPage.clickSwitchButt();
        regPage.checkAddButt();
        //Assert.assertTrue(regPage.inTableFrame(), "Registered not success!");
        Log.info("Registered not success!");
        driver.navigate().refresh(); //Команда обновляет страницу после каждого теста!
    }
/*

    @Test(groups = {"negative"})
    public void FieldPageElementsWithoutLastName() throws InterruptedException, IOException {
        regPage.openLoginPage(driver);
        regPage.waitUntilPageIsLoaded();
        regPage
                .addFirstName()
                .addEmail()
                .addPasswords();
        regPage.checkSwitchButt();
        regPage.checkAddButt();
        Assert.assertTrue(regPage.noSurename(), "LastName was inscribed!");
        Log.info("LastName wasn't inscribed!");
    }

    @Test(groups = {"negative"})
    public void FieldPageElementsWithoutEmail() throws InterruptedException, IOException {
        regPage.openLoginPage(driver);
        regPage.waitUntilPageIsLoaded();
        regPage
                .addFirstName()
                .addLastName()
                .addPasswords();
        regPage.checkSwitchButt();
        regPage.checkAddButt();
        Assert.assertTrue(regPage.noEmail(), "Email was inscribed!");
        Log.info("Email wasn't inscribed!");
    }

    @Test(groups = {"negative"})
    public void FieldPageElementsWithoutPasswords() throws InterruptedException, IOException {
        regPage.openLoginPage(driver);
        regPage.waitUntilPageIsLoaded();
        regPage
                .addFirstName()
                .addLastName()
                .addEmail();
        regPage.checkSwitchButt();
        regPage.checkAddButt();
        Assert.assertTrue(regPage.noPassword1() && regPage.noPassword2(), "Passwords was inscribed!");
        Log.info("Passwords wasn't inscribed!");
    }

    @Test(groups = {"negative"})
    public void FieldPageElementsWithoutTerms() throws InterruptedException, IOException {
        regPage.openLoginPage(driver);
        regPage.waitUntilPageIsLoaded();
        regPage
                .addFirstName()
                .addLastName()
                .addEmail()
                .addPasswords();
        regPage.checkAddButt();
        Assert.assertTrue(regPage.noTerms(), "Terms was inscribed!");
        Log.info("Terms wasn't inscribed!");
    }


*/


   /* @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }*/
}
