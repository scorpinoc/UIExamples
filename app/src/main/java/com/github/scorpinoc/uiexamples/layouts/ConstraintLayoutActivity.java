package com.github.scorpinoc.uiexamples.layouts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.scorpinoc.uiexamples.BaseGetTitleActivity;
import com.github.scorpinoc.uiexamples.R;
import com.github.scorpinoc.uiexamples.layouts.constraint.*;

import static com.github.scorpinoc.uiexamples.MainActivity.TITLE;

public class ConstraintLayoutActivity extends BaseGetTitleActivity {

    public static final String USER_DATA = "user_data";
    public static final String LOGGED_IN = "logged_in";
    public static final String REGISTERED = "registered";

    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);

        findViewById(R.id.btn_login).setOnClickListener(e -> {
            SharedPreferences preferences = getSharedPreferences(USER_DATA, MODE_PRIVATE);

            Intent intent;
            if (preferences.getBoolean(LOGGED_IN, false)) {
                intent = new Intent(ConstraintLayoutActivity.this,
                        ProfileConstraintLayoutActivity.class)
                        .putExtra(TITLE, getString(R.string.title_profile));

            } else {
                intent = new Intent(ConstraintLayoutActivity.this,
                        LoginConstraintLayoutActivity.class)
                        .putExtra(TITLE, getString(R.string.btn_login));
            }

            startActivity(intent);
        });
        findViewById(R.id.btn_registration).setOnClickListener(e -> {
            SharedPreferences preferences = getSharedPreferences(USER_DATA, MODE_PRIVATE);

            Intent intent;
            if (preferences.getBoolean(REGISTERED, false)
                    && preferences.getBoolean(LOGGED_IN, false)) {
                intent = new Intent(ConstraintLayoutActivity.this,
                        ProfileConstraintLayoutActivity.class)
                        .putExtra(TITLE, getString(R.string.title_profile));
            } else {
                intent = new Intent(ConstraintLayoutActivity.this,
                        RegistrationConstraintLayoutActivity.class)
                        .putExtra(TITLE, getString(R.string.btn_registration));
            }

            startActivity(intent);
        });
    }

}
