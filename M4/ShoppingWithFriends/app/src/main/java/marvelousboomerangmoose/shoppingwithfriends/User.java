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
    public void User(String first, String last, String email, String userName, String password) {
        this.first = first;
        this.last = last;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public String getFirst() {
        return first;
    }
    public String getLast() {
        return last;
    }
    public String getEmail() {
        return email;
    }
    public String getUserName() {
        return userName;
    }
    public Boolean checkPassword(String input) {
        return (input == password);
    }
    public void setPassword(String input) {
        this.password = password;
    }

}
