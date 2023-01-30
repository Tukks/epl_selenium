package Pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginSteps_POM {
    WebDriver driver = null;
    loginPage login = new loginPage(driver);
    SoftAssert softAssert = new SoftAssert();
    WebDriverWait wait = null;

    @Given("browser is open")
    public void browser_is_open() {
        System.out.println("Inside Step - browser is open");
        System.setProperty("webdriver.chrome.driver","C:/Users/jmenioui/PatientLink-Automation-Test/src/test/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @When("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("Inside Step - user is on login page");
        driver.navigate().to("https://epl-auth.aphm.qualif.enovacom.cloud/auth/realms/epl-institution/protocol/openid-connect/auth?response_type=code&client_id=epl-institution-app&scope=openid&state=xc_8ham0UTV7ZdOnQGjZK3MGGYfRskST2uXSxfN4neY%3D&redirect_uri=https://epl.aphm.qualif.enovacom.cloud/epl-institution/login/oauth2/code/keycloak&nonce=G5-OE8lUDxawggw4FOauxmi-zgvlAgNg-7tfeAK4rKs");
    }

    @And("^user enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username , String password) {

            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
            login.enterUsername(username);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
            login.enterPassword(password);
    }

    @When("clicks on login button")
    public void clicks_on_login_button() {
        System.out.println("Inside Step - clicks on login button");
        login.clickLogin();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/table/tbody/tr/td/a")));
        //driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/a")).click();
        login.clickUrl();
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        System.out.println("Inside Step - user is navigated to the home page");
        softAssert.assertEquals("https://epl.aphm.qualif.enovacom.cloud/epl-institution/", driver.getCurrentUrl());
        driver.close();
        driver.quit();
        softAssert.assertAll();
    }


}
