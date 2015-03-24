package marvelousboomerangmoose.shoppingwithfriends.Model;

import java.util.HashMap;

/**
 * Methods for making use of product information.
 */
public class ProductActivity {
    //private static Sale sale;
    public static HashMap<String, Product> salesList = new HashMap<String, Product>();
    public static HashMap<String, Product> productList = new HashMap<String, Product>();

    public ProductActivity() {
        //sale = new Sale(Sale.getSalesList());
        //salesList = new HashMap<String, Product>();
    }

    /**
     * Adds a sale report to the list of reported sales
     * @param p the product on sale
     */
    public static void reportSale(Product p) {
        //sale.addSaleItem(p);
        salesList.put(p.getName(), p);
        Persistence.saveBinary();
    }
}
