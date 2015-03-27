package marvelousboomerangmoose.shoppingwithfriends;

import android.test.ActivityUnitTestCase;

import java.util.HashMap;

import marvelousboomerangmoose.shoppingwithfriends.Model.Product;

public class HomeActivityTest extends ActivityUnitTestCase<HomeActivity> {
    HashMap<String, Product> salesMap = new HashMap<>();
    HashMap<String, Product> interestMap = new HashMap<>();
    HomeActivity home;

    public HomeActivityTest() {
        super(HomeActivity.class);
        home = new HomeActivity();
    }

    public void setUp() throws Exception {
        salesMap = new HashMap<>();
        interestMap = new HashMap<>();
    }

    /**
     * If there is no salesMap, a list alerting the user to interests on sale should not
     * be added to.
     * @throws Exception
     */
    public void testInterestedSalesListNoSalesMap() throws Exception {
        Product tv = new Product("tv", 10, "t", "t", 1);
        interestMap.put("tv", tv);
        home.interestedSalesList(salesMap, interestMap);
        HashMap<String, Product> expected = new HashMap<>();
        assertEquals(expected, home.interestAlert);
    }

    /**
     * Makes sure a reported sale does not get put into the interestAlert
     * if there is no interest in that item.
     * @throws Exception
     */
    public void testInterestedSalesListNoInterestMap() throws Exception {
        Product tv = new Product("tv", 10, "t", "t", 1);
        salesMap.put("tv", tv);
        home.interestedSalesList(salesMap, interestMap);
        HashMap<String, Product> expected = new HashMap<>();
        assertEquals(expected, home.interestAlert);
    }

    /**
     * Test to make sure if a sale is cheaper than a user's interest on that item, it will
     * be added to the list for display.
     * @throws Exception
     */
    public void testInterestedSalesListCheaper() throws Exception {
        Product tv = new Product("tv", 10, "N/A", "N/A", 0);
        interestMap.put("tv", tv);
        Product tv2 = new Product("tv", 5, "y", "r", 2);
        salesMap.put("tv", tv2);
        home.interestedSalesList(salesMap, interestMap);
        assertNotNull(home.interestAlert);
        HashMap<String, Product> hashMap = home.interestAlert;
        HashMap<String, Product> expected = new HashMap<>();
        expected.put("tv", tv2);
        assertEquals(expected, hashMap);
    }

    /**
     * Checks to make sure an item just $1 cheaper gets added to the interestAlert.
     * @throws Exception
     */
    public void testInterestedSalesListSlightlyCheaper() throws Exception {
        Product tv = new Product("tv", 10, "N/A", "N/A", 0);
        interestMap.put("tv", tv);
        Product tv2 = new Product("tv", 9, "y", "r", 2);
        salesMap.put("tv", tv2);
        home.interestedSalesList(salesMap, interestMap);
        assertNotNull(home.interestAlert);
        HashMap<String, Product> hashMap = home.interestAlert;
        HashMap<String, Product> expected = new HashMap<>();
        expected.put("tv", tv2);
        assertEquals(expected, hashMap);
    }

    /**
     * Checks to make sure an equal cost item is being added to the interestAlert in the
     * HomeActivity for display in the list of interested items on sale.
     * @throws Exception
     */
    public void testInterestedSalesListEqual() throws Exception {
        Product tv = new Product("tv", 10, "N/A", "N/A", 0);
        interestMap.put("tv", tv);
        Product tv2 = new Product("tv", 10, "y", "r", 2);
        salesMap.put("tv", tv2);
        home.interestedSalesList(salesMap, interestMap);
        assertNotNull(home.interestAlert);
        HashMap<String, Product> hashMap = home.interestAlert;
        HashMap<String, Product> expected = new HashMap<>();
        expected.put("tv", tv2);
        assertEquals(expected, hashMap);
    }

    /**
     * Checks to make sure a reported sale that is more expensive than the user's
     * interest in that item is not put in the interestAlert.
     * @throws Exception
     */
    public void testInterestedSalesListExpensive() throws Exception {
        Product tv = new Product("tv", 10, "N/A", "N/A", 0);
        interestMap.put("tv", tv);
        Product tv2 = new Product("tv", 11, "y", "r", 2);
        salesMap.put("tv", tv2);
        home.interestedSalesList(salesMap, interestMap);
        assertNotNull(home.interestAlert);
        HashMap<String, Product> hashMap = home.interestAlert;
        HashMap<String, Product> expected = new HashMap<>();
        expected.put("tv", tv2);
        boolean checkEquality = expected.keySet().equals(home.interestAlert.keySet());
        assertFalse(checkEquality);
    }

    /**
     * Checks to make sure a reported sale that is more expensive than the user's
     * interest in that item is not put in the interestAlert.
     * @throws Exception
     */
    public void testInterestedSalesListMoreExpensive() throws Exception {
        Product tv = new Product("tv", 10, "N/A", "N/A", 0);
        interestMap.put("tv", tv);
        Product tv2 = new Product("tv", 20, "y", "r", 2);
        salesMap.put("tv", tv2);
        home.interestedSalesList(salesMap, interestMap);
        assertNotNull(home.interestAlert);
        HashMap<String, Product> hashMap = home.interestAlert;
        HashMap<String, Product> expected = new HashMap<>();
        expected.put("tv", tv2);
        boolean checkEquality = expected.keySet().equals(home.interestAlert.keySet());
        assertFalse(checkEquality);
    }
    //TODO: Add test cases for multiple items
}