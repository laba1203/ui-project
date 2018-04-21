package pages.admin.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AbstractElementsContainer;
import pages.admin.main.MainAdminPage;

import java.util.ArrayList;
import java.util.List;

public class MenuItem extends AbstractElementsContainer {
    private WebElement item;
    private List<WebElement> subItems = new ArrayList<>();


    public MenuItem(WebElement itemElement){
        item = itemElement;
    }


    public MainAdminPage clickMenuItem(){
        item.click();
        return new MainAdminPage();
    }


    public WebElement findSubItem(String name) {
        setElements(item);
        for (WebElement subItem :
                subItems) {
            if (subItem.getText().equals(name)) {
                return subItem;
            }
        }
        Assert.fail("FAILED: Not found sub item with name: " + name);
        return null;
    }

    public String getText(){
        return item.findElement(By.xpath("./a")).getText();
    }


    private void setElements(WebElement itemElement){
        subItems = itemElement.findElements(By.xpath(".//li/a"));
    }
}
