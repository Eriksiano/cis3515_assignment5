package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;


/**
 * The title for this activity is set in the AndroidManifest file. It's another options
 * instead of calling setTitle() on the ActionBar.
 */
public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        // Retrieve stored color value
        String color = getIntent().getStringExtra(PaletteActivity.COLOR_KEY);

        // Change text value
        ((TextView) findViewById(R.id.colorDisplayTextView)).setText(color);

        // Change layout background color
        findViewById(R.id.container).setBackgroundColor(Color.parseColor(color));
    }
}