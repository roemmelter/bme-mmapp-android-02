package org.mmapp.uiapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * <p><br>
 * <b>MainActivity</b><br>
 * The activity creates a button for each Activity in ACTIVITY_LIST.
 * The pressed button starts on click the labeled activity.
 * </p><br>
 *
 * @author Erik Roemmelt
 */
public class MainActivity extends AppCompatActivity {

    private final String PACKAGE_BASE = "org.mmapp";
    private final String PACKAGE_UIAPPLICATION = ".uiapplication";
    private final String[] ACTIVITY_LIST = {
            PACKAGE_BASE + PACKAGE_UIAPPLICATION + ".AboutActivity",
            PACKAGE_BASE + PACKAGE_UIAPPLICATION + ".BorderLayoutActivity",
            PACKAGE_BASE + PACKAGE_UIAPPLICATION + ".ButtonActivity",
            PACKAGE_BASE + PACKAGE_UIAPPLICATION + ".CalculatorActivity",
            PACKAGE_BASE + PACKAGE_UIAPPLICATION + ".DialogActivity",
            PACKAGE_BASE + PACKAGE_UIAPPLICATION + ".MenuActivity",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout ll = new LinearLayout(this);
        ll.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        ll.setBackgroundColor(0x20FFFFFF);
        ll.setOrientation(LinearLayout.VERTICAL);

        for (String activity : ACTIVITY_LIST) {
            ll.addView(createButtonForActivity(this, activity));
        }

        setContentView(ll);
    }


    protected Button createButtonForActivity(Context ctx, String activity) {
        String btnLabel = activity.substring(activity.lastIndexOf(".")+1);
        Button btn = new Button(ctx);
        btn.setTypeface(Typeface.create(
                "sans-serif", Typeface.NORMAL));
        btn.setTransformationMethod(null);
        btn.setText(btnLabel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),
                               "Button '" + btnLabel + "' was clicked",
                               Toast.LENGTH_SHORT)
                        .show();
                try {
                    Class<?> classToStart = Class.forName(activity);
                    Intent intent = new Intent(ctx, classToStart);
                    startActivity(intent);
                } catch (ClassNotFoundException ignored) {
                    Log.e("MainActivity", ignored.getException().toString());
                    Toast.makeText(v.getContext(),
                                   "Activity '" + btnLabel + "' not found.",
                                   Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
        return btn;
    }
}
