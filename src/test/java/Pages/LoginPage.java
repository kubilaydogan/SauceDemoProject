package Pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.List;
import static Utilities.Log.info;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePage{

    private static By username = By.id("user-name");
    private static By password = By.id("password");
    private static By loginButton = By.id("login-button");


    public static void openLandingPage() {
        driver.get(landingPageURL);
    }

    public static void login(DataTable dataTable) {
        List<List<String>> credentials = dataTable.asLists();
        String usernameValue = credentials.get(0).get(1);
        String passwordValue = credentials.get(1).get(1);

        driver.findElement(username).sendKeys(usernameValue);
        driver.findElement(password).sendKeys(passwordValue);
        driver.findElement(loginButton).click();

        try{
            assertTrue(driver.findElement(By.xpath("//span[@class='title']")).getText().contentEquals("PRODUCTS"));
            info("\"%s\" has logged in.", usernameValue);
        }catch(NoSuchElementException e){
            info("Login failed for %s !!", usernameValue);
        }
    }
}
