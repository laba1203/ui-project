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
//    private static final By removeButtonLctr = By.cssSelector("button[name = 'remove_cart_item']");

    private static final By firstShortcutLctr = By.xpath("//ul[@class = 'shortcuts']/li[1]/a");
    private static final By firstRemoveBtnLctr = By.xpath("//ul[@class = 'items']/li[1]//button[@name='remove_cart_item']");

    private List<WebElement> orderSummaryRows;


    public Checkout(){
        setElements();
    }


    public Checkout removeAllOrders(){
        while (orderSummaryRows.size() > 1){
            removeFirstOrder();
        }
        removeOrder(orderSummaryRows.size());
        return new Checkout();
    }

    private void removeFirstOrder(){
        int initialOrdersSize = orderSummaryRows.size();
        WebElement firstShortcut = driver.findElement(firstShortcutLctr);
        firstShortcut.click();

        removeOrder(initialOrdersSize);
    }

    private void removeOrder(int previousOrdersCount){
        WebElement deleteButton = DriverFactory.getWait(3, 500)
                .until(ExpectedConditions.elementToBeClickable(firstRemoveBtnLctr));
        deleteButton.click();
        DriverFactory.getWait(5, 500)
                .until(ExpectedConditions.numberOfElementsToBe(orderSummaryRowLctr, previousOrdersCount - 1));
        System.out.println("LOG: Element is deleted");
        setElements();
    }


    private void setElements(){
        orderSummaryRows = driver.findElements(orderSummaryRowLctr);
    }

    public int getOrdersRowsSize(){
        orderSummaryRows = driver.findElements(orderSummaryRowLctr);
        return orderSummaryRows.size();
    }


}
