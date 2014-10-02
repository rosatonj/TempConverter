package edu.umb.cs443.nicholas.rosato.hw1.TempConverter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by nrosato on 10/1/14.
 */
public class Activity_Answer extends Activity {
    TextView answer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityanswer);

        Bundle bundle = getIntent().getExtras();
        String str = bundle.getString("answer"); //get answer string
        double far = bundle.getDouble("far"); //get original farenheit value

        answer = (TextView) (findViewById(R.id.textView_answer));
        answer.setText(far + " ° F " + str);
    }
}