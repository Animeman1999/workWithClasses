package edu.kvcc.cis298.workwithclasses.workwithclasses;
//   THIS IS THE NEW INTENT WE CREATED BY RIGHT CLICKING ON TE JAVA FILE CREATING NEW > ACTIVITY > BLANK
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
/////// passed in who wants to initiate this activity and the string we would like is passed in

    private TextView mMessage;
    private boolean mBeenThereDoneThat;

    public static Intent newIntent(Context packageContext, String theMessage){//Method we created to create the intent
        Intent i = new Intent(packageContext, SubActivity.class);
        i.putExtra("the_sub_key", theMessage);///////////////////////////88888888888888888888888888888888888
        return i;
    }

    public static boolean userWentToSubActivity(Intent result){
        return result.getBooleanExtra("been_there_key", false);////  get back the boolean value includes key and a default value
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //////////////////////////////////888888888888888888888888888888888888888888888
        mMessage = (TextView) findViewById(R.id.message);
        String theMessageString = getIntent().getStringExtra("the_sub_key");
        mMessage.setText(theMessageString);

         mBeenThereDoneThat = true;

        Intent data = new Intent();  //////    new intent to pass back a vaule;
        data.putExtra("been_there_key", mBeenThereDoneThat);
        setResult(RESULT_OK, data);  ///     pass the data by using the method setResult
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub, menu);
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
