package marvelousboomerangmoose.shoppingwithfriends;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * Home activity contains a way to log out as well as a friends list and a way to lookup/add
 * new friends.
 */
public class HomeActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    /**
     * Button click that takes the user to ItemListActivity screen
     * @param v - the button being clicked
     */
    public void buttonItemListOnClick(View v) {
        startActivity(new Intent(this, ItemListActivity.class));
    }

    /**
     * Button click that takes the user to SalesReportActivity screen
     * @param v - the button being clicked
     */
    public void reportSaleOnClick(View v) {
        startActivity(new Intent(this, SalesReportActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    /**
     * Logs the user out of the program.
     * @param v the button being clicked
     */
    public void logoutOnClick(View v) {
        UserActivity.loggedInUser = null;
        startActivity(new Intent(this, MainActivity.class));
    }

    /**
     * Changes the screen to the friends list
     * @param v the button being clicked
     */
    public void activeUsersOnClick(View v) {
        startActivity(new Intent(this, ActiveUsersListActivity.class));
    }

    /**
     * Changes the screen to the new friend list screen
     * @param v the button being clicked
     */
    public void currentFriendsOnClick(View v) {
        startActivity(new Intent(this, CurrentFriendListActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_home, container, false);
            return rootView;
        }
    }
}
