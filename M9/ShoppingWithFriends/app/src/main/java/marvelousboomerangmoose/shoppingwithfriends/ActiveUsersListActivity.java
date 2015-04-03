package marvelousboomerangmoose.shoppingwithfriends;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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
 * Displays a screen with a list of the active users.
 */
@SuppressWarnings("FieldCanBeLocal")
public class ActiveUsersListActivity extends ActionBarActivity {
    private static ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_users_list);

        arrayList = new ArrayList<>();
        ListView myListView = (ListView) this.findViewById(R.id.listView);
        ArrayAdapter listAdapter = new ArrayAdapter<>(this,R.layout.simplerow, arrayList);
        HashMap<String, User> users = UserActivity.getCredentials();
        for (String key : users.keySet()) {
            User user = users.get(key);
            //noinspection unchecked
            listAdapter.add(user.getFirst() + " " + user.getLast() + " " + user.getEmail());
            myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Object object = parent.getItemAtPosition(position);
                    String item = (String) object;
                    item = item.substring(item.lastIndexOf(" ") + 1);
                    Intent intent = new Intent(ActiveUsersListActivity.this,ActiveUsersDetailActivity.class);
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
        getMenuInflater().inflate(R.menu.menu_active_users_list, menu);
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
}
