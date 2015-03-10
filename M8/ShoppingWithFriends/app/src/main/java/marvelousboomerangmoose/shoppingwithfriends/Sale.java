package marvelousboomerangmoose.shoppingwithfriends;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Holds a list of the reported sales.
 */
public class Sale {
    private static HashMap<String, Product> salesList = new HashMap<String, Product>();

    // Constructor
    public Sale(HashMap<String, Product> salesList) {
        this.salesList = salesList;
    }

    /**
     * Gets the sales list.
     * @return the list of sales
     */
    public static HashMap<String, Product> getSalesList() {
        return salesList;
    }

    /**
     * Adds an item on sale to the sales list.
     * @param p the product to be added to the sales list
     */
    public void addSaleItem(Product p) {
        salesList.put(p.getName(), p);
    }

    /**
     * Sets the sales list.
     * @param salesList the list of sales
     */
    public void setArrayList(HashMap<String, Product> salesList) {
        this.salesList = salesList;
    }
}
