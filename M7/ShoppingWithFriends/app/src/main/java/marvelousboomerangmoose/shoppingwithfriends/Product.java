<<<<<<< HEAD
package marvelousboomerangmoose.shoppingwithfriends;

/**
 * Contains information such as name and cost on a product.
 */
public class Product {
    private String item;
    private double cost;
    private double salesCost;
    private String location;
    private int inventory;
    private Boolean onSale;

    public Product(String item, double cost, double salesCost,
                   String location, int inventory, Boolean onSale) {
        this.item = item;
        this.cost = cost;
        this.location = location;
        this.inventory = inventory;
        this.onSale = onSale;
    }

    /**
     * Gets the item name.
     * @return the item name
     */
    public String getItem() {
        return item;
    }

    /**
     * Gets the cost of the item.
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets the cost of a product for if it changes in cost (goes on sale or otherwise).
     * @param cost the new cost for the item
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Gets the price of the sale on the item.
     * @return the price of the sale
     */
    public double getSalesCost() {
        return salesCost;
    }

    /**
     * Sets the price of the sale on the item.
     * @param salesCost the cost of the item on sale
     */
    public void setSalesCost(double salesCost) {
        this.salesCost = salesCost;
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
     * Gets whether or not the product is on sale.
     * @return true or false depending on if the product is on sale
     */
    public Boolean getOnSale() {
        return onSale;
    }

    /**
     * Sets the item to be on sale or not.
     * @param onSale whether or not the item is on sale
     */
    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }
}
=======
    package marvelousboomerangmoose.shoppingwithfriends;

import android.util.Log;

import java.util.HashMap;
import java.util.Set;

    /**
     * User class that holds all the information about a user, ie password, friend lists
     */
public class Product {
        private String name;
        private double price;
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
         * Returns the last name of the user
         *
         * @return Last name
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


        /**
         * Returns the friend list
         *
         * @return itemList
         */
        public HashMap<String, Product> getItemList() {
            return itemList;
        }
    }
>>>>>>> origin/master
