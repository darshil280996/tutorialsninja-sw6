package pages;

import com.tutorialsninja.browserfactory.ManageBrowser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import utility.Utility;

public class AccountPage extends Utility {

    private static final Logger log = LogManager.getLogger(ManageBrowser.class);


    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement accountWelcomeText;

    public String getAccountWelcomeText(){
        log.info("account Welcome Text : " + accountWelcomeText.toString());
        return getTextFromElement(accountWelcomeText);
    }
}
