package util;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;
    private static BrowserType type;

    private static final long DEFAULT_TIMEOUT = 2;


    public enum BrowserType{CHROME, FIREFOX, SAFARI}

    public static WebDriver getDriver(BrowserType type){
        if(driver == null){
            setup(type);
        }
        if(type != null && DriverFactory.type != type && driver != null){
            quitAndClean();
            setup(type);
        }

        setImplicitWait();
        driver.manage().timeouts().pageLoadTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        return driver;
    }

    private static void setup(BrowserType type){
        DriverFactory.type = type;

        switch (type){
            case CHROME:
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
                break;
            default:
                Assert.fail("FAILED: Unknown web driver type <" + type.toString() + ">");
        }

    }

    private static void setImplicitWait(){
        setCustomWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    private static void setCustomWait(long l, TimeUnit timeUnit){
        driver.manage().timeouts().implicitlyWait(l, timeUnit);
    }



    public static void quitAndClean(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
