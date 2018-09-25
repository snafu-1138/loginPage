package mcomstock;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.assertEquals;

public class RegisterPage {

    public RegisterPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //Register New User Page Elements
    //Register Title
    @FindBy(css = "#app > div > div > div > div > div > h2")
    public WebElement registerMainTitle;
    //New User First Name Field
    @FindBy(css = "#app > div > div > div > div > div > form > div:nth-child(1) > input")
    public WebElement registerFirstNameField;
    //New User First Name Required
    @FindBy(css = "#app > div > div > div > div > div > form > div:nth-child(1) > div")
    public WebElement registerFNameRequired;
    //New User Last Name Field
    @FindBy(css = "#app > div > div > div > div > div > form > div:nth-child(2) > input")
    public WebElement registerLastNameField;
    //New User Last Name Required
    @FindBy(css = "#app > div > div > div > div > div > form > div:nth-child(2) > div")
    public WebElement registerLNameRequired;
    //New User Username Field
    @FindBy(css = "#app > div > div > div > div > div > form > div:nth-child(3) > input")
    public WebElement registerUsernameField;
    //New User Username Required
    @FindBy(css = "#app > div > div > div > div > div > form > div:nth-child(3) > div")
    public WebElement registerUNameRequired;
    //New User Password Field
    @FindBy(css = "#app > div > div > div > div > div > form > div:nth-child(4) > input")
    public WebElement registerPasswordField;
    //New User Password Required
    @FindBy(css = "#app > div > div > div > div > div > form > div:nth-child(4) > div")
    public WebElement registerPWordRequired;
    //New User Register Button
    @FindBy(css = "#app > div > div > div > div > div > form > div:nth-child(5) > button")
    public WebElement registerRegisterBtn;
    //New User Cancel Button
    @FindBy(css = "#app > div > div > div > div > div > form > div:nth-child(5) > a")
    public WebElement registerCancelBtn;

    //Register New User Page Methods

    //Register Title
    public void registerTitle(){
        String registerTitle = registerMainTitle.getText();
        assertEquals("Register", registerTitle);
    }
    //New User First Name
    public void registerFirstName(String firstName){
        registerFirstNameField.sendKeys(firstName);
    }
    //New User First Name Required
    public void registerFirstNameRequired(){
        String firstNameRequired = registerFNameRequired.getText();
        assertEquals("First Name is required", firstNameRequired);
    }
    //New User Last Name
    public void registerLastName(String lastName){
        registerLastNameField.sendKeys(lastName);
    }
    //New User Last Name Required
    public void registerLastNameRequired(){
        String lastNameRequired = registerLNameRequired.getText();
        assertEquals("Last Name is required", lastNameRequired);
    }
    //New User Username
    public void registerUsername(String userName){
        registerUsernameField.sendKeys(userName);
    }
    //New User Username Required
    public void registerUsernameRequired(){
        String usernameRequired = registerUNameRequired.getText();
        assertEquals("Username is required", usernameRequired);
    }
    //New User Password
    public void registerPassword(String passWord){
        registerPasswordField.sendKeys(passWord);
    }
    //New User Password Required
    public void registerPasswordRequired(){
        String passwordRequired = registerPWordRequired.getText();
        assertEquals("Password is required", passwordRequired);
    }
    //New User Register Button
    public void registerBtn(){
        registerRegisterBtn.click();
    }
    //New User Cancel Button
    public void cancelBtn(){
        registerCancelBtn.click();
    }
}