package edu.umb.cs443.nicholas.rosato.hw1.TempConverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_Converter extends Activity {
    EditText temperature;
    Button convertButton;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityconverter);

        temperature = (EditText) findViewById(R.id.editText_Temp);
        convertButton = (Button) findViewById(R.id.button_convert);

        //declare default fields
        temperature.setHint("temp");

        //make the magic happen when the convert button is clicked
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double far = Double.parseDouble(temperature.getText().toString());//grab the number from the editText
                double ans = (far - 32) *  5/9; //perform calculation
                String str = String.format( "is %.3f ° Celsius", ans); //make a string to be passed

                //make an intent to switch between activities
                Intent intent = new Intent(Activity_Converter.this, Activity_Answer.class);

                //create a new bundle and put stuff in it.
                Bundle bundle = new Bundle();
                bundle.putDouble("far", far);
                bundle.putString("answer", str);
                //package the bundle in the intent
                intent.putExtras(bundle);

                //launch the next activity
                startActivity(intent);

            }
        });
    }
}