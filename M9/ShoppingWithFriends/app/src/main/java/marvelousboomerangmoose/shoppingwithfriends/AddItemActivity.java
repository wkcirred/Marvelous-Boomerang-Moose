package marvelousboomerangmoose.shoppingwithfriends;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.EditText;
import java.util.ArrayList;

import marvelousboomerangmoose.shoppingwithfriends.Model.Persistence;
import marvelousboomerangmoose.shoppingwithfriends.Model.Product;
import marvelousboomerangmoose.shoppingwithfriends.Model.ProductActivity;
import marvelousboomerangmoose.shoppingwithfriends.Model.UserActivity;


/**
 * Add item activity that user is interested in.
 * User can add a new item or select from a few items already in the store.
 */
@SuppressWarnings("FieldCanBeLocal")
public class AddItemActivity extends ActionBarActivity {
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        arrayList = new ArrayList<>(ProductActivity.productList.keySet());
        ListView myListView = (ListView) this.findViewById(R.id.listView);
        ArrayAdapter listAdapter = new ArrayAdapter<>(this,R.layout.simplerow, arrayList);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object object = parent.getItemAtPosition(position);
                String item = (String) object;
                ((EditText) findViewById(R.id.nameTextEdit)).setText(item);
            }
        });
        myListView.setAdapter(listAdapter);
    }

    /**
     * Add item button that allows user to enter in the item of interest if successful information
     * is populated in the appropriate fields.
     * Will take the user back to ItemListActivity if successful.
     * @param v - button to click
     */
    public void buttonAddOnClick(View v){
        //Does nothing but to eliminate a analyzing error
        v.getId();
        String name =((EditText) findViewById(R.id.nameTextEdit)).getText().toString();
        String price = ((EditText) findViewById(R.id.priceTextEdit)).getText().toString();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        if (name.matches("")||price.matches("")){
            alertDialogBuilder.setMessage("Please enter name and price").setCancelable(false)
                    .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            alertDialogBuilder.setTitle("Invalid Input");
            alertDialogBuilder.show();
            return;

        }
        Product p = new Product(name, Double.parseDouble(price), "N/A", "N/A", 0);
        ProductActivity.productList.put(p.getName(), p);
        UserActivity.loggedInUser.addItem(p);
        Persistence.saveBinary();
        startActivity(new Intent(this, ItemListActivity.class));
    }

    /**
     * Returns to the previous screen.
     * @param v the button being pressed
     */
    public void buttonCancelOnClick(View v){
        //Does nothing but to eliminate a analyzing error
        v.getId();
        startActivity(new Intent(this, ItemListActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_item, menu);
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
