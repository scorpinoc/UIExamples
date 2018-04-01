package com.github.scorpinoc.uiexamples.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.scorpinoc.uiexamples.BaseGetTitleActivity;
import com.github.scorpinoc.uiexamples.R;

public class FrameLayoutActivity extends BaseGetTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        View imageOne = findViewById(R.id.img_one);
        View imageTwo = findViewById(R.id.img_two);

        imageOne.setOnClickListener(e -> {
            imageOne.setVisibility(View.GONE);
            imageTwo.setVisibility(View.VISIBLE);
        });

        imageTwo.setOnClickListener(e -> {
            imageTwo.setVisibility(View.GONE);
            imageOne.setVisibility(View.VISIBLE);
        });
    }
}
