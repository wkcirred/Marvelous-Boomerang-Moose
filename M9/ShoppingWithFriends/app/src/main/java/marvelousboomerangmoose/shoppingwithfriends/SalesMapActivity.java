package marvelousboomerangmoose.shoppingwithfriends;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.List;
import android.util.DisplayMetrics;
import java.io.IOException;

import marvelousboomerangmoose.shoppingwithfriends.Model.Product;


/**
 * Sales Map Activity creates a map instance showing all of the sales that meet this particular
 * User's criteria.  If not data is present, Sales Map Activity never is called from Home Activity.
 */
public class SalesMapActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private LatLngBounds mapView;  //mapView for camera position and size

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera.
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     * Method never gets called if nothing for map to show.
     */
    private void setUpMap() {
        Geocoder coder = new Geocoder(this);
        List<Address> addressList;
        double latitude;
        double longitude;
        double currentLatitude = 33.77737;      // Location of COC building
        double currentLongitude = -84.39739;    // Location of COC building
        double minLatitude = currentLatitude;
        double maxLatitude = currentLatitude;
        double minLongitude = currentLongitude;
        double maxLongitude = currentLongitude;

        // Set current location at COC building, really no other way unless Robbie is using his
        // phone
        addMarker(currentLatitude,currentLongitude,"Current Location",null);

        // Obtaining interest list processed already in HomeActivity, Robbie maybe we pass this
        // through a method?
        HashMap<String, Product> interestAlert = HomeActivity.interestAlert;

        // Go through each sales product that is cheaper than interest
        for (String key : interestAlert.keySet()) {
            Product p = interestAlert.get(key);

            // Need try/catch block to process geocode address
            try {
                // Process geocode address into five potentials
                addressList = coder.getFromLocationName(p.getLocation(), 5);
                // Obtain first geocode address
                Address location = addressList.get(0);
                latitude = location.getLatitude();
                longitude = location.getLongitude();

                // Add marker to map
                addMarker(location.getLatitude(),location.getLongitude(),p.getStoreName()
                        ,p.getName());

                // For figuring out proper camera size and position
                minLatitude = Math.min(latitude,minLatitude);
                maxLatitude = Math.max(latitude,maxLatitude);
                minLongitude = Math.min(longitude,minLongitude);
                maxLongitude = Math.max(longitude,maxLongitude);

            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        // Set boundary for camera position
        mapView = new LatLngBounds(new LatLng(minLatitude, minLongitude)
            , new LatLng(maxLatitude, maxLongitude));

        // Obtain display metrics from emulator screen
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        // Move camera to location that shows all sale items and give buffer around them to make
        // sure that markers are completely shown.
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(mapView, width, height, 175));
    }

    /**
     * Helper function to save a marker to the map
     * @param latitude - latitude of store
     * @param longitude - longitude of store
     * @param title - store name
     * @param item - item name
     */
    private void addMarker(double latitude, double longitude, String title, String item) {
        // 1) Current location case 2) all other cases
        if (item == null) {
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(latitude, longitude))
                    .title(title));
        } else {
            mMap.addMarker(new MarkerOptions()
                .position(new LatLng(latitude, longitude))
                .title("Store: " + title)
                .snippet("Item: " + item));
        }
    }
}
