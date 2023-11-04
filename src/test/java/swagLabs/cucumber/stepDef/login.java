package swagLabs.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

// positive case
@Given("user on login page")
    public void user_on_login_page(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get(baseUrl);

    String loginPageAssert = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
    Assert.assertEquals(loginPageAssert, "Swag Labs");

}

    @When("user input valid username")
    public void user_input_valid_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

    }

    @And("user input valid password")
    public void user_input_valid_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

    }

    @And("user click login button")
    public void user_click_login_button() {
        driver.findElement(By.id("login-button")).click();

    }

    @Then("user should redirect to products page")
    public void user_should_redirect_to_products_page() {
        String dashboardProducts = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(dashboardProducts, "Products");
        driver.close();

    }

}
