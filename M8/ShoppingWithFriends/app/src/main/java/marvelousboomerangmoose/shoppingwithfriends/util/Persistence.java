package marvelousboomerangmoose.shoppingwithfriends.util;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import marvelousboomerangmoose.shoppingwithfriends.MainActivity;
import marvelousboomerangmoose.shoppingwithfriends.Product;
import marvelousboomerangmoose.shoppingwithfriends.User;
import marvelousboomerangmoose.shoppingwithfriends.UserActivity;

/**
 * In charge of saving and loading binary files
 */
public class Persistence{
    private static Integer bla = 4;

    public Persistence() {
    }

    /**
     * Saves credentials and product list to the binary file
     */
    public static void saveBinary() {
        if (MainActivity.USER_FILE.exists()) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(MainActivity.USER_FILE));
                out.writeObject(UserActivity.credentials);
                Log.d("USER_FILE SAVED:", UserActivity.credentials.toString());

                out.close();
            } catch (IOException e) {
                Log.e("USER_FILE:", "Error writing an entry from binary file");
            }
        } else {
            Log.d("USER_FILE SAVE:", "File Does Not Exist");
        }

        if (MainActivity.PRODUCT_FILE.exists()) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(MainActivity.PRODUCT_FILE));
                out.writeObject(MainActivity.productList);
                Log.d("PRODUCT_FILE SAVED:", MainActivity.productList.toString());

                out.close();
            } catch (IOException e) {
                Log.e("PRODUCT_FILE:", "Error writing an entry from binary file");
            }
        } else {
            Log.d("PRODUCT_FILE SAVE:", "File Does Not Exist");
        }
    }

    /**
     * Loads credentials and product list from the binary file
     */
    public static void loadBinary() {
        try {
            ObjectInputStream user_in = new ObjectInputStream(new FileInputStream(MainActivity.USER_FILE));
            //all objects to be loaded

            HashMap<String, User> cred = (HashMap<String, User>) user_in.readObject();
            UserActivity.credentials.clear();
            UserActivity.credentials.putAll(cred);
            Log.d("LOAD-Loaded Cred:", cred.toString());
            Log.d("LOAD-Current Cred:", UserActivity.credentials.toString());
            user_in.close();
        } catch (IOException e) {
            Log.e("USER_FILE:", "Error reading an entry from binary file");
        } catch (ClassNotFoundException e) {
            Log.e("USER_FILE:", "Error casting a class from the binary file");
        }
        try {
            ObjectInputStream product_in = new ObjectInputStream(new FileInputStream(MainActivity.PRODUCT_FILE));
            //all objects to be loaded

            HashMap<String, Product> prod = (HashMap<String, Product>) product_in.readObject();
            MainActivity.productList.clear();
            MainActivity.productList.putAll(prod);
            Log.d("LOAD-Loaded Prod:", prod.toString());
            Log.d("LOAD-Current Prod:", MainActivity.productList.toString());
            product_in.close();
        } catch (IOException e) {
            Log.e("PRODUCT_FILE:", "Error reading an entry from binary file");
        } catch (ClassNotFoundException e) {
            Log.e("PRODUCT_FILE:", "Error casting a class from the binary file");
        }

    }

}
