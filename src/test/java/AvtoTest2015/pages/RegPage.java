package AvtoTest2015.pages;


import AvtoTest2015.util.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Random;

/**
 * Created by leoni on 20.12.2015.
 */
public class RegPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private static Random rnd = new Random();

    @FindBy(xpath = "//*[@id='register-firstname']")
    WebElement firstName;

    @FindBy(xpath = "//*[@id='register-lastname']")
    WebElement lastName;

    @FindBy(xpath = "//*[@id='register-email']")
    WebElement setemail;

    @FindBy(xpath = "//*[@id='register-password']")
    WebElement password1;

    @FindBy(xpath = "//*[@id='register-password-verify']")
    WebElement password2;

    @FindBy(xpath = "//*[@class='switch switch-primary']")
    WebElement switchBut;

    @FindBy(xpath = "//*[@class='btn btn-sm btn-success']")
    WebElement regBut;

    @FindBy(xpath = "//*[contains(text(), 'обучающий автопортал')]")
    WebElement acceptField;

    //exists for negative tests

    @FindBy(xpath = "//*[contains(text(), 'Имя обязательно')]")
    WebElement nameAlert;

    @FindBy(xpath = "//*[contains(text(),'Фамилия обязательна')]")
    WebElement surenameAlert;

    @FindBy(xpath = "//*[contains(text(),'Email обязателен')]")
    WebElement emailAlert;

    @FindBy(xpath = "//*[contains(text(),'Пароль обязателен')]")
    WebElement password1Alert;

    @FindBy(xpath = "//*[contains(text(),'Подтвердите пароль')]")
    WebElement password2Alert;

    @FindBy(xpath = "//*[contains(text(),'Примите пользовательское соглашение!')]")
    WebElement registerTermsAlert;

    //Exit buttom

    @FindBy(xpath = "//*[@class='nav-user']//*[contains(text(),'Выйти')]")
    WebElement exitButtom;


    public RegPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = baseUrl+ "/login#register";
        PageFactory.initElements(driver, this);
    }

    public RegPage openLoginPage(WebDriver driver) {
        Log.info("Opening Login page");
        driver.get(PAGE_URL);
        return this;
    }


    public RegPage addFirstName(String name) {
        Log.info("First name was added");
        setElementText(firstName, name);
        return this;
    }

    public RegPage addLastName(String lastname) {
        Log.info("Last name was added");
        setElementText(lastName, lastname);
        return this;
    }

    public RegPage addEmail(String email) {
        Log.info("Email was added");
        setElementText(setemail, email);
        return this;
    }

    public RegPage addPasswords(String pass) {
        Log.info("Passwords was added");
        setElementText(password1, pass);
        setElementText(password2, pass);
        return this;
    }

    public void checkSwitchButt() {
        Log.info("Switch buttom was pushed");
        clickElement(switchBut);
    }

    public void checkAddButt() {
        Log.info("Add buttom was pushed");
        clickElement(regBut);
    }

        //METHODS
    public String generateUsername() { //Генератор Имени Юзера
        String rand = getRandomString(3);
        String username = "UserFirst"+rand;
        Log.info("User first name generated is <" + username + ">");
        return username;
    }

    public String generateUsersurename() { //Генератор Фамилии Юзера
        String rand = getRandomString(3);
        String username = "UserLast"+rand;
        Log.info("User second name generated is <" + username + ">");
        return username;
    }
    private static String getRandomString(final int length) { //Генератор набора букв
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder buf = new StringBuilder();
        for (int i=0; i<length; i++) {
            buf.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return buf.toString();
    }

    public String generateEmail() { //Генератор email
        Random rn = new Random();
        int num = rn.nextInt(1000) + 1;
        String Email = "user" + num + "@yopmail.com";
        Log.info("UserEmail generated is <" + Email + ">");
        return Email;
    }

    public String generatePassword() { //Генератор паролей
        String rand = getRandomString(3);
        String username = "PassWord"+rand;
        Log.info("User second name generated is <" + username + ">");
        return username;
    }

    public RegPage waitUntilPageIsLoaded() throws IOException, InterruptedException {
        waitUntilElementIsLoaded(regBut);
        return this;
    }

    public boolean inTableFrame() throws IOException, InterruptedException {
        waitUntilElementIsLoaded(acceptField);
        return exists(acceptField);
    }

    public void clickExit() {
        Log.info("Exit buttom was pushed");
        clickElement(exitButtom);
    }

    //Negative alerts

    public boolean noName() throws IOException, InterruptedException {
        return exists(nameAlert);
    }

    public boolean noSurename(){
        return exists(surenameAlert);
    }

    public boolean noEmail(){
        return exists(emailAlert);
    }

    public boolean noPassword1(){
        return exists(password1Alert);
    }

    public boolean noPassword2(){
        return exists(password2Alert);
    }

    public boolean noTerms(){
        return exists(registerTermsAlert);
    }
}
