package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;

import java.time.Duration;

public class LoginSteps extends CommonMethods {

   // WebDriver driver;

   // LoginPage loginPage = new LoginPage();

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
      //  WebElement loginButton = driver.findElement(By.id("btnLogin"));
        //loginButton.click();
        click(loginPage.loginButton);

    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
      //  WebElement usernameField = driver.findElement(By.id("txtUsername"));
        loginPage.usernameField.sendKeys("admin");

      //  WebElement passwordField = driver.findElement(By.id("txtPassword"));
        loginPage.passwordField.sendKeys("Hum@nhrm123");

    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        //validating the existence of the element
        Assert.assertTrue(loginPage.welcomeMessageLoc.isDisplayed());

        String value = loginPage.welcomeMessageLoc.getText();
        //validating the exact message on the element
        Assert.assertEquals("Welcome Admin", value);
        System.out.println("Test passed");
    }
}
