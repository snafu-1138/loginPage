package mcomstock;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.assertEquals;

public class GreetingsPage {

    public GreetingsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //Greetings Page Elements
    //Greetings Main Title
    @FindBy(css = "#app > div > div > div > div > div > h1")
    public WebElement greetingsMainTitle;
    //Greetings Sub Title
    @FindBy(css = "#app > div > div > div > div > div > p:nth-child(2)")
    public WebElement greetingsSubTitle;
    //All Registered Users Title
    @FindBy(css = "#app > div > div > div > div > div > h3")
    public WebElement greetingsAllUsersTitle;
    //All Registered Users
    @FindBy(css = "#app > div > div > div > div > div > ul > li:nth-child(1)")
    public WebElement greetingsRegisteredUsers;
    //All Registered Users Delete Button
    @FindBy(css = "#app > div > div > div > div > div > ul > li > span > a")
    public WebElement greetingsDeleteUsersBtn;
    //Greetings Logout Button
    @FindBy(css = "#app > div > div > div > div > div > p:nth-child(5) > a")
    public WebElement greetingsLogoutBtn;

    //Greetings Page Methods
    //Greetings Main Title
    public String greetingsMainTitle(){
        return greetingsMainTitle.getText();
    }
    //Greetings Sub Title
    public void greetingsSubTitle(){
        String greetingsSecondTitle = greetingsSubTitle.getText();
        assertEquals("You're logged in with React!!", greetingsSecondTitle);
    }
    //All Registered Users Title
    public void greetingsAllUsersTitle(){
        String greetingsAllUsers = greetingsAllUsersTitle.getText();
        assertEquals("All registered users:", greetingsAllUsers);
    }
    //All Registered Users
    public String greetingsRegisteredUser(){
        return greetingsRegisteredUsers.getText();
    }
    //All Registered Users Delete Button
    public void greetingsDeleteBtn(){
        greetingsDeleteUsersBtn.click();
    }
    //Greetings Logout Button
    public void greetingsLogoutBtn(){
        greetingsLogoutBtn.click();
    }
}