package pages.store.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractElementsContainer;
import util.DriverFactory;

import java.util.List;

public class Checkout extends AbstractElementsContainer{
    //table[contains(@class, 'dataTable')]//tr/td[@class = 'item']
    private static final By orderSummaryRowLctr = By.xpath("//td[@class = 'item']");
    private static final By removeButtonLctr = By.cssSelector("button[name = 'remove_cart_item']");

    private List<WebElement> orderSummaryRows;
    private List<WebElement> removeButtons;

    public Checkout(){
        setElements();
    }

    public Checkout removeAllOrders(){
        while (orderSummaryRows.size() > 0){
            removeVisibleProduct();
        }
        return new Checkout();
    }

    private void removeVisibleProduct(){
        int initialOrdersSize = orderSummaryRows.size();
        for (WebElement el:
             removeButtons) {
            if(el.isDisplayed()){
                el.click();
                DriverFactory.getWait(5, 500)
                        .until(ExpectedConditions.numberOfElementsToBe(orderSummaryRowLctr, initialOrdersSize));
                break;
            }
        }
        setElements();
    }

    private void setElements(){
        orderSummaryRows = driver.findElements(orderSummaryRowLctr);
        removeButtons = driver.findElements(removeButtonLctr);
    }

    public int getOrdersRowsSize(){
        orderSummaryRows = driver.findElements(orderSummaryRowLctr);
        return orderSummaryRows.size();
    }


}
