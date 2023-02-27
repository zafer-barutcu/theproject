package elyt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.net.MalformedURLException;
import java.util.List;

public abstract class BasePage {

        public BasePage(){
            PageFactory.initElements(Driver.getDriver(), this);
        }


    @FindBy(xpath = "//strong[@class='text-white'][.='X']")
    public WebElement cookieXpath;

    @FindBy(css = ".btn.btn-cookie")
    public WebElement cookieCss;

    public By cookieBy=By.cssSelector(".btn.btn-cookie");

    @FindBy(linkText = "Home")
    public WebElement home;

    @FindBy(linkText = "Influencers")
    public WebElement influencers;

    @FindBy(linkText = "Explore")
    public WebElement explore;

    @FindBy(linkText = "Events")
    public WebElement events;

    @FindBy(xpath = "//div[@class='mx-2']/*[.='Connect']")
    public WebElement connect;

    @FindBy(xpath = "//span[.='Show more']")
    public WebElement showMore;

    @FindBy(xpath = "//span[.='Show less']")
    public WebElement showLess;

    @FindBy(xpath = "//div[@class='my-auto px-2'][.='Metamask']")
    public WebElement metamask;

    @FindBy(xpath = "//button[@aria-label='I ACCEPT' and @id='uc-btn-accept-banner']")
    public WebElement ersinCookie;

    @FindBy(xpath = "//*[.='ACCEPT ESSENTIAL COOKIES ONLY']")
    public WebElement ersinCookie2;

   @FindBy(xpath = "//button[@class='MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButtonBase-root GC-Button-root GC-Button-outlined GC-Button-dark Banner-login css-s537kj']")
   public WebElement ersinLoginButton;






}
