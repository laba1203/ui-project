package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AbstractElementsContainer;
import pages.admin.common.LeftMenu;
import pages.admin.common.MenuItem;
import pages.store.catalog.StoreCatalog;

public abstract class AbstractAdminPage extends AbstractElementsContainer{

    private static final By mainSiteButtonLctr = By.cssSelector("[title = 'Catalog']");

    private LeftMenu leftMenu;
    private WebElement mainSiteCatalogButton;


    public AbstractAdminPage(){
        setElements();
    }

    public MenuItem findItemByName(String name){
        leftMenu = new LeftMenu();
        return leftMenu.findItemByName(name);
    }

    public StoreCatalog openStoreCatalog(){
        mainSiteCatalogButton = driver.findElement(mainSiteButtonLctr);
        mainSiteCatalogButton.click();
        return new StoreCatalog();
    }



    private void setElements(){
        leftMenu = new LeftMenu();
        mainSiteCatalogButton = driver.findElement(mainSiteButtonLctr);
    }


}
