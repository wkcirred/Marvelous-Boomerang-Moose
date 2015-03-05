package marvelousboomerangmoose.shoppingwithfriends;

import android.util.Log;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

/**
 * Product class stores information on various products for use in
 * registering product interest and reporting sales.
 */
public class Product implements Serializable{
    private String name;
    private double price;
    private double salesPrice;
    private String location;
    private String storeName;
    private int inventory;
    private boolean onSale;
    private HashMap<String, Product> itemList = new HashMap<String, Product>();

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
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
     * Sets the price of the product
     *
     * @param price
     * @return - boolean if price was set
     */
    public boolean setPrice(double price) {
        if (price < 0) {
            return false;
        }
        this.price = price;
        return true;
    }

    /**
     * Gets the price of the sale on the item.
     * @return the price of the sale
     */
    public double getSalesPrice() {
        return salesPrice;
    }

    /**
     * Sets the price of the sale on the item.
     * @param salesPrice the price of the item on sale
     */
    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    /**
     * Gets the item's location
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the item
     * @param location of the item
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the amount of the product at the store.
     * @return the amount of product remaining
     */
    public int getInventory() {
        return inventory;
    }

    /**
     * Sets the amount of stock available on the item
     * @param inventory amount of the item
     */
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    /**
     * Gets whether or not the item is on sale.
     * @return true or false depending on if the item is on sale
     */
    public boolean getOnSale() {
        return onSale;
    }

    /**
     * Sets the item to be on sale or not.
     * @param onSale whether or not the item is on sale
     */
    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    /**
     * Gets the name of the store the product is located in
     * @return the store name
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * Sets the name of the store the product is in
     * @param storeName the store's name
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * Adds an item to the itemList
     *
     * @param name
     * @param price
     * @return returns whether or not the item was added successfully
     */
    public Boolean addProduct(String name, double price) {
        Set<String> keys = MainActivity.productList.keySet();
        Product newProduct = new Product(name, price);
//            for (String key : keys) {
//                Product curr = MainActivity.productList.get(key);
//                if (curr.getName().equals(name)) {
//                    newProduct = curr;
//                    break;
//                }
//            }
//            if (newProduct != null) {
                itemList.put(name, newProduct);
                newProduct.addProduct(name, price);//adds them back
                return true;
//            } else {
//                return false;
//            }
        }

    /**
     * Adds an item
     *
     * @param item item to be added
     */
    public void addProduct(Product item) {
        itemList.put(item.getName(), item);
    }

    public HashMap<String, Product> getItemList() {
            return itemList;
        }

    /**
     * Returns the string of the product's name
     * @return product name
     */
    public String toString() {
        return (String) getName();
    }
}
