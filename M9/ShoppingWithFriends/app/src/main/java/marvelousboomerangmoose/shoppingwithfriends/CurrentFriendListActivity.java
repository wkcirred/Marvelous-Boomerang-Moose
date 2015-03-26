package marvelousboomerangmoose.shoppingwithfriends;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import marvelousboomerangmoose.shoppingwithfriends.Model.User;
import marvelousboomerangmoose.shoppingwithfriends.Model.UserActivity;

/**
 * Current Friend List Activity displays all of your current friends with basic information
 * including first name, last name, and email.
 */
@SuppressWarnings("ALL")
public class CurrentFriendListActivity extends ActionBarActivity {
<<<<<<< HEAD
    //private Intent intent;
=======
>>>>>>> origin/master
    private static ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_friend_list);
        arrayList = new ArrayList<>();
        ListView myListView = (ListView) this.findViewById(R.id.listView);
        ArrayAdapter listAdapter = new ArrayAdapter<>(this,R.layout.simplerow, arrayList);
        Log.d("Logged In User:", UserActivity.loggedInUser.toString());
        HashMap<String, User> friends = UserActivity.loggedInUser.getFriendList();
        if (friends != null && !friends.isEmpty()) {
            for (final String key : friends.keySet()) {
                User friend = friends.get(key);
                listAdapter.add(friend.getFirst() + " " + friend.getLast() + " " + friend.getEmail());
                myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Object object = parent.getItemAtPosition(position);
                        String item = (String) object;
                        item = item.substring(item.lastIndexOf(" ") + 1);
                        Intent intent = new Intent(CurrentFriendListActivity.this, CurrentFriendDetailActivity.class);
                        intent.putExtra("email", item);
                        startActivity(intent);
                    }
                });
            }
        }
        myListView.setAdapter(listAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_friend_list, menu);
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
     * Changes to add friend activity screen
     * @param v - button is clicked
     */
    public void addFriendButtonOnClick(View v){
        //Does nothing but to eliminate a analyzing error
        v.getId();
        startActivity(new Intent(this, AddFriendActivity.class));
    }

    /**
     * Changes back to home screen
     * @param v - button is clicked
     */
    public void homeButtonOnClick(View v){
        //Does nothing but to eliminate a analyzing error
        v.getId();
        startActivity(new Intent(this, HomeActivity.class));
    }

}
