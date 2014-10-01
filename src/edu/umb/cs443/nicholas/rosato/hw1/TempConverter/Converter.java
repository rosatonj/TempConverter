package edu.umb.cs443.nicholas.rosato.hw1.TempConverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Converter extends Activity {
    EditText temperature;
    TextView answer;
    Button convertButton;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityconverter);

        temperature = (EditText) findViewById(R.id.editText_Temp);
        answer = (TextView) findViewById(R.id.textView_Answer);
        convertButton = (Button) findViewById(R.id.button_convert);

        //declare default fields
        temperature.setHint("temp");
        answer.setText("");

        //make the magic happen when the convert button is clicked
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double far = Double.parseDouble(temperature.getText().toString());//grab the number from the editText
                double ans = (far - 32) *  5/9;

                String str = String.format( "is %.3f Celsius", ans);
                answer.setText(str);
            }
        });
    }
}