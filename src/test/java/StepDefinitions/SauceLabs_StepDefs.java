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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

//    @And("user add {string} to shopping cart")
//    public void userAdd(String product) {
//        ProductsPage.addSingleItemToCart(product);
//    }
//
//    @When("user removes {string} from shopping cart")
//    public void userRemovesFromShoppingCart(String product) {
//        ShoppingCart.removeItem(product);
//    }

    @And("^user (add|removes) \"([^\"]*)\" (?:to|from) shopping cart$")
    public void shoppingCart(String transaction, String product) {

        switch (transaction) {
            case "add":
                ProductsPage.addSingleItemToCart(product);
                break;
            case "removes":
                ShoppingCart.removeItem(product);
                break;
        }
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

    @And("clicks on {string}")
    public void clicksOn(String button) {
        switch (button) {
            case "Checkout":
                ShoppingCart.ClickOn(driver.findElement(By.id("checkout")));
                break;
            case "Continue Shopping":
                ShoppingCart.ClickOn(driver.findElement(By.id("continue-shopping")));
                break;
        }
    }

    @And("user enters checkout information")
    public void userEntersCheckoutInformation(DataTable information)  {
        ShoppingCart.fillCostomerInformation(information);
    }

    @Then("verify total sum in checkout overview")
    public void verifyTotalSum() {
        ShoppingCart.verifyTotalSum();
    }
}
