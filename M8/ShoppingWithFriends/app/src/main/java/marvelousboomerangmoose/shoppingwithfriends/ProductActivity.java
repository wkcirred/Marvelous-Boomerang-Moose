package marvelousboomerangmoose.shoppingwithfriends;

import java.util.HashMap;

/**
 * Methods for making use of product information.
 */
public class ProductActivity {
    //private static Sale sale;
    public static HashMap<String, Product> salesList = new HashMap<String, Product>();

    public ProductActivity() {
        //sale = new Sale(Sale.getSalesList());
        //salesList = new HashMap<String, Product>();
    }

    public static void reportSale(Product p) {
        //sale.addSaleItem(p);
        salesList.put(p.getName(), p);
    }
}
