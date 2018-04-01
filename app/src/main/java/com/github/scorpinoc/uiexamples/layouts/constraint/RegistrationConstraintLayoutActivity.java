package com.github.scorpinoc.uiexamples.layouts.constraint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.scorpinoc.uiexamples.R;

import static com.github.scorpinoc.uiexamples.MainActivity.TITLE;
import static com.github.scorpinoc.uiexamples.layouts.ConstraintLayoutActivity.*;

public class RegistrationConstraintLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_constraint_layour);

        findViewById(R.id.btn_registration)
                .setOnClickListener(e -> {

                    SharedPreferences preferences = getSharedPreferences(USER_DATA, MODE_PRIVATE);

                    boolean loggedIn = preferences. getBoolean(LOGGED_IN, false);
                    boolean registered = preferences.getBoolean(LOGGED_IN, false);

                    Intent intent = new Intent(
                            RegistrationConstraintLayoutActivity.this,
                            ProfileConstraintLayoutActivity.class);

                    intent.putExtra(TITLE, getString(R.string.title_profile));

                    startActivity(intent);
                });
    }
}
