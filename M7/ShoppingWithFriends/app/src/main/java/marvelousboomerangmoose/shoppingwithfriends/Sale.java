package marvelousboomerangmoose.shoppingwithfriends;

import java.util.ArrayList;

/**
 * Holds a list of the reported sales.
 */
public class Sale {
    private ArrayList salesList;

    public Sale(ArrayList salesList) {
        this.salesList = salesList;
    }

    /**
     * Gets the sales list.
     * @return the list of sales
     */
    public ArrayList getSalesList() {
        return salesList;
    }

    /**
     * Sets the sales list.
     * @param salesList the list of sales
     */
    public void setArrayList(ArrayList salesList) {
        this.salesList = salesList;
    }
}
