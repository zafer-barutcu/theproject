package elyt.step_definitions;

import elyt.pages.ErsinHome;
import elyt.pages.Home;
import elyt.pages.LoginSauce;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.ConfigReader;
import utils.Driver;


import static utils.BrowserUtils.verifyElementDisplayed;
import static utils.BrowserUtils.waitForClickablility;
import static utils.constants.*;

public class LoginStepDefinitions {
   LoginSauce loginSauce=new LoginSauce();
   ErsinHome ersinHome=new ErsinHome();

    @Then("user clicks on connect button")
    public void user_clicks_on_connect_button() {
        waitForClickablility(new Home().connect,10);
        new Home().connect.click();
    }

    @Then("clicks on show more button")
    public void clicksOnShowMoreButton() {
        waitForClickablility(new Home().connect,10);
        new Home().showMore.click();
    }

    @Then("clicks on show less button")
    public void clicksOnShowLessButton() {
        waitForClickablility(new Home().connect,10);
        new Home().showLess.click();
    }

    @When("clicks on Metamask option")
    public void clicksOnMetamaskOption() {
        new Home().metamask.click();
    }

    @Then("lands on metamask page")
    public void landsOnMetamaskPage() {
    }



    @Given("the user on login page")
    public void theUserOnLoginPage() {
        Driver.getDriver().get(ConfigReader.get("url"));
    }

    @Then("enters user name and password")
    public void entersUserNameAndPassword() {
        verifyElementDisplayed(loginSauce.userName);
        loginSauce.userName.sendKeys(USERNAME);
        loginSauce.password.sendKeys(PASSWORD);

    }

    @When("click on login button")
    public void clickOnLoginButton() {

        loginSauce.loginButton.click();
    }

    @Then("user lands on product page")
    public void userLandsOnProductPage() {
        Assert.assertEquals(Driver.getDriver().getTitle(),"Swag Labs");
    }

    @Given("the user in on the page")
    public void theUserInOnThePage() {
        Driver.getDriver().get(ConfigReader.get("urlersin"));

    }

    @Then("user accept cookies")
    public void userAcceptCookies() {
        verifyElementDisplayed(ersinHome.ersinCookie2);
        ersinHome.ersinCookie2.click();


    }

    @Then("user clicks login button")
    public void userClicksLoginButton() {
        verifyElementDisplayed(ersinHome.ersinLoginButton);
        ersinHome.ersinLoginButton.click();

    }

    @Then("enters username and password")
    public void entersUsernameAndPassword() {
        ersinHome.ersinUserName.sendKeys(ERSINUSERNAME);
        ersinHome.ersinPassword.sendKeys(ERSINPASSWORD);
        ersinHome.ersinLoginClick.click();
    }
}
