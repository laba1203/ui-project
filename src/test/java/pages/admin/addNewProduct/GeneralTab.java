package pages.admin.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralTab extends AddNewProduct{

    private static final By nameInputLctr = By.xpath("//input[contains(@name, 'name')]");
    private static final By enabledInputLctr = By.xpath("//label[contains(text(), 'Enabled')]/input");
    private static final By fileInputLctr = By.cssSelector("input[type = 'file']");

    private WebElement nameInput;
    private WebElement enabledInput;
    private WebElement fileInput;

    public GeneralTab(){
        setElements();
    }

    public GeneralTab setName(String name){
        nameInput = driver.findElement(nameInputLctr);
        nameInput.sendKeys(name);
        return new GeneralTab();
    }

    public GeneralTab setEnabledRadiobutton(){
        enabledInput = driver.findElement(enabledInputLctr);
        enabledInput.click();
        return new GeneralTab();
    }

    public GeneralTab uploadFile(String filePath){
        fileInput = driver.findElement(fileInputLctr);
        fileInput.sendKeys(filePath);
        return new GeneralTab();
    }

    private void setElements(){
        nameInput = driver.findElement(nameInputLctr);
        enabledInput = driver.findElement(enabledInputLctr);
        fileInput = driver.findElement(fileInputLctr);
    }






}
