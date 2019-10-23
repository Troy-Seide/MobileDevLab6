package edu.temple.otherlab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements PaletteFragment.OnColorSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] androidColors = getResources().getStringArray(R.array.engcolorarray);
        final String[] colorNames = getResources().getStringArray(R.array.spancolorarray);

        PaletteFragment palleteFragment = PaletteFragment.newInstance(androidColors, colorNames);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.backgroundactivity, palleteFragment)
                .commit();
    }

    @Override
    public void onColorSelected(int position) {
        final String[] androidColors = getResources().getStringArray(R.array.engcolorarray);
        CanvasFragment canvasFragment = CanvasFragment.newInstance(androidColors, position);
        final ConstraintLayout backgroundcolor= (ConstraintLayout)findViewById(R.id.backgroundactivity);
        backgroundcolor.setBackgroundColor(Color.parseColor((String) androidColors[position]));
        //TextView view=(TextView)findViewById(R.id.);
        //view.setBackgroundColor(Color.WHITE);
        getSupportFragmentManager().beginTransaction()
                //.replace(R.id.main_layout, canvasFragment)
                .addToBackStack(null)
                .add(R.id.backgroundactivity, canvasFragment)
                .commit();
    }
}
