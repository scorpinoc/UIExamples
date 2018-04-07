package com.github.scorpinoc.uiexamples.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.scorpinoc.uiexamples.BaseGetTitleActivity;
import com.github.scorpinoc.uiexamples.R;

public class LinearLayoutActivity extends BaseGetTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
    }
}
