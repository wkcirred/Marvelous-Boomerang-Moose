package marvelousboomerangmoose.shoppingwithfriends.Model;

import android.app.Activity;
import android.util.Log;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class RobbieHookeUserActivityTest extends TestCase {
    private UserActivity users;
    private HashMap<String, User> userMap;

    public void setUp() throws Exception {
        users = new UserActivity();
        userMap = new HashMap<>();
        //creates users
        User rhooke = new User("Robbie", "Hooke", "bla@", "rhooke", "pass");
        userMap.put("rhooke", rhooke);
        userMap.put("aCrooke", new User("Aobbie", "Crooke", "bla@as", "aCrooke", "pass"));
        userMap.put("plFooke", new User("Plobbie", "Fooke", "bla@d", "plFooke", "pass"));
        //adds them to the credentials
        users.setCredentials(userMap);
        users.loggedInUser = rhooke;
    }


    /**
     * Tests the case where the friend email is incorrect
     */
    public void testIncorrectEmail() {
        Assert.assertEquals("Friend Added When Email Was Wrong", false, (boolean) users.addFriend("Aobbie", "Crooke", "bla@r"));
        HashMap<String, User> friendList = users.loggedInUser.getFriendList();
        Assert.assertEquals("Friend Added to Friend List Incorrectly", false, friendList.containsKey("bla@r"));
        Assert.assertEquals("Friend Added to Friend List Incorrectly", false, friendList.containsKey("bla@as"));
    }
    /**
     * Tests the case where the friend first name is incorrect
     */
    public void testIncorrectFirstName() {
        Assert.assertEquals("Friend Added When First Name Was Wrong", false, (boolean) users.addFriend("sobbie", "Crooke", "bla@as"));
        HashMap<String, User> friendList = users.loggedInUser.getFriendList();
        Assert.assertEquals("Friend Added to Friend List Incorrectly", false, friendList.containsKey("bla@as"));
    }
    /**
     * Tests the case where the friend last name is incorrect
     */
    public void testIncorrectLastName() {
        Assert.assertEquals("Friend Added When Last Name Was Wrong", false, (boolean) users.addFriend("Aobbie", "dooke", "bla@as"));
        HashMap<String, User> friendList = users.loggedInUser.getFriendList();
        Assert.assertEquals("Friend Added to Friend List Incorrectly", false, friendList.containsKey("bla@r"));
    }
    /**
     * Tests the case where all info is correct and the friend is added to the
     */
    public void testFriendAdded() {
        Assert.assertEquals("Friend Not Added When Data Correct", true, (boolean) users.addFriend("Plobbie", "Fooke", "bla@d"));
        HashMap<String, User> friendList = users.loggedInUser.getFriendList();
        Assert.assertEquals("Friend Not Added to Friend List Correctly", true, friendList.containsKey("bla@d"));
        HashMap<String, User> friendList2 = friendList.get("bla@d").getFriendList();
        Assert.assertEquals("Friend Not Added to Friend List Correctly", true, friendList2.containsKey("bla@"));
    }
}