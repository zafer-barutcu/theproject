package elyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class kloia extends BasePage{


     @FindBy(xpath = "(//*[.='Work e-mail'])[2]/following-sibling::*")
     public WebElement inputBox;

     @FindBy(xpath = "(//div[@class='actions'])[2]/span")
     public WebElement subscribeButton;

     private void fillOutSubscribeMailBox(WebElement inputBox,String emailForSubscribe){
         this.inputBox=inputBox;
         inputBox.sendKeys(emailForSubscribe);
     }

     private void clickOnSubscribeButton(WebElement subscribeButton){
         this.subscribeButton=subscribeButton;
         subscribeButton.click();
     }
     public void fillOutEmailForSubscribeAndClick(WebElement subscribeMailInputBox,String emailForSubscribe,WebElement subscribeMailClickButton){
         fillOutSubscribeMailBox(subscribeMailInputBox,emailForSubscribe);
         clickOnSubscribeButton(subscribeMailClickButton);


     }


}
