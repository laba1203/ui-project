package pages.admin.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AbstractElementsContainer;

import java.util.ArrayList;
import java.util.List;

public class LeftMenu extends AbstractElementsContainer{

    private static final By menuItemsLocator = By.xpath("//ul[@id='box-apps-menu']/li");
    private List<MenuItem> items;


    public LeftMenu(){
        setElements();
    }

    public MenuItem findItemByName(String name){
        for (pages.admin.common.MenuItem item :
                items) {
            if(item.getText().equals(name)){
                return item;
            }
        }
        Assert.fail("FAILED: Item with name <" + name + "> is not found");
        return null;
    }

    private void setElements(){
        items = new ArrayList<>();
        List<WebElement> itemsElements = driver.findElements(menuItemsLocator);
        for (WebElement element :
                itemsElements) {
            items.add(new MenuItem(element));
        }
    }
}
