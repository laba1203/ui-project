package pages.admin.main;

import org.openqa.selenium.By;
import pages.admin.AbstractAdminPage;

public class MainAdminPage extends AbstractAdminPage {

//    private List<pages.admin.common.MenuItem> items;
//    private static final By itemsLocator = By.xpath("//ul[@id='box-apps-menu']/li");

    public MainAdminPage(){
//        setElements();
    }

    public String getHeaderText(){
        return driver.findElement(By.xpath("//h1")).getText();
    }

//    public MenuItem findItemByName(String name){
//        for (MenuItem item :
//                items) {
//            if(item.getText().equals(name)){
//                return item;
//            }
//        }
//        Assert.fail("FAILED: Item with name <" + name + "> is not found");
//        return null;
//    }


//    private void setElements(){
//        items = new ArrayList<>();
//        List<WebElement> itemsElements = driver.findElements(itemsLocator);
//        for (WebElement element :
//                itemsElements) {
//            items.add(new MenuItem(element));
//        }
//    }
}
