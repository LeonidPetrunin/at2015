package AvtoTest2015;


import AvtoTest2015.util.PropertyLoader;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {
  public static String baseUrl;
  protected static Capabilities capabilities;
  protected static String gridHubUrl;
  public static WebDriver driver;

  @BeforeSuite
  public void initTestSuite() throws IOException {
    System.out.println("We are in TestNgTestBase initTestSuite BeforeSuite");
    baseUrl = PropertyLoader.loadProperty("site.url");
    capabilities = PropertyLoader.loadCapabilities();
    //WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
    driver = new FirefoxDriver();
  }


  public WebDriver getDriver() {
    return driver;
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    System.out.println("We are in TestNgTestBase tearDown AfterClass");
    if (driver != null) {
      driver.quit();
    }
  }
}
