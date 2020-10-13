package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class PaletteActivity extends AppCompatActivity {

    GridView gridView;

    // this needs to occur after onCreate()
   // Resources res = getApplicationContext().getResources();
   // String[] colors = res.getStringArray(R.array.my_colors);
    public static final String COLOR_KEY = "colorkey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getApplicationContext().getResources();
        String[] colors = res.getStringArray(R.array.my_colors);

        // Set the title of the activity to be Palette Activity instead of the app name
        getSupportActionBar().setTitle("Palette Activity");

        gridView = findViewById(R.id.gridView);
        gridView.setNumColumns(3);

        gridView.setAdapter(new ColorAdapter(this, colors));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(PaletteActivity.this, CanvasActivity.class)
                .putExtra(COLOR_KEY, parent.getItemAtPosition(position).toString()));
            }
        });

    }
}