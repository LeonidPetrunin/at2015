package AvtoTest2015;


import AvtoTest2015.pages.RegPage;
import AvtoTest2015.util.LogLog4j;
import com.github.yev.FailTestScreenshotListener;
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

@org.testng.annotations.Listeners(FailTestScreenshotListener.class)
public class AvtoTestPositive extends TestNgTestBase{
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    public RegPage regPage;
    public static String firstName;
    public static String lastName;
    public static String email;
    public static String pass;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        regPage= PageFactory.initElements(driver, RegPage.class);
        regPage.openLoginPage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp(){
       driver.manage().window().maximize();
        firstName=regPage.generateUsername();
        lastName=regPage.generateUsersurename();
        email=regPage.generateEmail();
        pass=regPage.generatePassword();

    }

    @Test(groups = {"smoke", "positive"})
    public void FieldPageElements() throws InterruptedException, IOException {
        regPage.waitUntilPageIsLoaded();
        regPage
                .addFirstName(firstName)
                .addLastName(lastName)
                .addEmail(email)
                .addPasswords(pass);
        regPage.checkSwitchButt();
        regPage.checkAddButt();
        Assert.assertTrue(regPage.inTableFrame(), "Registration wasn't compleated!");
        regPage.clickExit();
        Log.info("Registration was compleated!");
    }



   /* @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }*/
}
