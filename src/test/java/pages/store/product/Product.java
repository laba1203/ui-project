package pages.store.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.store.StorePage;
import util.DriverFactory;

public class Product extends StorePage {

    private static final By nameLctr = By.cssSelector("h1[itemprop = 'name']");
    private static final By addToCartLctr = By.cssSelector("button[name = 'add_cart_product']");

    private WebElement name;
    private WebElement addToCart;

    public Product(){
        setElements();
    }

    public String getName(){
        name = driver.findElement(nameLctr);
        return name.getText();
    }

    public Product addToCart(){
        String previousCount = getCartCountValue();
        addToCart = driver.findElement(addToCartLctr);
        addToCart.click();
        DriverFactory.getWait(5, 500)
                .until(ExpectedConditions.invisibilityOfElementWithText(getCounterLocator(), previousCount));
        return new Product();
    }

    private void setElements(){
        name = driver.findElement(nameLctr);
        addToCart = driver.findElement(addToCartLctr);
    }
}
