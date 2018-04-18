package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AbstractElementsContainer;

import java.util.ArrayList;
import java.util.List;

public class AdminPage extends AbstractElementsContainer {

    private List<MenuItem> items;
    private static final By itemsLocator = By.xpath("//ul[@id='box-apps-menu']/li");

    public AdminPage(){
        setElements();
    }

    public String getHeaderText(){
        return driver.findElement(By.xpath("//h1")).getText();
    }

    public MenuItem findItemByName(String name){
        for (MenuItem item :
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
        List<WebElement> itemsElements = driver.findElements(itemsLocator);
        for (WebElement element :
                itemsElements) {
            items.add(new MenuItem(element));
        }
    }
}
