package elyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginSauce extends BasePage{

    @FindBy(xpath = "//input[@placeholder='Username' and @name='user-name']")
    public WebElement userName;

    @FindBy(xpath = "//input[@placeholder='Password' and @name='password']")
    public WebElement password;

    @FindBy(css = "#login-button")
    public WebElement loginButton;


}
