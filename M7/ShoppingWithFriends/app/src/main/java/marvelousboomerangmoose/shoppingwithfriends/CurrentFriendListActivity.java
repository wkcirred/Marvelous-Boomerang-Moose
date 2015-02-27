package marvelousboomerangmoose.shoppingwithfriends;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import android.util.Log;
import android.widget.Toast;

public class CurrentFriendListActivity extends ActionBarActivity {
    //private Intent intent;
    private String message;
    private static ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            //intent = getIntent();
            setContentView(R.layout.activity_current_friend_list);
            arrayList = new ArrayList<>();
            ListView myListView = (ListView) this.findViewById(R.id.listView);
            ArrayAdapter listAdapter = new ArrayAdapter<>(this,R.layout.simplerow, arrayList);
            HashMap<String, User> friends = MainActivity.loggedInUser.getFriendList();
            for (final String key : friends.keySet()) {
                //Log.d("Email:",key);
                User friend = friends.get(key);
                listAdapter.add(friend.getFirst() + " " + friend.getLast() + " " + friend.getEmail());
                myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Object object = parent.getItemAtPosition(position);
                        String item = (String) object;
                        item = item.substring(item.lastIndexOf(" ") + 1);
                        //item = item.split();
                        Intent intent = new Intent(CurrentFriendListActivity.this,CurrentFriendDetailActivity.class);
                        intent.putExtra("email",item);
                        startActivity(intent);
                    }
                });
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
        startActivity(new Intent(this, AddFriendActivity.class));
    }

    /**
     * Changes back to home screen
     * @param v - button is clicked
     */
    public void homeButtonOnClick(View v){
        startActivity(new Intent(this, HomeActivity.class));
    }

}
