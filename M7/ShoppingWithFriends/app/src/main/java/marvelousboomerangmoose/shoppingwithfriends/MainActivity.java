package marvelousboomerangmoose.shoppingwithfriends;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

import marvelousboomerangmoose.shoppingwithfriends.util.Persistence;

/**
 * The screen that is visible upon startup.  Has the login and and registration buttons.
 */
public class MainActivity extends ActionBarActivity {

    /*if (LoginActivity.loggedIn == 1) {
        startActivity(new Intent(this, HomeActivity.class));
    }*/


    public static HashMap<String, Product> productList = new HashMap<String, Product>();//TODO: getters?
    public UserActivity users;

    static MainActivity obj;
    public static File USER_FILE;//TODO: getters?
    public static File PRODUCT_FILE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        obj = this;
        USER_FILE = new File(obj.getFilesDir(), "users.bin");
        PRODUCT_FILE = new File(obj.getFilesDir(), "products.bin");
        users = new UserActivity();//TODO: Not sure if this is the best way to do this


        if (USER_FILE.exists() && PRODUCT_FILE.exists()) {
            Log.d("FILES EXIST", "Attempting to Load");
            Persistence.loadBinary();
        } else {//TODO: Possibly rework this as else ifs
            Log.d("USER_FILE DOES NOT EXIST", "Attempting to Create");
            if (!USER_FILE.exists()) {
                try {
                    USER_FILE.createNewFile();
                    Log.d("CREATING USER_FILE", "File Created Successfully");
                } catch (IOException e) {
                    Log.e("USER_FILE CREATION", "Error Creation Failed");
                }
            }
            if (!PRODUCT_FILE.exists()) {
                try {
                    PRODUCT_FILE.createNewFile();
                    Log.d("CREATING PRODUCT_FILE", "File Created Successfully");
                } catch (IOException e) {
                    Log.e("PRODUCT_FILE CREATION", "Error Creation Failed");
                }
            }

            if (UserActivity.credentials.isEmpty()) {
                Log.d("ADDING CREDENTIALS", "Attempting to add default credentials");

                UserActivity.credentials.put("admin", new User("Robbie", "Hooke", "admin@shop.moose", "admin", "pass"));
                UserActivity.credentials.put("user", new User("Derrick", "Williams", "user@shop.moose", "user", "pass"));
                UserActivity.credentials.put("new", new User("Richard", "Wang", "new@shop.moose", "new", "pass"));
            }

            if (productList.isEmpty()) {
                Log.d("ADDING PRODUCTS", "Attempting to add default products");

                productList.put("X-box", new Product("X-box", 0.1));
                productList.put("Arm Chair", new Product("Arm Chair", 0.1));
                productList.put("Laundry Bag", new Product("Laundry Bag", 0.1));

            }
            Persistence.saveBinary();
        }


    }

    /**
     * When the login button is clicked, this transitions to the login screen.
     *
     * @param v the button being clicked
     */
    public void buttonLoginOnClick(View v) {startActivity(new Intent(this, LoginActivity.class));}

    /**
     * When the registration button is clicked, this transitions to the registration screen.
     *
     * @param v the button being clicked
     */
    public void buttonRegOnClick(View v) {startActivity(new Intent(this, RegActivity.class));}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}
