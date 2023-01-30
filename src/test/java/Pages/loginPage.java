package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    protected WebDriver driver;
    By txt_username = By.id("username");
    By txt_password = By.id("password");
    By btn_login = By.id("kc-login");
    By url = By.xpath("/html/body/div/table/tbody/tr/td/a");

    public loginPage(WebDriver driver){
        this.driver=driver;

    }

    public void enterUsername(String username){
        driver.findElement(txt_username).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(txt_password).sendKeys(password);
    }
   public void clickLogin(){

        driver.findElement(btn_login).click();
   }
   public void clickUrl(){

        driver.findElement(url).click();
   }

   public void loginValidUser(String username, String password){
        driver.findElement(txt_username).sendKeys(username);
        driver.findElement(txt_password).sendKeys(password);
   }
}
