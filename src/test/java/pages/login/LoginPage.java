package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AbstractElementsContainer;
import pages.admin.main.MainAdminPage;

public class LoginPage extends AbstractElementsContainer {

    private WebElement userName;
    private WebElement password;
    private WebElement loginButton;

    public LoginPage(){
        setElements();
    }

    private void setElements(){
        userName = driver.findElement(By.xpath("//input[@name = 'username']"));
        password = driver.findElement(By.xpath("//input[@name = 'password']"));
        loginButton = driver.findElement(By.xpath("//button[@name = 'login']"));
    }

    public LoginPage populateForm(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        return new LoginPage();
    }

    public MainAdminPage clickLogin(){
        loginButton.click();
        return new MainAdminPage();
    }




}
