package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Helper {
    static WebDriver driver = Driver.getDriver();
    public static void main(String[] args) {

        // sample code
        String itemNumber = "2nd";
        itemNumber.replaceAll("[^\\d.]", "");      // removing all non numeric characters
        String item = "(//div[@class='a-section a-spacing-none a-spacing-top-small']//h2)[" + itemNumber + "]/a";
        driver.findElement(By.xpath(item)).click();
    }
}
