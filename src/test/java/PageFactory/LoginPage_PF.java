package PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF {

    @FindBy(id = "username")
    WebElement txt_username;
    @FindBy(id = "password")
    WebElement txt_password;
    @FindBy(id = "kc-login")
    WebElement btn_login;
    @FindBy(xpath = "/html/body/div/table/tbody/tr/td/a")
    WebElement url;
    WebDriver driver;
    public LoginPage_PF(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username){
        txt_username.sendKeys(username);
   }
    public void enterPassword(String password){
         txt_password.sendKeys(password);
   }

   public void clickOnLogin(){
        btn_login.click();
    }

   public void clickOnUrl(){

    url.click();
   }
}
