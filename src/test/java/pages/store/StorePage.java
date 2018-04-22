package pages.store;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.AbstractElementsContainer;
import pages.store.catalog.SearchResults;
import pages.store.catalog.StoreCatalog;
import pages.store.checkout.Checkout;
import pages.store.product.Product;

public class StorePage extends AbstractElementsContainer{

    private static final By homeLctr = By.xpath("//nav[@id = 'site-menu']/ul/li[1]/a");
    private static final By productCounterLctr = By.xpath("//a[@class = 'content']/span");
    private static final By searchLctr = By.cssSelector("input[type = 'search']");
    private static final By checkoutLctr = By.xpath("//a[contains(text(), 'Checkout')]");

    private WebElement homeButton;
    private WebElement productCount;
    private WebElement searchField;
    private WebElement checkoutButton;

    public StorePage(){
        setElements();
    }

    public StoreCatalog openHomePage(){
        homeButton = driver.findElement(homeLctr);
        homeButton.click();
        return new StoreCatalog();
    }

    public String getCartCountValue(){
        productCount = driver.findElement(productCounterLctr);
        return productCount.getText();
    }

    public Checkout openCheckoutPage(){
        checkoutButton = driver.findElement(checkoutLctr);
        checkoutButton.click();
        return new Checkout();
    }

    public SearchResults searchByPartialName(String productName){
        searchField = driver.findElement(searchLctr);
        searchField.sendKeys(productName + Keys.RETURN);
        return new SearchResults();
    }

    public Product searchByExactName(String productName){
        searchField = driver.findElement(searchLctr);
        searchField.sendKeys(productName + Keys.RETURN);
        return new Product();
    }

    private void setElements(){
        homeButton = driver.findElement(homeLctr);
        productCount = driver.findElement(productCounterLctr);
        searchField = driver.findElement(searchLctr);
        checkoutButton = driver.findElement(checkoutLctr);
    }

    protected By getCounterLocator(){
        return productCounterLctr;
    }
}
