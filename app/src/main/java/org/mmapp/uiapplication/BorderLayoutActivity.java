package org.mmapp.uiapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * <p><br>
 * <b>BorderLayoutActivity</b><br>
 * The activity creates a border-layout example with a north, west,
 * center, east and south labeled text view.
 * </p><br>
 *
 * @author Erik Roemmelt
 */
public class BorderLayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_border_layout);
    }
}
