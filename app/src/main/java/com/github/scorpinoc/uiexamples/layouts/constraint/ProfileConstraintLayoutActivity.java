package com.github.scorpinoc.uiexamples.layouts.constraint;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.github.scorpinoc.uiexamples.BaseGetTitleActivity;
import com.github.scorpinoc.uiexamples.R;
import com.github.scorpinoc.uiexamples.layouts.ConstraintLayoutActivity;

import static com.github.scorpinoc.uiexamples.MainActivity.TITLE;
import static com.github.scorpinoc.uiexamples.layouts.ConstraintLayoutActivity.*;

public class ProfileConstraintLayoutActivity extends BaseGetTitleActivity {

    @SuppressLint("ApplySharedPref")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_constraint_layout);

        SharedPreferences preferences = getSharedPreferences(USER_DATA, MODE_PRIVATE);

        ((TextView)findViewById(R.id.text_login)).setText(preferences.getString(LOGIN, "no login"));
        ((TextView)findViewById(R.id.text_password)).setText(preferences.getString(PASSWORD, "no password"));
        ((TextView)findViewById(R.id.text_name)).setText(preferences.getString(NAME, "no name"));

        findViewById(R.id.btn_log_off)
                .setOnClickListener(e -> {

                    preferences
                            .edit()
                            .putBoolean(LOGGED_IN, false)
                            .commit();

                    Intent intent = new Intent(
                            ProfileConstraintLayoutActivity.this,
                            ConstraintLayoutActivity.class);

                    intent.putExtra(TITLE, getString(R.string.btn_layouts_constraint));

                    startActivity(intent);
                });
    }
}
