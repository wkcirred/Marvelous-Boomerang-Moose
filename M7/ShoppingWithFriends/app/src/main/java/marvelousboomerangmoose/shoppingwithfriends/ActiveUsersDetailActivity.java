package marvelousboomerangmoose.shoppingwithfriends;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Displays information pertaining to individual users.
 */
public class ActiveUsersDetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_users_detail);

        Intent intent = getIntent();
        String key = intent.getStringExtra("email");
        HashMap<String, User> users = MainActivity.credentials;
        String foundUserName = "";
        for (String userName : users.keySet()) {
            if (users.get(userName).getEmail().equals(key)) {
                foundUserName = userName;
            }
        }
        
        User user = users.get(foundUserName);

        TextView tv1 = (TextView) findViewById(R.id.activefirstName);
        tv1.setText(user.getFirst());
        TextView tv2 = (TextView) findViewById(R.id.activelastName);
        tv2.setText(user.getLast());
        TextView tv3 = (TextView) findViewById(R.id.activeemailAddress);
        tv3.setText(user.getEmail());
        TextView tv4 = (TextView) findViewById(R.id.activeuserName);
        tv4.setText(user.getUserName());
        TextView tv5 = (TextView) findViewById(R.id.activerating);
        tv5.setText(user.getRating());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_active_users_detail, menu);
        return true;
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
     * Add Friend and changes the screen back to the active user list screen
     * @param v the button being clicked
     */
    public void addFriendOnClick(View v) {
        Intent intent = getIntent();
        String key = intent.getStringExtra("email");
        HashMap<String, User> users = MainActivity.credentials;
        String foundUserName = "";
        for (String userName : users.keySet()) {
            if (users.get(userName).getEmail().equals(key)) {
                foundUserName = userName;
            }
        }
        User user = users.get(foundUserName);

        MainActivity.loggedInUser.addFriend(user);

        startActivity(new Intent(this, CurrentFriendListActivity.class));
    }
}
