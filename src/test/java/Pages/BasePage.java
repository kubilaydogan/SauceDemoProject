package Pages;

import Utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    static WebDriver driver = Driver.getDriver();
    static String landingPageURL = "https://www.saucedemo.com/";
    static Faker faker = new Faker();


    public static void ClickOn(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        highlight(element);
        element.click();
    }

    public static void highlight(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Yellow background color with solid red color border.
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    public static void SendKeys(WebElement element, String data ){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOf(element));
        highlight(element);
        element.clear();
        element.sendKeys(data);
    }

}
