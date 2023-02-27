package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}

    private static final InheritableThreadLocal<WebDriver> driverPool=new InheritableThreadLocal<>();

    public static WebDriver getDriver() {

        if(driverPool.get()==null){

            String browser = System.getProperty("browser")!=null ? System.getProperty("browser") : ConfigReader.get("browser");

            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driverPool.set(new OperaDriver());
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac")){
                        throw new WebDriverException("Your OS doesn't support Safari");}
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driverPool.set(new SafariDriver());
                    break;
                case "remote-chrome1":
                    ChromeOptions chromeOptions=new ChromeOptions();
                    chromeOptions.setCapability("platform", Platform.ANY);
                    try{
                        driverPool.set(new RemoteWebDriver(new URL("https://oauth-barutcu.zaferr-966e0:9a666505-9cc3-45e4-beb3-37cda51d7b83@ondemand.eu-central-1.saucelabs.com:443/wd/hub"),chromeOptions));
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;
                case "remote-chrome2":
                    String gridAddress = "44.201.85.107";
                    try{
                        URL url=new URL("http://"+gridAddress+":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url,desiredCapabilities));
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;
                case "remote-chrome3":
                    ChromeOptions browserOptions = new ChromeOptions();
                    browserOptions.setCapability("platformName", "Windows 10");
                    browserOptions.setCapability("browserVersion", "latest");
                    Map<String, Object> sauceOptions = new HashMap<>();
                    sauceOptions.put("build", "<build id=363>");
                    sauceOptions.put("name", "<test name=BASIC TEST>");
                    browserOptions.setCapability("sauce:options", sauceOptions);
                    URL url=null;
                    try{
                        url = new URL("https://oauth-barutcu.zaferr-966e0:9a666505-9cc3-45e4-beb3-37cda51d7b83@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                        driverPool.set(new RemoteWebDriver(url,browserOptions));
                        RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;
            }
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
            }
        return driverPool.get();
        }



       public static void closeDriver(){
        if(driverPool.get()!=null){
            driverPool.get().quit();
            driverPool.remove();
        }
       }


}
