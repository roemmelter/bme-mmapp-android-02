package org.mmapp.uiapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * <p><br>
 * <b>ButtonActivity</b><br>
 * Activity with a button shows up a toast on click.
 * </p><br>
 *
 * @author Erik Roemmelt
 */
public class ButtonActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Button was clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
