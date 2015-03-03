package marvelousboomerangmoose.shoppingwithfriends;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import android.widget.Button;

public class CurrentFriendDetailActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_friend_detail);

        Intent intent = getIntent();
        String key = intent.getStringExtra("email");
        HashMap<String, User> friends = UserActivity.loggedInUser.getFriendList();
        User user = friends.get(key);

        TextView tv1 = (TextView) findViewById(R.id.firstName);
        tv1.setText(user.getFirst());
        TextView tv2 = (TextView) findViewById(R.id.lastName);
        tv2.setText(user.getLast());
        TextView tv3 = (TextView) findViewById(R.id.emailAddress);
        tv3.setText(user.getEmail());
        TextView tv4 = (TextView) findViewById(R.id.userName);
        tv4.setText(user.getUserName());
        TextView tv5 = (TextView) findViewById(R.id.rating);
        tv5.setText(user.getRating());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_current_friend_detail, menu);
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
     * Delete Friend and changes the screen back to the current friend list screen
     * @param v the button being clicked
     */
    public void deleteFriendOnClick(View v) {
        Intent intent = getIntent();
        String key = intent.getStringExtra("email");
        HashMap<String, User> friends = UserActivity.loggedInUser.getFriendList();
        User user = friends.get(key);

        UserActivity.loggedInUser.deleteFriend(user);

        startActivity(new Intent(this, CurrentFriendListActivity.class));
    }


}
