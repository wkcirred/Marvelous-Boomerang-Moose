package marvelousboomerangmoose.shoppingwithfriends;

import android.content.ClipData;
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


public class ItemListActivity extends ActionBarActivity {
    private static HashMap<String,Product> hashMap;
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
    public void buttonHomeOnClick(View v){
        startActivity(new Intent(this, HomeActivity.class));
    }
    public void buttonAddItemOnClick(View v){
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
