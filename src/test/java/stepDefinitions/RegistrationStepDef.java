package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class RegistrationStepDef {
    Generate generate = new Generate();
    WebDriver driver = null;
    @Given("User have navigated to signup page at mailchimp")
    public void userHaveNavigatedToSignupPageAtMailchimp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();
        System.out.println("Test");
    }



    @And("User has typed the <mailAddress>")
    public void userHasTypedTheMailAddress() {

        WebElement emailBox = driver.findElement(By.cssSelector("#email"));
        emailBox.sendKeys(generate.randomEmail(8)+"@emailen.com");




    }

    @And("User has typed the <username>")
    public void userHasTypedTheUsername() {
        WebElement usernameBox = driver.findElement(By.cssSelector("#new_username"));
        usernameBox.sendKeys(generate.randomUserName(20));

    }

    @And("User has chosen a <password>")
    public void userHasChosenAPassword() {
        WebElement usernameBox = driver.findElement(By.cssSelector("#new_password"));
        usernameBox.sendKeys(generate.randomLowerCase(3)+ generate.randomUpperCase(3)+ generate.randomNumbers(2)+ generate.randomSigns(2));

    }

    @And("User has rejected <cookies>")
    public void userHasRejectedCookies() {
        WebElement cookieDecline = driver.findElement(By.cssSelector("#onetrust-reject-all-handler"));
        Waiting.toBeClickable(driver,"#onetrust-reject-all-handler");
        cookieDecline.click();
    }

    @When("User has pressed the <Sign Up Button>")
    public void userHasPressedTheSignUpButton() {

        WebElement signUpButton = driver.findElement(By.cssSelector("#create-account"));
        Waiting.toBeClickable(driver, "#create-account");
        signUpButton.click();
    }

    @Then("Account should be created and <Verified>")
    public void accountShouldBeCreatedAndVerified() {

     WebElement checkEmailTxt = driver.findElement(By.cssSelector("#signup-content > div > div > div > h1"));
     Waiting.toBePresent(driver, "#login");

     String verified = checkEmailTxt.getText();

     assertEquals("Check your email", verified);




        }


    }




