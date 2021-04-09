package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationStepDef {
    private Generate generate = new Generate();
    private WebDriver driver = null;


    @Given("User have navigated to signup page at mailchimp")
    public void userHaveNavigatedToSignupPageAtMailchimp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();

    }

    @And("User has typed the mailaddress NoEmail")
    public void userHasNotEnteredAMailaddress() {
        WebElement emailBox = driver.findElement(By.cssSelector("#email"));

            emailBox.sendKeys("");
        }

    @And("User has typed the mailaddress ValidEmail")
    public void userHasTypedTheMailaddress() {
        WebElement emailBox = driver.findElement(By.cssSelector("#email"));

        emailBox.sendKeys(generate.randomEmail(8));
        }

    @And("User has typed the username LongUserName<100")
    public void userHasTypedTheLongUsername() {

        WebElement usernameBox = driver.findElement(By.cssSelector("#new_username"));
        usernameBox.sendKeys(generate.randomUserName(101));

    }
    @And("User has typed the username UserName")
    public void userHasTypedTheUsername() {

       WebElement usernameBox = driver.findElement(By.cssSelector("#new_username"));
       usernameBox.sendKeys(generate.randomUserName(15));


    }
    @And("User has typed the username ExistingUserName")
    public void userHasTypedAnExistingUsername() {

        WebElement usernameBox = driver.findElement(By.cssSelector("#new_username"));
        usernameBox.sendKeys("AgoodUserName7879");


    }

    @And("User has chosen a password")
    public void userHasChosenAPassword() {
        WebElement usernameBox = driver.findElement(By.cssSelector("#new_password"));
        usernameBox.sendKeys(generate.randomLowerCase(3)+ generate.randomUpperCase(3)+ generate.randomNumbers(2)+ generate.randomSigns(2));
    }

    @And("User has rejected cookies")
    public void userHasRejectedCookies() {
        WebElement cookieDecline = driver.findElement(By.cssSelector("#onetrust-reject-all-handler"));
        Waiting.toBeClickable(driver,"#onetrust-reject-all-handler");
        cookieDecline.click();
    }

    @When("User has pressed the Sign Up Button")
    public void userHasPressedTheSignUpButton() {
        WebElement signUpButton = driver.findElement(By.cssSelector("#create-account"));
        Waiting.toBeClickable(driver, "#create-account");
        signUpButton.click();
    }

    @Then("User should be shown appropriate Welcome")
    public void userShouldBeShownMessage() {
        WebElement checkEmailTxt = driver.findElement(By.cssSelector("#signup-content > div > div > div > h1"));
        Waiting.toBePresent(driver, "#login");

        String actual = checkEmailTxt.getText();

        assertEquals("Check your email", actual);

    }

    @Then("User should be shown appropriate ToLongErrorMessage")
    public void userShouldBeShownToLongErrorMessage() {

        WebElement toLongMessage = driver.findElement(By.cssSelector("#signup-form > fieldset > div:nth-child(2) > div > span"));
        String actual = toLongMessage.getText();

        assertTrue(actual.contains("Enter a value less than 100 characters long"));

    }

    @Then("User should be shown appropriate EnterValueMessage")
    public void userShouldBeShownEnterValueMessage() {

        WebElement noEmailEntered = driver.findElement(By.cssSelector("#signup-form > fieldset > div:nth-child(1) > div > span"));
        String actual = noEmailEntered.getText();

        assertTrue(actual.contains("Please enter a value"));


    }
    @Then("User should be shown appropriate AlreadyUsedMessage")
    public void userShouldBeShownAppropriateAlreadyUsedMessage() {
        WebElement alreadyUsedMessage = driver.findElement(By.cssSelector("#signup-form > fieldset > div:nth-child(2) > div > span"));
        String actual = alreadyUsedMessage.getText();

        assertTrue(actual.contains("Another user with this username"));
    }

    @After
    public void quit(){

        driver.quit();
    }




}




