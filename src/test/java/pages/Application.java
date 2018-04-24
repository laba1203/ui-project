package pages;

import org.testng.Assert;
import pages.admin.addNewProduct.GeneralTab;
import pages.admin.catalog.Catalog;
import pages.admin.main.MainAdminPage;
import pages.login.LoginPage;
import pages.store.StorePage;
import pages.store.catalog.StoreCatalog;
import pages.store.checkout.Checkout;
import pages.store.product.Product;
import util.TestDataLoader;

public class Application {

    protected void login(String user, String password){
        LoginPage loginPage = new LoginPage()
                .populateForm(user, password);
        loginPage.clickLogin();
    }

    protected void addNewProduct(String productName, String description, long priceWithTax, long purchasePrace){
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
                .setDescription(description)
                //populate Prices Tab
                .openPricesTab()
                .setPurchasePrice(purchasePrace)
                .setPriceWithTaxUSD(priceWithTax)
                .selectCurrency(1)
                //save changes
                .save();

//        catalog = catalog.search(productName);
//        Assert.assertEquals(catalog.getRows().size(), 1, "FAILED: Incorrect products count ");
    }

    protected int getProductsCountFromCatalog(String productName){
        return new Catalog()
                .search(productName)
                .getRows()
                .size();
    }

    protected void openStoreHomePage(){
       new StorePage().openHomePage();
    }

    protected void addProductToCart(String productName){
        new StoreCatalog()
                .searchByExactName(productName)
                .addToCart();
    }

    protected String getCartTotalCount(){
        return new Product().getCartCountValue();
    }

    protected void openCheckoutPage(){
        new StorePage().openCheckoutPage();
    }

    protected void removeAllOrdersFromCheckout(){
        new Checkout().removeAllOrders();
    }

    protected int getOrdersRowsSizeFromCheckout(){
        return new Checkout().getOrdersRowsSize();
    }
}
