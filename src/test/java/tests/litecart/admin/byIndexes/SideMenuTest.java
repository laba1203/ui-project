package tests.litecart.admin.byIndexes;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.login.LoginPage;
import util.DriverFactory;

import java.util.List;

import static util.DriverFactory.BrowserType.CHROME;

public class SideMenuTest {

    private static final String URL = "http://localhost/litecart/admin/";
    private static final String USER_NAME = "admin";
    private static final String PASSWORD = "admin";

    private WebDriver driver;


    @BeforeClass
    public void setupDriver(){
         driver = DriverFactory.getDriver(CHROME);
         driver.navigate().to(URL);
    }

    @AfterClass
    public void quit(){
        DriverFactory.quitAndClean();
    }

    @Test
    public void test1_login(){
        LoginPage loginPage = new LoginPage()
                .populateForm(USER_NAME, PASSWORD);
        loginPage.clickLogin();
    }


    @Test
    public void test2_verifyHeaders() {
        List<WebElement> items = driver.findElements(By.xpath("//ul[@id = 'box-apps-menu']/li"));

        for (int i = 1; i <= items.size(); i++) {
            //click to Item:
            getItemElement(i).click();

            List<WebElement> subItems = driver
                    .findElements(By.xpath("//ul[@id = 'box-apps-menu']/li[" + i + "]/ul[@class = 'docs']/li"));
            if(subItems.size() > 0) {
                for (int j = 1; j <= subItems.size(); j++) {
                    //click to sub item:
                    getSubItem(i, j).click();

                    String subItemName = getSubItem(i, j).getText();

                    assertHeader(subItemName);
                }
            }else{
               assertHeader(getItemElement(i).getText());
            }
        }
    }


    private void assertHeader(String name){
        try {
            driver.findElement(By.xpath("//h1"));
        } catch (NotFoundException e) {
            Assert.fail("FAILED: Header is not found for: " + name);
        }
    }


    private WebElement getItemElement(int index){
        return driver.findElement(By.xpath("//ul[@id = 'box-apps-menu']/li[" + index + "]"));
    }

    private WebElement getSubItem(int itemIndex, int subItemIndx){
        return driver.findElement(By
                .xpath("//ul[@id = 'box-apps-menu']/li[" + itemIndex + "]/ul[@class = 'docs']/li[" + subItemIndx + "]"));
    }


}
