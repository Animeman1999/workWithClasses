package edu.kvcc.cis298.workwithclasses.workwithclasses;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {

    private TextView mResult;
    private EditText mInput;
    private Button mSubmit;
    private Button mActivity;
    private Calc myCalc;   // create an instance of the class we created.

    private double result; //7777777777777777777777777777777777777777777777777  needs to be global to be accessed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResult = (TextView) findViewById(R.id.result_text_view);
        mInput = (EditText) findViewById(R.id.number_input);
        mSubmit = (Button) findViewById(R.id.submit_button);
        mActivity = (Button) findViewById(R.id.new_activity_button);//////88888888888888888888888888888888888888888888

        myCalc = new Calc();

        if (savedInstanceState != null) {//7777777777777777777777777777777777777777777777777777777777777777777777777777777777
            result = savedInstanceState.getDouble("theKey", 0); //  pull out the value that was saved when OnSaveInstanceState was called
            mResult.setText(Double.toString(result)); //  put it back in as we did when OnClickListener was added
        }

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double input = Double.parseDouble( mInput.getText().toString());
                result = myCalc.multiplyByFour(input);
                mResult.setText(Double.toString(result));

            }
        });




        //////88888888888888888888888888888888888888888888888888888888888888888888    lauanch new intent
        mActivity.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View view){
                    Intent i = SubActivity.newIntent(MainActivity.this, "This is my message");
                    startActivityForResult(i, 1234);  //// add the intent you created and a unique code we created
                }
                                     }
        );

    }

    @Override//////777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDouble("theKey", result);  //  savinig "result" into the bundle
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  ///// we created this when we ran an Activity 888888888888888888888888888888
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != Activity.RESULT_OK){
            //  DO WORK BECAUSE IT WASN'T SUCCESSFUL

            //Use the return statement to get out of this overridden method.
            return;
        }
        if (requestCode == 1234) {
            if (data != null){
                // do work. not sure what yet
                boolean beenThere = SubActivity.userWentToSubActivity(data);
                if (beenThere){
                    Toast.makeText(MainActivity.this, "User went there", Toast.LENGTH_SHORT).show();
                }

            }
        }
        else if (requestCode == 5678){

        }
    }

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
}
