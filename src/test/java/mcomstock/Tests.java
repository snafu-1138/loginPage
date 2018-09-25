package mcomstock;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Tests {

    WebDriver driver;

    public LoginPage Login = new LoginPage(driver);
    public RegisterPage Register = new RegisterPage(driver);
    public GreetingsPage Greetings = new GreetingsPage(driver);

    public void loginBtnWait(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement loginBtn;
        loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("#app > div > div > div > div > div > form > div:nth-child(3) > button")));
        loginBtn.isDisplayed();
    }

    @BeforeMethod
    public void accountLoginURL(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get("https://react-redux-registration-login-example.stackblitz.io/login");
        Login = new LoginPage(driver);
        Register = new RegisterPage(driver);
        Greetings = new GreetingsPage(driver);
        loginBtnWait();
    }

    //The purpose of this test is to verify the Login Page
    @Test
    public void testLoginPage(){
        Login.loginTitle();
    }
    //The purpose of this test is to verify the Register button goes to the Register Page
    @Test
    public void testRegisterPage(){
        Login.loginPageRegisterBtn();
        Register.registerTitle();
    }
    //The purpose of this test is to verify the Username and Password fields are required fields
    @Test
    public void testLoginPageRequiredFields(){
        Login.loginBtn();
        Login.loginUsernameRequired();
        Login.loginPasswordRequired();
    }
    //The purpose of this test is to verify a user cannot login if they haven't registered
    @Test
    public void testLoginNotRegisteredUser() throws InterruptedException {
        String userName = "test";
        String passWord = "1234";
        Login.loginUsername(userName);
        Login.loginPassword(passWord);
        Login.loginBtn();
        Thread.sleep(1000);
        Login.badUsernamePassword();
    }
    //The purpose of this test is to verify I can register a new user
    @Test
    public void testRegisterPageNewUser(){
        String firstName = "tester";
        String lastName = "Person";
        String userName = "tester";
        String passWord = "password1";
        Login.loginPageRegisterBtn();
        Register.registerTitle();
        Register.registerFirstName(firstName);
        Register.registerLastName(lastName);
        Register.registerUsername(userName);
        Register.registerPassword(passWord);
        Register.registerBtn();
        loginBtnWait();
        Login.loginPageRegistrationSuccessMsg();
    }
    //The purpose of this test is to verify the Register a new user fields are required fields
    @Test
    public void testRegisterPageRequiredFields(){
        String firstName = "";
        String lastName = "";
        String userName = "";
        String passWord = "";
        Login.loginPageRegisterBtn();
        Register.registerTitle();
        Register.registerFirstName(firstName);
        Register.registerLastName(lastName);
        Register.registerUsername(userName);
        Register.registerPassword(passWord);
        Register.registerBtn();
        Register.registerFirstNameRequired();
        Register.registerLastNameRequired();
        Register.registerUsernameRequired();
        Register.registerPasswordRequired();
    }
    //The purpose of this test is to verify I can login in with a registered user
    @Test
    public void testLoginRegisteredUser() throws InterruptedException {
        testRegisterPageNewUser();
        String userName = "tester";
        String passWord = "password1";
        Login.loginUsername(userName);
        Login.loginPassword(passWord);
        Login.loginBtn();
        Thread.sleep(1000);
        String mainTitle = Greetings.greetingsMainTitle();
        assertEquals("Hi " + userName + "!", mainTitle);
        Greetings.greetingsSubTitle();
    }
    //The purpose of this test is to verify the name of the Registered user
    @Test
    public void testRegisterPageCheckUser() throws InterruptedException {
        String firstName = "tester";
        String lastName = "Person";
        String userName = "tester";
        String passWord = "password1";
        Login.loginPageRegisterBtn();
        Register.registerTitle();
        Register.registerFirstName(firstName);
        Register.registerLastName(lastName);
        Register.registerUsername(userName);
        Register.registerPassword(passWord);
        Register.registerBtn();
        loginBtnWait();
        Login.loginPageRegistrationSuccessMsg();
        Login.loginUsername(userName);
        Login.loginPassword(passWord);
        Login.loginBtn();
        Thread.sleep(1000);
        Greetings.greetingsAllUsersTitle();
        String name = Greetings.greetingsRegisteredUser();
        assertEquals(firstName + " " + lastName + " - Delete", name);
    }
    //The purpose of this test is to verify I can logout
    @Test
    public void testRegisteredUserLogout() throws InterruptedException {
        testLoginRegisteredUser();
        Greetings.greetingsLogoutBtn();
        Login.loginTitle();
    }
    //The purpose of this test is to verify I can delete a registered user
    @Test
    public void testRegisterPageDeleteUser() throws InterruptedException {
        testLoginRegisteredUser();
        Greetings.greetingsDeleteBtn();
        Greetings.greetingsLogoutBtn();
        String userName = "tester";
        String passWord = "password1";
        Login.loginUsername(userName);
        Login.loginPassword(passWord);
        Login.loginBtn();
        Thread.sleep(1000);
        Login.badUsernamePassword();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}