package marvelousboomerangmoose.shoppingwithfriends;

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


public class MainActivity extends ActionBarActivity {

    /*if (LoginActivity.loggedIn == 1) {
        startActivity(new Intent(this, HomeActivity.class));
    }*/
    public static HashMap<String, User> credentials = new HashMap<String, User>();
    public static User loggedInUser = null;
    //public static HashMap<String, ArrayList<Product>> productList = new HashMap<String, ArrayList<Product>>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        credentials.put("admin", new User("Robbie", "Hooke", "admin@shop.moose", "admin", "pass"));
        credentials.put("user", new User("Derrick", "Williams", "user@shop.moose", "user", "pass"));
        credentials.put("new", new User("Richard", "Wang", "new@shop.moose", "new", "pass"));

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
