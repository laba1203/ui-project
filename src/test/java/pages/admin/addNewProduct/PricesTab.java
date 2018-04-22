package pages.admin.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PricesTab extends AddNewProduct{
    private static final By priceLctr = By.cssSelector("input[name = 'purchase_price']");
    private static final By currencyLctr = By.cssSelector("select[name = 'purchase_price_currency_code']");

    private WebElement price;
    private Select currency;

    public PricesTab(){
        setElements();
    }

    public PricesTab setPrice(long value){
        price = driver.findElement(priceLctr);
        price.clear();
        price.sendKeys(String.valueOf(value));
        return new PricesTab();
    }

    public PricesTab selectCurrency(int index){
        currency = new Select(driver.findElement(currencyLctr));
        currency.selectByIndex(index);
        return new PricesTab();
    }


    private void setElements(){
        price = driver.findElement(priceLctr);
        currency = new Select(driver.findElement(currencyLctr));
    }



}
