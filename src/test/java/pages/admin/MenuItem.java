package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AbstractElementsContainer;
import java.util.ArrayList;
import java.util.List;

public class MenuItem extends AbstractElementsContainer {
    private WebElement item;
    private List<WebElement> subItems = new ArrayList<>();


    MenuItem(WebElement itemElement){
        item = itemElement;
    }


    public AdminPage clickMenuItem(){
        item.click();
        return new AdminPage();
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
