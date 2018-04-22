package util;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Listener extends AbstractWebDriverEventListener{

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("LOG: Element was found. Locator: " + by);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("LOG: Clicked to element: " + element.toString());
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("LOG: Value changed to <" + Arrays.toString(keysToSend) + "> for element: " + element.toString());
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        System.err.println("FAILED: " + throwable.getMessage());

        File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String path = "src/test/out/" + System.currentTimeMillis()+ "screen.png";
            Files.copy(tempFile, new File(path));
            System.out.println("SCREENSHOT: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
