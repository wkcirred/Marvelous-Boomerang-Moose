package marvelousboomerangmoose.shoppingwithfriends.Model;

import android.util.Log;

import java.util.HashMap;
import java.util.Set;


/**
 * UserActivity class will control the user by which all the user data is stored and retrieved
 * as necessary.
 */
public class UserActivity {

    // Credentials - key is username
    private static final HashMap<String, User> credentials = new HashMap<>();//TODO: getters?
    //save binary when updated
    public static User loggedInUser = null; //TODO: create a getter for this


    /**
     * Adds a bunch of values to the credentials, only called in Persistence.java
     * TODO: Remove this
     * @param cred a hashMap of credential entries
     */
    static void setCredentials(HashMap<String, User> cred) {
        credentials.putAll(cred);
    }


    /**
     * Creates a new User and adds it to the HashMap//TODO: move validation here
     * @param first the user's first name
     * @param last the user's last name
     * @param email the user's email
     * @param userName the user's username
     * @param password the user's password
     */
    public static void newUser(String first, String last, String email, String userName, String password) {
        User newUser = new User(first, last, email, userName, password);
        credentials.put(userName, newUser);
        Persistence.saveBinary();
    }

    //TODO: this shouldn't exist, make other ways to access required info
    /**
     * Returns the credentials HashMap
     * @return credentials HashMap
     */
    public static HashMap<String, User> getCredentials() {
        return credentials;
    }

    /**
     * Adds a friend to the friendList
     * @param firstName the friend's first name
     * @param lastName the friend's last name
     * @param email the friend's email
     * @return returns whether or not the friend was added successfully
     */
    public static Boolean addFriend(String firstName, String lastName, String email) {
        Set<String> keys = credentials.keySet();
        User newFriend = null;
        for (String key : keys) {
            User curr = credentials.get(key);
            if (curr.getEmail().equals(email)) {
                if (curr.getFirst().equals(firstName) && curr.getLast().equals(lastName)) {
                    newFriend = curr;
                }
                break;
            }
        }

        Log.d("User Email", loggedInUser.getEmail());

        //noinspection ConstantConditions
        if (newFriend != null) {
            Log.d("Friend Email", newFriend.getEmail());
            loggedInUser.addFriend(newFriend);
            Log.d("Adding friend", "Success");
            newFriend.addFriend(loggedInUser);//adds them back
            return true;
        } else {
            return false;
        }
    }
}
