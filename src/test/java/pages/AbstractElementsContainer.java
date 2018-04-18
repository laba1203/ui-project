package pages;

import org.openqa.selenium.WebDriver;
import util.DriverFactory;

import static util.DriverFactory.BrowserType.CHROME;

public class AbstractElementsContainer {
    protected WebDriver driver = DriverFactory.getDriver(CHROME);


}
