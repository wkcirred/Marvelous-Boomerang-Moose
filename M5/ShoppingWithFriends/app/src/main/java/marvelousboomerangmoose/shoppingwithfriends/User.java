package marvelousboomerangmoose.shoppingwithfriends;

/**
 * Created by Robbie on 2/10/2015.
 */
public class User {
    private String first;
    private String last;
    private String email;
    private String userName;
    private String password;

    //TODO: Add friend list and shopping attributes
    public User(String first, String last, String email, String userName, String password) {
        this.first = first;
        this.last = last;
        this.email = email;
        this.userName = userName;
        this.password = password;
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
     * Returns whether or not passwords match
     * @return whether or not passwords match
     */
    public Boolean checkPassword(String input) {
        return (input.equals(password));
    }
}
