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
