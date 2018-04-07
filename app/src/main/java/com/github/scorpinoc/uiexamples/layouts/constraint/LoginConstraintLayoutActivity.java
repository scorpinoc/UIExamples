package com.github.scorpinoc.uiexamples.layouts.constraint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;

import com.github.scorpinoc.uiexamples.BaseGetTitleActivity;
import com.github.scorpinoc.uiexamples.R;

import static com.github.scorpinoc.uiexamples.layouts.ConstraintLayoutActivity.*;

import static com.github.scorpinoc.uiexamples.MainActivity.TITLE;

public class LoginConstraintLayoutActivity extends BaseGetTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_constraint_layour);

        View buttonLogin = findViewById(R.id.btn_login);

        final boolean[] isLoginEnabled = {false};

        EditText editPassword = findViewById(R.id.edit_password);
        editPassword
                .addTextChangedListener(new TextWatcherErrorChecker(editable -> {
                    TextInputLayout layoutPassword = findViewById(R.id.edit_password_input_layout);
                    boolean enabled = editable.length() > 9;

                    isLoginEnabled[0] = enabled;
                    layoutPassword.setError(enabled ? null : getString(R.string.err_small_password));
                    layoutPassword.setErrorEnabled(enabled);
                    for (boolean isEnabled : isLoginEnabled) {
                        enabled = enabled && isEnabled;
                    }
                    buttonLogin.setClickable(enabled);
                }));


        buttonLogin.setOnClickListener(e -> {
            SharedPreferences preferences = getSharedPreferences(USER_DATA, MODE_PRIVATE);

            String loginEdit = ((EditText) findViewById(R.id.edit_login)).getText().toString();
            String passwordEdit = editPassword.getText().toString();

            String login = preferences.getString(LOGIN, null);
            if(login != null && !login.equals(loginEdit))
            {
                return;
            }

            String password = preferences.getString(PASSWORD, null);
            if(password != null && !password.equals(passwordEdit))
            {
                return;
            }

            preferences
                    .edit()
                    .putBoolean(LOGGED_IN, true)
                    .apply();

            Intent intent = new Intent(LoginConstraintLayoutActivity.this,
                    ProfileConstraintLayoutActivity.class)
                    .putExtra(TITLE, getString(R.string.title_profile));

            startActivity(intent);
        });
    }
}
