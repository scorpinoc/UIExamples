package com.github.scorpinoc.uiexamples;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import java.util.Random;

public class GridLayoutActivity extends BaseGetTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);

        GridLayout grid = findViewById(R.id.layout_grid);

        Boolean noUnique = false;
        Random random = new Random();
        int pixels = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                50, getResources().getDisplayMetrics());

        for (int i = 0; i < 150; i++) {
            View view = new View(this);
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
            layoutParams.width = pixels;
            layoutParams.height = pixels;
            if (noUnique) {
                view.setBackgroundResource(android.R.drawable.alert_light_frame);
            } else {
                view.setBackgroundResource(android.R.color.holo_red_light);
                layoutParams.columnSpec = GridLayout.spec(random.nextInt(6));
                layoutParams.rowSpec = GridLayout.spec(random.nextInt(12));
                noUnique = true;
            }
            view.setLayoutParams(layoutParams);
            grid.addView(view);
        }
    }
}
