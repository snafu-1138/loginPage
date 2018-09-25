package mcomstock;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.assertEquals;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //Login Page Elements

    //Login Main Title
    @FindBy(css = "#app > div > div > div > div > div > h2")
    public WebElement loginMainTitle;
    //Username Field
    @FindBy(css = "#app > div > div > div > div > div > form > div:nth-child(1) > input")
    public WebElement loginUsernameField;
    //Error Message 'Username is required'
    @FindBy(css = "#app > div > div > div > div > div > form > div:nth-child(1) > div")
    public WebElement loginErrorUsernameRequired;
    //Password Field
    @FindBy(css = "#app > div > div > div > div > div > form > div:nth-child(2) > input")
    public WebElement loginPasswordField;
    //Error Message 'Password is required'
    @FindBy(css = "#app > div > div > div > div > div > form > div:nth-child(2) > div")
    public WebElement loginErrorPasswordRequired;
    //Login Button
    @FindBy(css = "#app > div > div > div > div > div > form > div:nth-child(3) > button")
    public WebElement loginLoginBtn;
    //Bad Username or Password message
    @FindBy(css = "#app > div > div > div > div.alert.alert-danger")
    public WebElement loginErrorUsernameOrPassword;
    //Register Button
    @FindBy(css = "#app > div > div > div > div > div > form > div:nth-child(3) > a")
    public WebElement loginRegisterBtn;
    //Registration Successful message
    @FindBy(css = "#app > div > div > div > div.alert.alert-success")
    public WebElement loginRegistrationSuccess;

    //Login Page Methods

    //Login Main Title
    public void loginTitle(){
        String loginTitle = loginMainTitle.getText();
        assertEquals("Login", loginTitle);
    }
    //Username Field
    public void loginUsername(String userName){
        loginUsernameField.sendKeys(userName);
    }
    //Error Message 'Username is required'
    public void loginUsernameRequired(){
        String usernameRequired = loginErrorUsernameRequired.getText();
        assertEquals("Username is required", usernameRequired);
    }
    //Password Field
    public void loginPassword(String passWord){
        loginPasswordField.sendKeys(passWord);
    }
    //Error Message 'Password is required'
    public void loginPasswordRequired(){
        String passwordRequired = loginErrorPasswordRequired.getText();
        assertEquals("Password is required", passwordRequired);
    }
    //Login Button
    public void loginBtn(){
        loginLoginBtn.click();
    }
    //Bad Username or Password message
    public void badUsernamePassword(){
        String badUsernameOrPassword = loginErrorUsernameOrPassword.getText();
        assertEquals("Username or password is incorrect", badUsernameOrPassword);
    }
    //Register Button
    public void loginPageRegisterBtn(){
        loginRegisterBtn.click();
    }
    //Registration Successful Message
    public void loginPageRegistrationSuccessMsg(){
        String registrationSuccess = loginRegistrationSuccess.getText();
        assertEquals("Registration successful", registrationSuccess);
    }
}