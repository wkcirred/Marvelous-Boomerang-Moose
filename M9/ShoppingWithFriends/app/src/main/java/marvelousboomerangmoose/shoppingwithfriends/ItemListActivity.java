package marvelousboomerangmoose.shoppingwithfriends;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import marvelousboomerangmoose.shoppingwithfriends.Model.UserActivity;

/**
 * ItemListActivity displays all the current items of interest for currently logged in user.
 *
 */
public class ItemListActivity extends ActionBarActivity {
    // --Commented out by Inspection (3/26/15, 7:30 PM):private static HashMap<String,Product> hashMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        ListView myListView = (ListView) this.findViewById(R.id.listView);// not sure
        //MainActivity.loggedInUser.addItem(new Product("Dish",1.00));
        MyAdapter adapter = new MyAdapter(UserActivity.loggedInUser.getItemList());
        myListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item_list, menu);
        return true;
    }

    /**
     * Button to click that takes the user to the HomeActivity
     * @param v - the button being clicked
     */
    public void buttonHomeOnClick(View v){
        //Does nothing but to eliminate a analyzing error
        v.getId();
        startActivity(new Intent(this, HomeActivity.class));
    }

    /**
     * Button to click that takes the user to the AddItemActivity
     * @param v - - the button being clicked
     */
    public void buttonAddItemOnClick(View v){
        //Does nothing but to eliminate a analyzing error
        v.getId();
        startActivity(new Intent(this, AddItemActivity.class));
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
