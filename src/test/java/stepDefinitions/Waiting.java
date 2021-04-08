package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiting {
    public static void toBeClickable(WebDriver driver, String by) {

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector(by)));

    }

    public static void toBePresent(WebDriver driver, String by) {

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(by)));
    }
}
