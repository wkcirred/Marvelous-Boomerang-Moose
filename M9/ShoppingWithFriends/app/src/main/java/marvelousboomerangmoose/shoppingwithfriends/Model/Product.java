package marvelousboomerangmoose.shoppingwithfriends.Model;

import java.io.Serializable;

/**
 * Product class stores information on various products for use in
 * registering product interest and reporting sales.
 */
public class Product implements Serializable{
    private final String name;
    private final double price;
    private final String location;
    private final String storeName;
    private final int inventory;

    // Constructor
    public Product(String name, double price, String location, String storeName, int inventory) {
        this.name = name;
        this.price = price;
        this.location = location;
        this.storeName = storeName;
        this.inventory = inventory;
    }

    /**
     * Returns the name of the product
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the item.
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the item's location
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the amount of the product at the store.
     * @return the amount of product remaining
     */
    public int getInventory() {
        return inventory;
    }

    /**
     * Gets the name of the store the product is located in
     * @return the store name
     */
    public String getStoreName() {
        return storeName;
    }


    /**
     * Returns the string of the product's name
     * @return product name
     */
    public String toString() {
        return getName();
    }
}