package tests.litecart.task3;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.admin.addNewProduct.GeneralTab;
import pages.admin.catalog.Catalog;
import pages.admin.main.MainAdminPage;
import pages.login.LoginPage;
import pages.store.StorePage;
import pages.store.catalog.StoreCatalog;
import pages.store.checkout.Checkout;
import pages.store.product.Product;
import util.DriverFactory;
import util.PropertyLoader;
import util.TestDataLoader;

import static util.DriverFactory.BrowserType.CHROME;

public class TaskScenario {

    private static final String URL = PropertyLoader.loadTestProperty("store.admin.url");
    private static final String USER_NAME = PropertyLoader.loadTestProperty("store.user.name");
    private static final String PASSWORD = PropertyLoader.loadTestProperty("store.user.password");

    private String productName = "AutoTest_" + System.currentTimeMillis();
    private int productCounter = 0;

    @BeforeClass
    public void setupDriver(){
        WebDriver driver = DriverFactory.getDriver(CHROME);
        driver.navigate().to(URL);
    }

//    @AfterClass
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
        new MainAdminPage()
                .findItemByName("Catalog")
                .clickMenuItem()
                .findItemByName("Catalog")
                .findSubItem("Catalog")
                .click();

        GeneralTab generalTab = new Catalog().clickAddNewProduct();

        Catalog catalog = generalTab
                .setName(productName)
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
        catalog = catalog.search(productName);
        Assert.assertEquals(catalog.getRows().size(), 1, "FAILED: Incorrect products count");
    }

    @Test
    public void test3_addProductToTheCart(){
        StoreCatalog storeCatalog = new Catalog().openStoreCatalog();
        Product productPage = storeCatalog
                .searchByExactName(productName)
                .addToCart();
        productCounter++;
        Assert.assertEquals(String.valueOf(productCounter), productPage.getCartCountValue(), "FAILED: Incorrect product count");
    }

    @Test
    public void test4_addOtherProduct(){
        Product productPage = new StorePage()
                .openHomePage()
                .searchByExactName("Blue Duck")
                .addToCart();
        productCounter++;
        Assert.assertEquals(String.valueOf(productCounter), productPage.getCartCountValue(), "FAILED: Incorrect product count");
    }

    @Test
    public void test5_removeAllOrders(){
        Checkout checkoutPage = new StorePage()
                .openCheckoutPage()
                .removeAllOrders();
        Assert.assertEquals(checkoutPage.getOrdersRowsSize(), 0, "FAILED: Not all orders have been deleted");
    }


}
