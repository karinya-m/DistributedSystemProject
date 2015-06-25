package ds.project4task3;

import java.util.Calendar;

import ds.project4task3.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

/**
 * This class extends from Activity. It handles activity in the app.
 *
 * @author Karinya
 */
public class AgeActivity extends Activity {

    /**
     * This method is called when created and set up the listener.
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // The click listener can reference to this object,           
        final AgeActivity ageActivity = this;
        Button submitButton = (Button) findViewById(R.id.submit);
        // Add a listener to the send button
        submitButton.setOnClickListener(new OnClickListener() {
            /**
             * Once it is clicked, date of birth is pass to constructor of
             * GetPersonAge
             */
            public void onClick(View viewParam) {
                long DoB = ((CalendarView) findViewById(R.id.calendarView1)).getDate();
                Calendar date = Calendar.getInstance();
                date.setTimeInMillis(DoB);
                GetPersonAge personAge = new GetPersonAge();
                personAge.getAge(date, ageActivity); // Done asynchronously in another thread.
            }
        });
    }

    /**
     * This is called by the GetPersonAge object when the age is ready.
     *
     * @param resultString
     */
    public void showResult(String resultString) {
        TextView feedbackView = (TextView) findViewById(R.id.feedback);
        feedbackView.setText(resultString);
    }
}