package marvelousboomerangmoose.shoppingwithfriends;

import android.test.ActivityUnitTestCase;

import java.util.HashMap;

import marvelousboomerangmoose.shoppingwithfriends.Model.Product;

public class HomeActivityTest extends ActivityUnitTestCase<HomeActivity> {
    HashMap<String, Product> salesMap = new HashMap<>();
    HashMap<String, Product> interestMap = new HashMap<>();
    HomeActivity home = new HomeActivity();

    public HomeActivityTest() {
        super(HomeActivity.class);
    }

    public void setUp() throws Exception {
        salesMap = new HashMap<>();
        interestMap = new HashMap<>();
    }

    /**
     * If there is no salesMap, the list on the home page should not generate
     * a list alerting the user to interests on sale.
     * @throws Exception
     */
    public void testInterestedSalesList() throws Exception {
        Product tv = new Product("tv", 10, "t", "t", 1);
        interestMap.put("tv", tv);
        home.interestedSalesList(salesMap, interestMap);
        assertNull(home.interestList);
    }

    public void testInterestedSalesList1() throws Exception {
        
    }
}