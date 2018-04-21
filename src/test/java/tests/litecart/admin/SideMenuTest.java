package tests.litecart.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.admin.main.MainAdminPage;
import pages.login.LoginPage;
import util.DriverFactory;

import static util.DriverFactory.BrowserType.CHROME;

public class SideMenuTest {

    private static final String URL = "http://localhost/litecart/admin/";
    private static final String USER_NAME = "admin";
    private static final String PASSWORD = "admin";


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

    @Test(dataProvider = "testData")
    public void test2_checkHeader(String itemName, String subItemName, String expectedHeader){
        MainAdminPage adminPage = new MainAdminPage();
        adminPage = adminPage.findItemByName(itemName).clickMenuItem();
        if(!subItemName.equals("N/A")) {
            adminPage.findItemByName(itemName).findSubItem(subItemName).click();
        }
        Assert.assertEquals(new MainAdminPage().getHeaderText(), expectedHeader);
    }


    @DataProvider
    public Object[][] testData(){
        return new Object[][]{
                {"Appearence", "Template", "Template"},
                {"Appearence", "Logotype", "Logotype"},

                {"Catalog", "Catalog", "Catalog"},
                {"Catalog", "Product Groups", "Product Groups"},
                {"Catalog", "Option Groups", "Option Groups"},
                {"Catalog", "Manufacturers", "Manufacturers"},
                {"Catalog", "Suppliers", "Suppliers"},
                {"Catalog", "Delivery Statuses", "Delivery Statuses"},
                {"Catalog", "Sold Out Statuses", "Sold Out Statuses"},
                {"Catalog", "Quantity Units", "Quantity Units"},
                {"Catalog", "CSV Import/Export", "CSV Import/Export"},

                {"Countries", "N/A", "Countries"},
                {"Currencies", "N/A", "Currencies"},
                {"Customers", "Customers", "Customers"},
                {"Customers", "CSV Import/Export", "CSV Import/Export"},
                {"Customers", "Newsletter", "Newsletter"},
                {"Geo Zones", "N/A", "Geo Zones"},
                {"Languages", "Languages", "Languages"},
                {"Languages", "Storage Encoding" ,"Storage Encoding"},

                {"Modules", "Background Jobs", "Job Modules"},
                {"Modules", "Customer", "Customer Modules"},
                {"Modules", "Shipping", "Shipping Modules"},
                {"Modules", "Payment", "Payment Modules"},
                {"Modules", "Order Total", "Order Total Modules"},
                {"Modules", "Order Success", "Order Success Modules"},
                {"Modules", "Order Action", "Order Action Modules"},

                {"Orders", "Orders", "Orders"},
                {"Orders", "Order Statuses", "Order Statuses"},
                {"Pages", "N/A", "Pages"},
                {"Reports", "Monthly Sales", "Monthly Sales"},
                {"Reports", "Most Sold Products", "Most Sold Products"},
                {"Reports", "Most Shopping Customers", "Most Shopping Customers"},

                {"Settings", "Store Info", "Settings"},
                {"Settings", "Defaults", "Settings"},
                {"Settings", "General", "Settings"},
                {"Settings", "Listings", "Settings"},
                {"Settings", "Images", "Settings"},
                {"Settings", "Checkout", "Settings"},
                {"Settings", "Advanced", "Settings"},
                {"Settings", "Security", "Settings"},

                {"Slides", "N/A", "Slides"},
                {"Tax", "Tax Classes", "Tax Classes"},
                {"Tax", "Tax Rates", "Tax Rates"},
                {"Translations", "Search Translations", "Search Translations"},
                {"Translations", "Scan Files", "Scan Files For Translations"},
                {"Translations", "CSV Import/Export", "CSV Import/Export"},
                {"Users", "N/A", "Users"},
                {"vQmods", "vQmods", "vQmods"}
        };
    }

}
