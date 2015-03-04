package marvelousboomerangmoose.shoppingwithfriends;

import java.util.HashMap;





public class UserActivity {

    public static HashMap<String, User> credentials = new HashMap<String, User>();
    public static User loggedInUser = null; //TODO: create a getter for this


    public UserActivity() {
        if (credentials.isEmpty()) {
            credentials.put("admin", new User("Robbie", "Hooke", "admin@shop.moose", "admin", "pass"));
            credentials.put("user", new User("Derrick", "Williams", "user@shop.moose", "user", "pass"));
            credentials.put("new", new User("Richard", "Wang", "new@shop.moose", "new", "pass"));
        }
    }





}
