package marvelousboomerangmoose.shoppingwithfriends;

import java.util.HashMap;


/**
 * UserActivity class will control the user by which all the user data is stored and retrieved
 * as necessary.
 */
public class UserActivity {

    // Credentials - key is username
    public static HashMap<String, User> credentials = new HashMap<String, User>();//TODO: getters?
    //save binary when updated
    public static User loggedInUser = null; //TODO: create a getter for this

    //UserActivity.credentials.put("admin", new User("Robbie", "Hooke", "admin@shop.moose", "admin", "pass"));
    //UserActivity.credentials.put("user", new User("Derrick", "Williams", "user@shop.moose", "user", "pass"));
    //UserActivity.credentials.put("new", new User("Richard", "Wang", "new@shop.moose", "new", "pass"));


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
     * Adds a friend to the friendlist
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
     * @return friendlist
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
