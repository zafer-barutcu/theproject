package elyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ErsinHome extends BasePage {

    @FindBy(css = "#signInName")
    public WebElement ersinUserName;

    @FindBy(xpath = "//input[@id='password' and @type='password']")
    public WebElement ersinPassword;

    @FindBy(xpath = "//button[@id='continue' and @type='submit']")
    public WebElement ersinLoginClick;

}
