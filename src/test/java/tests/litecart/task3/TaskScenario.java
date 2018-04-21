package tests.litecart.task3;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.admin.addNewProduct.AddNewProduct;
import pages.admin.addNewProduct.GeneralTab;
import pages.admin.catalog.Catalog;
import pages.admin.main.MainAdminPage;
import pages.login.LoginPage;
import util.DriverFactory;
import util.PropertyLoader;
import util.TestDataLoader;

import static util.DriverFactory.BrowserType.CHROME;

public class TaskScenario {

    private static final String URL = PropertyLoader.loadTestProperty("store.admin.url");
    //"http://localhost/litecart/admin/";
    private static final String USER_NAME = PropertyLoader.loadTestProperty("store.user.name");
    private static final String PASSWORD = PropertyLoader.loadTestProperty("store.user.password");

    @BeforeClass
    public void setupDriver(){
        WebDriver driver = DriverFactory.getDriver(CHROME);
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
    public void test2_addNewProduct(){
        String name = "AutoTest_" + System.currentTimeMillis();

        new MainAdminPage()
                .findItemByName("Catalog")
                .clickMenuItem()
                .findItemByName("Catalog")
                .findSubItem("Catalog")
                .click();

        GeneralTab generalTab = new Catalog().clickAddNewProduct();

        Catalog catalog = generalTab
                .setName(name)
                .setEnabledRadiobutton()
                .uploadFile(TestDataLoader.getTestDataFile("enot.jpg"))
                //populate Information Tab
                .openInformationTab()
                .setDescription("Some test description")
                //populate Prices Tab
                .openPricesTab()
                .setPrice(100)
                .selectCurrency(1)
                //save changes
                .save();

        //verify that product has been added to the Catalog
        catalog = catalog.search(name);
        Assert.assertEquals(catalog.getRows().size(), 1, "FAILED: Incorrect products count");
    }


}
