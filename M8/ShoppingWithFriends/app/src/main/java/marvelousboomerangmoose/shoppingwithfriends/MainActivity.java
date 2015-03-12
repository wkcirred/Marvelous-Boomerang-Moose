package marvelousboomerangmoose.shoppingwithfriends;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.util.ArrayList;

import marvelousboomerangmoose.shoppingwithfriends.Model.Persistence;
import marvelousboomerangmoose.shoppingwithfriends.Model.UserActivity;

/**
 * The screen that is visible upon startup.  Has the login and and registration buttons.
 * Also, is the main class that runs everything currently.
 */
public class MainActivity extends ActionBarActivity {

    /*if (LoginActivity.loggedIn == 1) {
        startActivity(new Intent(this, HomeActivity.class));
    }*/



    public UserActivity users;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        //uncomment the following 2 lines of code to delete your product binary file and begin working on startup
        //PRODUCT_FILE.delete();
        //PRODUCT_FILE = new File(obj.getFilesDir(), "products.bin");
        users = new UserActivity();//TODO: Not sure if this is the best way to do this
        ArrayList<File> files = new ArrayList<File>();
        files.add(new File(this.getFilesDir(), "users.bin"));
        files.add(new File(this.getFilesDir(), "products.bin"));
        files.add(new File(this.getFilesDir(), "salesReport.bin"));
        Persistence.setUpBinary(files);



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
