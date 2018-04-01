package com.github.scorpinoc.uiexamples.layouts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.github.scorpinoc.uiexamples.BaseGetTitleActivity;
import com.github.scorpinoc.uiexamples.R;
import com.github.scorpinoc.uiexamples.layouts.constraint.*;

import static com.github.scorpinoc.uiexamples.MainActivity.TITLE;

public class ConstraintLayoutActivity extends BaseGetTitleActivity {

    public static final String USER_DATA = "user_data";
    public static final String LOGGED_IN = "logged_in";

    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);

        setChangeActivityAction(findViewById(R.id.btn_login), ProfileConstraintLayoutActivity.class, getString(R.string.btn_login));
        setChangeActivityAction(findViewById(R.id.btn_registration), RegistrationConstraintLayoutActivity.class, getString(R.string.btn_registration));
    }

// todo
    private void setChangeActivityAction(Button button, Class activityClass, String title) {
        button.setOnClickListener(e -> {

            Intent intent = new Intent(ConstraintLayoutActivity.this, activityClass);

            intent.putExtra(TITLE, title);

            startActivity(intent);
        });
    }
}
