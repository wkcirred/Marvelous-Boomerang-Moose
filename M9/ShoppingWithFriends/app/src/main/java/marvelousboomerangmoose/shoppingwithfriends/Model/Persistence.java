package marvelousboomerangmoose.shoppingwithfriends.Model;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * In charge of saving and loading binary files
 */
public class Persistence{
    private static File USER_FILE;
    private static File PRODUCT_FILE;
    private static File SALES_REPORT_FILE;

    /**
     * Saves credentials and product list to the binary file
     */
    public static void saveBinary() {
        if (USER_FILE.exists()) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(USER_FILE));
                out.writeObject(UserActivity.getCredentials());
                Log.d("USER_FILE SAVED:", UserActivity.getCredentials().toString());
                out.flush();
                out.close();
            } catch (IOException e) {
                Log.e("USER_FILE:", "Error writing an entry from binary file");
            }
        } else {
            Log.d("USER_FILE SAVE:", "File Does Not Exist");
        }

        if (PRODUCT_FILE.exists()) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PRODUCT_FILE));
                out.writeObject(ProductActivity.productList);
                Log.d("PRODUCT_FILE SAVED:", ProductActivity.productList.toString());
                out.flush();
                out.close();
            } catch (IOException e) {
                Log.e("PRODUCT_FILE:", "Error writing an entry from binary file");
            }
        } else {
            Log.d("PRODUCT_FILE SAVE:", "File Does Not Exist");
        }

        if (SALES_REPORT_FILE.exists()) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SALES_REPORT_FILE));
                out.writeObject(ProductActivity.salesList);
                Log.d("SALES_REPORT_FILE SAVED:", ProductActivity.salesList.toString());
                out.flush();
                out.close();
            } catch (IOException e) {
                Log.e("SALES_REPORT_FILE:", "Error writing an entry from binary file");
            }
        } else {
            Log.d("SALES_REPORT_FILE SAVE:", "File Does Not Exist");
        }
    }

    /**
     * Loads credentials and product list from the binary file
     */
    private static void loadBinary() {
        try {
            ObjectInputStream user_in = new ObjectInputStream(new FileInputStream(USER_FILE));

            //ERROR WILL BE CAUGHT IN CATCH BLOCK
            @SuppressWarnings("unchecked") HashMap<String, User> cred = (HashMap<String, User>) user_in.readObject();
            UserActivity.setCredentials(cred);

            Log.d("LOAD-Loaded Cred:", cred.toString());
            Log.d("LOAD-Current Cred:", UserActivity.getCredentials().toString());
            user_in.close();
        } catch (IOException e) {
            Log.e("USER_FILE:", "Error reading an entry from binary file");
        } catch (ClassNotFoundException e) {
            Log.e("USER_FILE:", "Error casting a class from the binary file");
        } catch (ClassCastException e) {
            Log.e("USER_FILE", "Error casting class");
        }
        try {
            ObjectInputStream product_in = new ObjectInputStream(new FileInputStream(PRODUCT_FILE));

            //ERROR WILL BE CAUGHT IN CATCH BLOCK
            @SuppressWarnings("unchecked") HashMap<String, Product> prod = (HashMap<String, Product>) product_in.readObject();
            ProductActivity.productList.clear();
            ProductActivity.productList.putAll(prod);
            Log.d("LOAD-Loaded Prod:", prod.toString());
            Log.d("LOAD-Current Prod:", ProductActivity.productList.toString());
            product_in.close();
        } catch (IOException e) {
            Log.e("PRODUCT_FILE:", "Error reading an entry from binary file");
        } catch (ClassNotFoundException e) {
            Log.e("PRODUCT_FILE:", "Error casting a class from the binary file");
        } catch (ClassCastException e) {
            Log.e("PRODUCT_FILE", "Error casting class");
        }

        try {
            ObjectInputStream salesReport_in = new ObjectInputStream(new FileInputStream(SALES_REPORT_FILE));

            //ERROR WILL BE CAUGHT IN CATCH BLOCK
            @SuppressWarnings("unchecked") HashMap<String, Product> sales = (HashMap<String, Product>) salesReport_in.readObject();
            ProductActivity.salesList.clear();
            ProductActivity.salesList.putAll(sales);
            Log.d("LOAD-Loaded Sales:", sales.toString());
            Log.d("LOAD-Current Sales:", ProductActivity.salesList.toString());
            salesReport_in.close();
        } catch (IOException e) {
            Log.e("SALES_REPORT_FILE:", "Error reading an entry from binary file");
        } catch (ClassNotFoundException e) {
            Log.e("SALES_REPORT_FILE:", "Error casting a class from the binary file");
        } catch (ClassCastException e) {
            Log.e("SALES_REPORT_FILE", "Error casting class");
        }

    }

    public static void setUpBinary(ArrayList<File> files) {
        USER_FILE = files.get(0);
        PRODUCT_FILE = files.get(1);
        SALES_REPORT_FILE = files.get(2);
        if (USER_FILE.exists() && PRODUCT_FILE.exists() && SALES_REPORT_FILE.exists()) {
            Log.d("FILES EXIST", "Attempting to Load");
            loadBinary();
        } else {//TODO: Possibly rework this as else ifs
            Log.d("USER_FILE DOES NOT EXIST", "Attempting to Create");
            boolean success;
            if (!USER_FILE.exists()) {
                try {
                    success = USER_FILE.createNewFile();
                    if (success) {
                        Log.d("CREATING USER_FILE", "File Created Successfully");
                    } else {
                        Log.d("CREATING USER_FILE", "File Already Exists");
                    }
                } catch (IOException e) {
                    Log.e("USER_FILE CREATION", "Error Creation Failed");
                }
            }
            if (!PRODUCT_FILE.exists()) {
                try {
                    success = PRODUCT_FILE.createNewFile();
                    if (success) {
                        Log.d("CREATING PRODUCT_FILE", "File Created Successfully");
                    } else {
                        Log.d("CREATING PRODUCT_FILE", "File Already Exists");
                    }
                } catch (IOException e) {
                    Log.e("PRODUCT_FILE CREATION", "Error Creation Failed");
                }
            }
            if (!SALES_REPORT_FILE.exists()) {
                try {
                    success = SALES_REPORT_FILE.createNewFile();
                    if (success) {
                        Log.d("CREATING SALES_REPORT_FILE", "File Created Successfully");
                    } else {
                        Log.d("CREATING SALES_REPORT_FILE", "File Already Exists");
                    }
                } catch (IOException e) {
                    Log.e("SALES_REPORT_FILE CREATION", "Error Creation Failed");
                }
            }

            if (UserActivity.getCredentials().isEmpty()) {
                Log.d("ADDING CREDENTIALS", "Attempting to add default credentials");
                //users = new UserActivity();
                UserActivity.getCredentials().put("admin", new User("Robbie", "Hooke", "admin@shop.moose", "admin", "pass"));
                UserActivity.getCredentials().put("user", new User("Derrick", "Williams", "user@shop.moose", "user", "pass"));
                UserActivity.getCredentials().put("new", new User("Richard", "Wang", "new@shop.moose", "new", "pass"));
            }

            if (ProductActivity.productList.isEmpty()) {
                Log.d("ADDING PRODUCTS", "Attempting to add default products");

                ProductActivity.productList.put("X-box", new Product("X-box", 0.1, "N/A", "N/A", 0));
                ProductActivity.productList.put("Arm Chair", new Product("Arm Chair", 0.1, "N/A", "N/A", 0));
                ProductActivity.productList.put("Laundry Bag", new Product("Laundry Bag", 0.1, "N/A", "N/A", 0));

            }
            saveBinary();
        }
    }
}
