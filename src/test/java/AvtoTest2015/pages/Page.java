package AvtoTest2015.pages;


import AvtoTest2015.TestNgTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  public static String baseUrl = TestNgTestBase.baseUrl;
  public String PAGE_URL;
  public String PAGE_TITLE;
  public WebDriver driver;
  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public void loadPage() {
    driver.get(getPageUrl());
//  Assert.assertEquals(getTitle(), getPageTitle());
  }

  public String getPageUrl() {

    return PAGE_URL;
  }


  public void setElementText(WebElement element, String text) { //Метод позволяет установить значение String в конкретный элемент
    element.click();
    element.clear();
    //Log.info("entering text '" + text + "' into element " + element);
    element.sendKeys(text);
    // Assert.assertEquals(element.getAttribute("value"), text);
  }

  public void clickElement(WebElement element) { //Метод нажатия на эллемент
    // Log.info("clicking on element " + element + "");
    element.click();
  }

  public void waitUntilElementIsLoaded(WebElement element) throws IOException, InterruptedException { //Позволяет дождаться элемент
    new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
  }

  public boolean exists(WebElement element) { // Проверка наличия элемента на странице
    try {
      return element.isDisplayed();
    } catch (org.openqa.selenium.NoSuchElementException ignored) {
      return false;
    }
  }
}
