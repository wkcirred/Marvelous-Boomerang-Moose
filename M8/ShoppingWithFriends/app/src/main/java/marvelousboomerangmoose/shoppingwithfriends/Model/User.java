    package marvelousboomerangmoose.shoppingwithfriends.Model;

import android.util.Log;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

    /**
     * User class that holds all the information about a user, ie password, friend lists
     */
public class User implements Serializable{
    private String first;
    private String last;
    private String email;
    private String userName;
    private String password;
    private String rating;
    public HashMap<String, User> friendList = new HashMap<String, User>();
    private HashMap<String,Product> itemList = new HashMap<String, Product>();//TODO:RENAME TO INTERESTLIST
    //TODO: Add friend list and shopping attributes

    // Constructor
    User(String first, String last, String email, String userName, String password) {
        this.first = first;
        this.last = last;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.rating = "0";
        this.itemList = new HashMap<>();
        //make sure you save after creating a new user//Persistence.saveBinary();
    }

    /**
     * Returns the first name of the user
     * @return First name
     */
    public String getFirst() {
        return first;
    }

    /**
     * Returns the last name of the user
     * @return Last name
     */
    public String getLast() {
        return last;
    }

    /**
     * Returns the email of the user
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the user name of the user
     * @return user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Returns the user rating of the user
     * @return user rating
     */
    public String getRating() { return rating;}

    /**
     * Sets the user rating of the user
     * @param rating
     * @return - boolean if rating was set
     */
    public boolean setRating(String rating) {
        int intRating = Integer.parseInt(rating);

        if (intRating < 0 || intRating > 10) {
            return false;
        }
        this.rating = rating;
        Persistence.saveBinary();
        return true;
    }

    /**
     * Returns whether or not passwords match
     * @return whether or not passwords match
     */
    public Boolean checkPassword(String input) {
        return (input.equals(password));
    }



    //TODO: change visibility so that only visible from User objects
    /**
     * Adds a user as a friend using their user object
     * @param friend
     */
    public void addFriend(User friend) {
        Log.d("Adding friend", "Mutually");
        Log.d("User Email", this.getEmail());
        Log.d("Friend Email", friend.getEmail());
        friendList.put(friend.getEmail(), friend);
        Persistence.saveBinary();
    }

    /**
     * Deletes a user as a friend using their user object
     * @param friend
     */
    public void deleteFriend(User friend) {
        friendList.remove(friend.getEmail());
    }

    /**
     * Deletes a user as a friend using their user object and remove you as their friend too
     * @param friend
     */
    public void deleteFriendMutually(User friend) {
        deleteFriend(friend);
        friend.deleteFriend(this);
        Persistence.saveBinary();
    }

    /**
     * Returns the friend list
     * @return friendlist
     */
    public HashMap<String, User> getFriendList() {
        return friendList;
    }

    /**
     * To String
     * @return userName
     */
    public String toString() {
        return this.getUserName();
    }

    /**
     * Get the Item list
     * @return - returns itemList
     */
    public HashMap<String, Product> getItemList() {
        return itemList;
    }

    /**
      * Add item to list
      * @param p - Product to add to item list
      */
    public void addItem(Product p){
        itemList.put(p.getName(),p);
        Persistence.saveBinary();
    }
}
