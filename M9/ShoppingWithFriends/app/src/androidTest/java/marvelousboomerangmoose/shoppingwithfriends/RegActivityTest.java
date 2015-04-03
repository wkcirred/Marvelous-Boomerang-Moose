package marvelousboomerangmoose.shoppingwithfriends;

import junit.framework.TestCase;

import marvelousboomerangmoose.shoppingwithfriends.Model.User;
import marvelousboomerangmoose.shoppingwithfriends.Model.UserActivity;

public class RegActivityTest extends TestCase {

    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    public void setUp() throws Exception {
        RegActivity reg = new RegActivity();
    }


    public void testIsEmailValid() throws Exception {
        userName = "TestUser";
        password = "12345";
        email = "user@moose.com";
        firstName = "George";
        lastName = "Burdell";
        assertTrue(RegActivity.isUserNameValid(userName));
        assertTrue(RegActivity.isUserEmailValid(email));
        assertTrue(RegActivity.isPasswordValid(password));

        User user = new User(firstName, lastName, email, userName, password);
        UserActivity.getCredentials().put(userName, user);

        assertFalse(RegActivity.isUserNameValid(userName));
        assertFalse(RegActivity.isUserEmailValid(email));
        assertTrue(RegActivity.isPasswordValid(password));
        UserActivity.getCredentials().remove(userName);
    }

    public void testIsUserNameValid() throws Exception {
        userName = "TestUser";
        password = "12345";
        email = "user@moose.com";
        firstName = "George";
        lastName = "Burdell";

        assertTrue(RegActivity.isUserNameValid(userName));
        assertTrue(RegActivity.isUserEmailValid(email));
        assertTrue(RegActivity.isPasswordValid(password));

        User user = new User(firstName, lastName, email, userName, password);
        UserActivity.getCredentials().put(userName, user);
        assertFalse(RegActivity.isUserNameValid(userName));
        UserActivity.getCredentials().remove(userName);

    }

    public void testIsPasswordValid() throws Exception {
        userName = "TestUser";
        password = "12345";
        email = "user@moose.com";
        firstName = "George";
        lastName = "Burdell";

        assertTrue(RegActivity.isPasswordValid(password));

        password = "1";
        assertFalse(RegActivity.isPasswordValid(password));
    }
}