package tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import util.DriverFactory;


import static util.DriverFactory.BrowserType.CHROME;
import static util.DriverFactory.BrowserType.FIREFOX;

public class FirstTest {
    private WebDriver driver;

    @Test
    public void setupChrome(){
        driver = DriverFactory.getDriver(CHROME);
        driver.navigate().to("https://www.google.com.ua");
        DriverFactory.quitAndClean();
    }

    @Test
    public void setupFirefox(){
        driver = DriverFactory.getDriver(FIREFOX);
        driver.navigate().to("https://www.google.com.ua");
        DriverFactory.quitAndClean();
    }

}
