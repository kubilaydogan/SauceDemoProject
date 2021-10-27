package Pages.Support;

import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpectedShoppingCart {
    // bunu kullanmadim henuz

    private static List<Map<String, String>> cart = new ArrayList<>();

    // Add - remove item
    public static void addItem(Map<String, String> item){
        cart.add(item);
    }

    public static void addItems(DataTable items){
        List<Map<String, String>> list = items.asMaps(String.class, String.class);
        for(Map each:list){
            addItem(each);
        }
    }

    public static void removeItem(Map<String, String> item){
        cart.remove(item);
    }

    // Count of items
    public static int expectedNumberOfItemsInCart(){
        return cart.size();
    }

    // Sum of items
    public static double getSumOfShoppingCart(){
        double itemPrice, sum =0;
        String price;

        for(Map each:cart) {
                price = each.get("price").toString();
                itemPrice = Double.parseDouble(price);
                sum += itemPrice;
        }
        return sum;
    }

    public static List getItemsInCart(){
        List<String> list = new ArrayList<>();
        for(Map each:cart) {
            list.add(each.get("item").toString());
        }
        return list;
    }
}
