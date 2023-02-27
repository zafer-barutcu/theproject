package elyt.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigReader;
import utils.Driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static utils.DbUtils.createConnection;
import static utils.DbUtils.getRowCount;
import static utils.constants.*;

public class Hooks {




    @After
    public void teardownScenario(Scenario scenario){
        System.out.println("This is the end of test execution");
        if(scenario.isFailed()){
            final byte[] screenShot= ((TakesScreenshot)  Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot,"image/png","screenshot");
        }

       //Driver.closeDriver();
    }


    }

