package StepDefinitions;

import Pages.LoginPage;
import Pages.ProductsPage;
import Pages.ShoppingCart;
import Utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SauceLabs_StepDefs {
    static WebDriver driver = Driver.getDriver();

    @Given("user is on landing page")
    public void user_is_on_landing_page() {
        LoginPage.openLandingPage();
    }

    @When("user log into the site")
    public void user_log_into_the_site(DataTable credentials) {
        LoginPage.login(credentials);
    }

    @And("user sort the item by {string}")
    public void userSortTheItemBy(String sortType) {
        ProductsPage.sortProducts(sortType);
    }

    @And("user add {string}")
    public void userAdd(String product) {
        ProductsPage.addSingleItemToCart(product);
    }

    @And("user add following items")
    public void userAddFollowingItems(DataTable items) {
        ProductsPage.addMultipleItemsToShoppingCart(items);
    }

    @And("user navigates to the shopping cart")
    public void userNavigatesToTheShoppingCart() {
        ProductsPage.goToShoppingCart();
    }

    @Then("verify that the items that you added are in the cart")
    public void verifyThatTheItemsThatYouAddedAreInTheCart() {

    }

    @Then("verify that the added items are present in the cart")
    public void verifyThatTheAddedItemsArePresentInTheCart(DataTable dataTable) {
        ShoppingCart.verifyItems(dataTable);
    }

    @When("user removes {string} from shopping cart")
    public void userRemovesFromShoppingCart(String product) {
        ShoppingCart.removeItem(product);
    }

    @And("clicks on {string}")
    public void clicksOn(String button) throws InterruptedException {
        switch (button){
            case "Checkout":
                ShoppingCart.ClickOn(driver.findElement(By.id("checkout")));
                break;
            case "Continue Shopping":
                ShoppingCart.ClickOn(driver.findElement(By.id("continue-shopping")));
                break;
        }
        Thread.sleep(4000);
    }
}
