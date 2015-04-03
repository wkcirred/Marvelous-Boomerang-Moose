package marvelousboomerangmoose.shoppingwithfriends;

import junit.framework.TestCase;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.test.ViewAsserts;
import android.test.TouchUtils;

import marvelousboomerangmoose.shoppingwithfriends.Model.UserActivity;

import static marvelousboomerangmoose.shoppingwithfriends.Model.UserActivity.*;


public class ActiveUsersDetailActivityTest extends
        ActivityInstrumentationTestCase2<ActiveUsersDetailActivity> {

    private ActiveUsersDetailActivity myActivity;
    private Button theButton;
    private TextView theText;
    private EditText inputText;
    private final String expectedInfoText = "Add Friend";
    UserActivity user;

    public ActiveUsersDetailActivityTest(){
        super(ActiveUsersDetailActivity.class);
        user = new UserActivity();
    }

    //@Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(false);
        myActivity = getActivity();

        theButton = (Button) myActivity.findViewById(R.id.addFriendButton);
        theText = (TextView) myActivity.findViewById(R.id.addFriendButton);
    }

    /*
     * Tests different situations based on loggedInUser
     */
    public void testAddFriendOnClick() throws Exception {


        //user.loggedInUser;
    }

    /*
     * Checks visibility
     */
    public void testInfoTextView_layout() {
        final View decorView = myActivity.getWindow().getDecorView();
        ViewAsserts.assertOnScreen(decorView, theText);
        assertTrue(View.VISIBLE == theText.getVisibility());
    }

    /*
     * Checks correct info text from button
     */
    public void testPushMeButton_clickButtonAndExpectInfoText() {

        TouchUtils.clickView(this, theButton);
        assertTrue(View.VISIBLE == theText.getVisibility());
        assertEquals(expectedInfoText, theText.getText());
    }





}