package tests.litecart.task3.v2;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Application;
import pages.admin.catalog.Catalog;
import pages.store.StorePage;
import pages.store.catalog.StoreCatalog;
import pages.store.checkout.Checkout;
import pages.store.product.Product;
import util.DriverFactory;
import util.PropertyLoader;

import static util.DriverFactory.BrowserType.CHROME;

public class TaskScenario_v2 extends Application{

    private static final String URL = PropertyLoader.loadTestProperty("store.admin.url");
    private static final String USER_NAME = PropertyLoader.loadTestProperty("store.user.name");
    private static final String PASSWORD = PropertyLoader.loadTestProperty("store.user.password");

    private String productName = "AutoTest_" + System.currentTimeMillis();
    private String secondProductName = "Blue Duck";
    private int productCounter = 0;


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
    public void addNewProduct(){
        login(USER_NAME, PASSWORD);
        addNewProduct(productName, "some description", 100, 100);
        Assert.assertEquals(getProductsCountFromCatalog(productName), 1,  "FAILED: Incorrect products count in the catalog");

        openStoreHomePage();
        addProductToCart(productName);
        productCounter++;
        Assert.assertEquals(getCartTotalCount(), String.valueOf(productCounter), "FAILED: Incorrect cart total count when product <"+productName+"> was added");

        addProductToCart("Blue Duck");
        productCounter++;
        Assert.assertEquals(getCartTotalCount(), String.valueOf(productCounter), "FAILED: Incorrect cart total count when product <"+secondProductName+"> was added");

        openCheckoutPage();
        removeAllOrdersFromCheckout();
        Assert.assertEquals(getOrdersRowsSizeFromCheckout(), 0, "FAILED: Order are not removed on the Checkout page");
    }











}
