package marvelousboomerangmoose.shoppingwithfriends;


import 	android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;


public class AddFriendActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_friend, menu);
        return true;
    }

    public void addFriendCancelOnClick(View v){
        //Button button=(Button) v;
        startActivity(new Intent(this, HomeActivity.class));
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
    final Context context = this;
    public void addFriendButtonOnClick(View v){
        EditText friendFirst, friendLast, friendEmail;
        friendFirst = (EditText)findViewById(R.id.friendFirst);
        friendLast = (EditText)findViewById(R.id.friendLast);
        friendEmail = (EditText)findViewById(R.id.friendEmail);
        if(friendFirst.getText().toString().matches("")||
           friendLast.getText().toString().matches("")||
           friendEmail.getText().toString().matches("")){
            String errorMessage = "";
            if (friendFirst.getText().toString().matches("")){
                errorMessage += "Your Friend Must have a first name\n";
            }
            if (friendLast.getText().toString().matches("")){
                errorMessage += "Your Friend Must have a last name\n";
            }
            if (friendEmail.getText().toString().matches("")){
                errorMessage += "Your Friend Must have a last email";
            }

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

            // set title
            alertDialogBuilder.setTitle("Invalid Input");

            // set dialog message
            alertDialogBuilder
                    .setMessage(errorMessage)
                    .setCancelable(false)
//                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog,int id) {
//                        // if this button is clicked, close
//                        // current activity
//                        AddFriendActivity.this.finish();
//                    }
//                })
                    .setNegativeButton("OK",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                        }
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }

    }
}
