package elyt.step_definitions;

import elyt.pages.BasePage;
import elyt.pages.Home;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.Driver;

import static org.junit.Assert.assertTrue;
import static utils.BrowserUtils.verifyElementDisplayed;
import static utils.BrowserUtils.waitForClickablility;

public class BasicStepDefinitions {

    Home home=new Home();
    @Given("the user navigates to elyt website")
    public void the_user_navigates_to_website(){
        Driver.getDriver().get(ConfigReader.get("dev"));
        System.out.println("navigates to web site/");
    }

    @Then("user clicks on cookies popup")
    public void user_clicks_on_cookies_popup() {
        waitForClickablility(home.cookieBy);
        home.cookieCss.click();
    }

    @When("user clicks {string}")
    public void userClicks(String headers) {

        switch (headers){
            case "influencers":
                verifyElementDisplayed(home.influencers);
                home.influencers.click();
                break;
            case "explore":
                verifyElementDisplayed(home.explore);
                home.explore.click();
                break;
            case "events":
                verifyElementDisplayed(home.events);
                home.events.click();
                break;
        }

    }
    @Then("user verifies that landed on {string} page")
    public void userVerifiesThatLandedOnPage(String headers) throws InterruptedException {

        System.out.println("Actual Title is "+Driver.getDriver().getTitle().toLowerCase());
        assertTrue(Driver.getDriver().getTitle().toLowerCase().contains(headers));
    }





}




