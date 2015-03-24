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
    private static HashMap<String, User> credentials = new HashMap<String, User>();//TODO: getters?
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
        Log.d("Friend Email", newFriend.getEmail());
        if (newFriend != null) {
            loggedInUser.addFriend(newFriend);
            Log.d("Adding friend", "Success");
            newFriend.addFriend(loggedInUser);//adds them back
            return true;
        } else {
            return false;
        }
    }





/*

    */
/**
     * Get user from master active user list
     * @param username - string username
     * @return - returns user from master active user list in credentials
     *//*

    public User getUser(String username) {
        return credentials.get(username);
    }

    */
/**
     * Get logged in user
     * @return - returns logged in user
     *//*

    public User getLoggedInUser() {
        return loggedInUser;
    }

    */
/**
     * Returns the first name of the user
     * @return First name
     *//*

    public String getFirst(String username) {
        return credentials.get(username).getFirst();
    }

    */
/**
     * Returns the last name of the user
     * @return Last name
     *//*

    public String getLast(String username) {
        return credentials.get(username).getLast();
    }

    */
/**
     * Returns the email of the user
     * @return email
     *//*

    public String getEmail(String username) {
        return credentials.get(username).getEmail();
    }

    */
/**
     * Returns the user name of the user
     * @return user name
     *//*

    public String getUserName(String username) {
        return credentials.get(username).getUserName();
    }

    */
/**
     * Returns the user rating of the user
     * @return user rating
     *//*

    public String getRating(String username) { return credentials.get(username).getRating();}

    */
/**
     * Sets the user rating of the user
     * @param rating
     * @return - boolean if rating was set
     *//*

    public boolean setRating(String rating) {
        return false;
    }

    */
/**
     * Returns whether or not passwords match
     * @return whether or not passwords match
     *//*

    public Boolean checkPassword(String input) {
        return (input.equals(password));
    }

    */
/**
     * Adds a friend to the friendList
     * @param firstName
     * @param lastName
     * @param email
     * @return returns whether or not the friend was added successfully
     *//*

    public Boolean addFriend(String firstName, String lastName, String email) {
        Set<String> keys = UserActivity.credentials.keySet();
        User newFriend = null;
        for (String key : keys) {
            User curr = UserActivity.credentials.get(key);
            if (curr.getEmail().equals(email)) {
                if (curr.getFirst().equals(firstName) && curr.getLast().equals(lastName)) {
                    newFriend = curr;
                }
                break;
            }
        }

        Log.d("User Email", this.getEmail());
        Log.d("Friend Email", newFriend.getEmail());
        if (newFriend != null) {
            friendList.put(email, newFriend);
            Log.d("Adding friend", "Success");
            newFriend.addFriend(this);//adds them back
            return true;
        } else {
            return false;
        }
    }


    //TODO: change visibility so that only visible from User objects
    */
/**
     * Adds a user as a friend using their user object
     * @param friend
     *//*

    public void addFriend(User friend) {
        Log.d("Adding friend", "Mutually");
        Log.d("User Email", this.getEmail());
        Log.d("Friend Email", friend.getEmail());
        friendList.put(friend.getEmail(), friend);
        Persistence.saveBinary();
    }

    */
/**
     * Deletes a user as a friend using their user object
     * @param friend
     *//*

    public void deleteFriend(User friend) {
        friendList.remove(friend.getEmail());
    }

    */
/**
     * Deletes a user as a friend using their user object and remove you as their friend too
     * @param friend
     *//*

    public void deleteFriendMutually(User friend) {
        deleteFriend(friend);
        friend.deleteFriend(this);
        Persistence.saveBinary();
    }

    */
/**
     * Returns the friend list
     * @return friendList
     *//*

    public HashMap<String, User> getFriendList() {
        return friendList;
    }

    */
/**
     * To String
     * @return userName
     *//*

    public String toString() {
        return this.getUserName();
    }

    */
/**
     * Get the Item list
     * @return - returns itemList
     *//*

    public HashMap<String, Product> getItemList() {return itemList;}

*/

}
