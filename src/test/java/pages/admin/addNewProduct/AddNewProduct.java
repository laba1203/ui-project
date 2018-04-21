package pages.admin.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.admin.AbstractAdminPage;
import pages.admin.catalog.Catalog;

public abstract class AddNewProduct extends AbstractAdminPage{

    private static final By saveBtnLctr = By.cssSelector("[value = 'Save']");
    private static final By informationTabLctr = By.xpath("//a[text() = 'Information']");
    private static final By pricesTabLctr = By.xpath("//a[text() = 'Prices']");


    private WebElement saveButton;
    private WebElement informationTab;
    private WebElement pricesTab;

    public AddNewProduct(){
        setElements();
    }

    public InformationTab openInformationTab(){
        informationTab = driver.findElement(informationTabLctr);
        informationTab.click();
        return new InformationTab();
    }

    public PricesTab openPricesTab(){
        pricesTab = driver.findElement(pricesTabLctr);
        pricesTab.click();
        return new PricesTab();
    }


    public Catalog save(){
        setElements();
        saveButton.click();
        return new Catalog();
    }



    private void setElements(){
        saveButton = driver.findElement(saveBtnLctr);
    }

}
