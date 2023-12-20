package pages;

import com.tutorialsninja.browserfactory.ManageBrowser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import utility.Utility;

public class LoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement loginWelcomeText;

    @CacheLookup
    @FindBy(name = "email")
    WebElement emailField;

    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginBtn;

    public String getLoginWelcomeText(){
        log.info("Login Welcome Text: " + loginWelcomeText.toString());
        return getTextFromElement(loginWelcomeText);
    }
    public void enterEmail(String email){
        sendTextToElement(emailField,email);
        log.info("Enter Email : " + emailField.toString());
    }

    public void enterPassword(String password){
        sendTextToElement(passwordField,password);
        log.info("CEnter Password : " + passwordField.toString());

    }

    public void clickOnLoginBtn(){
        clickOnElement(loginBtn);
        log.info("Clicking on login button : " + loginBtn.toString());
    }
}
