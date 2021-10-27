package Pages;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends BasePage {

    static List<String> itemsInShoppingCart = new ArrayList<>();

    public static void verifyItems(DataTable dataTable) {
        List<String> addedItems = dataTable.asList(String.class);
        List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item_name"));
        for (WebElement each : list) {
            itemsInShoppingCart.add(each.getText());
        }
        Assert.assertEquals(addedItems, itemsInShoppingCart);
        list.clear();
        addedItems=null;
    }

    public static void removeItem(String product) {
        itemsInShoppingCart.remove(product.trim());
        ClickOn(driver.findElement(By.xpath("//div[text()='" + product + "']/../..//button[contains(@data-test,'remove')]")));
    }

    public static double getSumOfShoppingCart() {
        double itemPrice, sum =0;
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for(WebElement each:list){
            itemPrice = Double.parseDouble(each.getText().replace("$",""));
            sum += itemPrice;
        }
        return sum;
    }
}
