package pages.store.catalog;

import org.openqa.selenium.By;
import pages.store.StorePage;
import pages.store.product.Product;

public class SearchResults extends StorePage {

    private static final By headerLctr = By.xpath("//h1[contains(text(), 'Search Results')]");
    private static final By resultsLctr = By.xpath("//ul[contains(@class, 'products')]/li/a[@class = 'link']");
    private static final By firstResultLctr = By.xpath("//ul[contains(@class, 'products')]/li[1]/a[@class = 'link']");

    public SearchResults(){
        setElements();
    }

    public void setElements(){
        driver.findElement(headerLctr);
    }

    public Product openFirstProduct(){
        driver.findElement(firstResultLctr).click();
        return new Product();
    }


}
