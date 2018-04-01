package com.github.scorpinoc.uiexamples.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.scorpinoc.uiexamples.BaseGetTitleActivity;
import com.github.scorpinoc.uiexamples.R;

public class RelativeLayoutActivity extends BaseGetTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
    }
}
