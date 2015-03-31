package marvelousboomerangmoose.shoppingwithfriends;

import android.test.ActivityUnitTestCase;
import java.util.HashMap;
import marvelousboomerangmoose.shoppingwithfriends.Model.Product;

/**
 * Checks to see if the HomeActivity method interestedSalesList() is properly
 * working.
 * @author Richard Valentine
 */
public class HomeActivityTest extends ActivityUnitTestCase<HomeActivity> {
    HashMap<String, Product> salesMap = new HashMap<>();
    HashMap<String, Product> interestMap = new HashMap<>();
    HomeActivity home;

    public HomeActivityTest() {
        super(HomeActivity.class);
        home = new HomeActivity();
    }

    /**
     * Sets up each test case as they are called to run.
     * @throws Exception
     */
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
        Product tv2 = new Product("tv", 6, "y", "r", 2);
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
        boolean checkEquality = expected.keySet().equals(hashMap.keySet());
        assertFalse(checkEquality);
    }

    /**
     * Checks to make sure if two items meet the requirements for the interestAlert,
     * they are both added to it
     * @throws Exception
     */
    public void testInterestedSalesListAddMultipleItems() throws Exception {
        Product tv = new Product("tv", 10, "N/A", "N/A", 0);
        Product rabbit = new Product("rabbit", 100, "N/A", "N/A", 0);
        interestMap.put("tv", tv);
        interestMap.put("rabbit", rabbit);
        Product tv2 = new Product("tv", 5, "y", "r", 2);
        Product rabbit2 = new Product("rabbit", 50, "pet store", "rd", 1);
        salesMap.put("tv", tv2);
        salesMap.put("rabbit", rabbit2);
        home.interestedSalesList(salesMap, interestMap);
        assertNotNull(home.interestAlert);
        HashMap<String, Product> hashMap = home.interestAlert;
        HashMap<String, Product> expected = new HashMap<>();
        expected.put("tv", tv2);
        expected.put("rabbit", rabbit2);
        boolean checkEquality = expected.keySet().equals(hashMap.keySet());
        assertTrue(checkEquality);
    }

    /**
     * Adds two items to salesMap and interestMap. One should be added to the interestAlert
     * while the other does not meet the requirements and should not be added to it.
     * @throws Exception
     */
    public void testInterestedSalesListVaryingAdd() throws Exception {
        Product tv = new Product("tv", 10, "N/A", "N/A", 0);
        Product rabbit = new Product("rabbit", 100, "N/A", "N/A", 0);
        interestMap.put("tv", tv);
        interestMap.put("rabbit", rabbit);
        Product tv2 = new Product("tv", 5, "y", "r", 2);
        Product rabbit2 = new Product("rabbit", 150, "pet store", "rd", 1);
        salesMap.put("tv", tv2);
        salesMap.put("rabbit", rabbit2);
        home.interestedSalesList(salesMap, interestMap);
        assertNotNull(home.interestAlert);
        HashMap<String, Product> hashMap = home.interestAlert;
        HashMap<String, Product> expected = new HashMap<>();
        expected.put("tv", tv2);
        boolean checkEquality = expected.keySet().equals(hashMap.keySet());
        assertTrue(checkEquality);
    }

    /**
     * Adds two items to salesMap and interestMap. One should be added to the interestAlert
     * while the other does not meet the requirements and should not be added to it.
     * @throws Exception
     */
    public void testInterestedSalesListVaryingAddReversedPrices() throws Exception {
        Product tv = new Product("tv", 5, "N/A", "N/A", 0);
        Product rabbit = new Product("rabbit", 150, "N/A", "N/A", 0);
        interestMap.put("tv", tv);
        interestMap.put("rabbit", rabbit);
        Product tv2 = new Product("tv", 10, "y", "r", 2);
        Product rabbit2 = new Product("rabbit", 100, "pet store", "rd", 1);
        salesMap.put("tv", tv2);
        salesMap.put("rabbit", rabbit2);
        home.interestedSalesList(salesMap, interestMap);
        assertNotNull(home.interestAlert);
        HashMap<String, Product> hashMap = home.interestAlert;
        HashMap<String, Product> expected = new HashMap<>();
        expected.put("rabbit", rabbit2);
        boolean checkEquality = expected.keySet().equals(hashMap.keySet());
        assertTrue(checkEquality);
    }

    /**
     * Adds a lot of items to salesMap and interestMap.  Some of these will need to be added
     * while others will not meet the requirements and will fail to be added (not matching
     * the price, not in salesMap, not in interestMap).
     * @throws Exception
     */
    public void testInterestedSalesListManyItems() throws Exception {
        Product tv = new Product("tv", 10, "N/A", "N/A", 0);
        Product rabbit = new Product("rabbit", 150, "N/A", "N/A", 0);
        Product phone = new Product("phone", 100, "N/A", "N/A", 0);
        Product game = new Product("game", 120, "N/A", "N/A", 0);
        Product tree = new Product("tree", 80, "N/A", "N/A", 0);
        Product squirrel = new Product("squirrel", 10, "N/A", "N/A", 0);
        Product monkey = new Product("monkey", 150, "N/A", "N/A", 0);
        interestMap.put("tv", tv);
        interestMap.put("rabbit", rabbit);
        interestMap.put("phone", phone);
        interestMap.put("monkey", monkey);
        interestMap.put("game", game);
        interestMap.put("tree", tree);
        interestMap.put("squirrel", squirrel);
        Product tv2 = new Product("tv", 20, "y", "r", 2);
        Product rabbit2 = new Product("rabbit", 150, "pet store", "rd", 1);
        Product phone2 = new Product("phone", 101, "somewhere", "street", 3);
        Product game2 = new Product("game", 90, "amazon", "online", 11);
        Product tree2 = new Product("tree", 59, "backyard", "home", 7);
        Product squirrel2 = new Product("squirrel", 12, "home", "fence", 5);
        Product ufo = new Product("ufo", 1000, "space", "moon", 1);
        salesMap.put("tv", tv2);
        salesMap.put("rabbit", rabbit2);
        salesMap.put("phone", phone2);
        salesMap.put("game", game2);
        salesMap.put("tree", tree2);
        salesMap.put("ufo", ufo);
        salesMap.put("squirrel", squirrel2);
        home.interestedSalesList(salesMap, interestMap);
        assertNotNull(home.interestAlert);
        HashMap<String, Product> hashMap = home.interestAlert;
        HashMap<String, Product> expected = new HashMap<>();
        expected.put("rabbit", rabbit2);
        expected.put("game", game2);
        expected.put("tree", tree2);
        boolean checkContains = hashMap.keySet().contains("game");
        assertTrue(checkContains);
        boolean checkNotContained = hashMap.keySet().contains("phone");
        assertFalse(checkNotContained);
        boolean checkNotContained2 = hashMap.keySet().contains("ufo");
        assertFalse(checkNotContained2);
        boolean checkNotContained3 = hashMap.keySet().contains("monkey");
        assertFalse(checkNotContained3);
        boolean checkEquality = expected.keySet().equals(hashMap.keySet());
        assertTrue(checkEquality);
    }
}