package pages.admin.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InformationTab extends AddNewProduct{
    private static final By descriptionLctr = By.xpath("//textarea[contains(@name, 'description')]");
    private static final By manufacturerLctr = By.cssSelector("select[name = 'manufacturer_id']");

    private WebElement description;
    private Select manufacturer;

    public InformationTab(){
        setElements();
    }

    private void setElements(){
        description = driver.findElement(descriptionLctr);
        manufacturer = new Select(driver.findElement(manufacturerLctr));
    }

    public InformationTab selectManufacturer(int index){
        manufacturer = new Select(driver.findElement(manufacturerLctr));
        manufacturer.selectByIndex(index);
        return new InformationTab();
    }

    public InformationTab setDescription(String text){
        description = driver.findElement(descriptionLctr);
        description.sendKeys(text);
        return new InformationTab();
    }
}
