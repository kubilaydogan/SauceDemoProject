package Pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Map;
import static Utilities.Log.info;

public class ProductsPage extends BasePage {

    private static WebElement dropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
    public static By shoppingCart = By.xpath("//a[@class='shopping_cart_link']");

    public static void sortProducts(String sortType) {
        // supported parameters: Price (high to low)|Price (low to high)|Name (A to Z)|Name (Z to A)

        Select select = new Select(dropdown);
        select.selectByVisibleText(sortType);
        info("Products are sorted by: %s", sortType);
    }

    public static void addSingleItemToCart(String product)  {
        driver.findElement(By.xpath("//div[text()='" + product.trim() + "']/ancestor::div[@class='inventory_item_description']//button")).click();
    }

    public static void addMultipleItemsToShoppingCart(DataTable items) {
        List<Map<String, String>> list = items.asMaps(String.class, String.class);
        for(Map each : list){
            addSingleItemToCart(each.get("item").toString());
        }

    }

    public static void goToShoppingCart() {
        ClickOn(driver.findElement(shoppingCart));
    }
}
