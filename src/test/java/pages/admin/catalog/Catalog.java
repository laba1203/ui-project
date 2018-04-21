package pages.admin.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import pages.admin.AbstractAdminPage;
import pages.admin.addNewProduct.AddNewProduct;
import pages.admin.addNewProduct.GeneralTab;

import java.util.List;

public class Catalog extends AbstractAdminPage{

    private static final By addNewProductLocator = By.xpath("//a[contains(text(), 'Add New Product')]");
    private static final By rowLctr = By.xpath("//tr[@class = 'row']");
    private static final By searchLctr = By.cssSelector("[type = 'search']");


    private WebElement addNewProductButton;
    private WebElement searchField;

    public Catalog(){
        setElements();
    }

    public GeneralTab clickAddNewProduct(){
        setElements();
        addNewProductButton.click();
        return new GeneralTab();
    }

    public Catalog search(String text){
        searchField = driver.findElement(searchLctr);
        searchField.sendKeys(text + Keys.RETURN);
        return new Catalog();
    }

    public List<WebElement> getRows(){
        return driver.findElements(rowLctr);
    }

    private void setElements(){
        addNewProductButton = driver.findElement(addNewProductLocator);
        searchField = driver.findElement(searchLctr);
    }


}
