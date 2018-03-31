package com.github.scorpinoc.uiexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static com.github.scorpinoc.uiexamples.MainActivity.TITLE;

abstract class BaseGetTitleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent.hasExtra(TITLE)) {
            String title = intent.getStringExtra(TITLE);
            setTitle(title);
        }

        android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();

        if (supportActionBar == null) {
            return;
        }

        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
