package marvelousboomerangmoose.shoppingwithfriends.Model;

import java.util.HashMap;

/**
 * Methods for making use of product information.
 */
public class ProductActivity {
    public static final HashMap<String, Product> salesList = new HashMap<>();
    public static final HashMap<String, Product> productList = new HashMap<>();


    /**
     * Adds a sale report to the list of reported sales
     * @param p the product on sale
     */
    public static void reportSale(Product p) {
        salesList.put(p.getName(), p);
        Persistence.saveBinary();
    }
}
