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
