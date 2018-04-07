package com.github.scorpinoc.uiexamples.layouts.constraint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.scorpinoc.uiexamples.BaseGetTitleActivity;
import com.github.scorpinoc.uiexamples.R;

import static com.github.scorpinoc.uiexamples.MainActivity.TITLE;
import static com.github.scorpinoc.uiexamples.layouts.ConstraintLayoutActivity.LOGGED_IN;
import static com.github.scorpinoc.uiexamples.layouts.ConstraintLayoutActivity.LOGIN;
import static com.github.scorpinoc.uiexamples.layouts.ConstraintLayoutActivity.NAME;
import static com.github.scorpinoc.uiexamples.layouts.ConstraintLayoutActivity.PASSWORD;
import static com.github.scorpinoc.uiexamples.layouts.ConstraintLayoutActivity.REGISTERED;
import static com.github.scorpinoc.uiexamples.layouts.ConstraintLayoutActivity.USER_DATA;

public class RegistrationConstraintLayoutActivity extends BaseGetTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_constraint_layour);

        Button buttonRegistration = findViewById(R.id.btn_registration);

        final boolean[] isRegistrationEnabled = {false, false};

        EditText editPassword = findViewById(R.id.edit_password);
        editPassword
                .addTextChangedListener(new TextWatcherErrorChecker(editable -> {
                    TextInputLayout layoutPassword = findViewById(R.id.edit_password_input_layout);
                    boolean enabled = editable.length() > 9;

                    isRegistrationEnabled[0] = enabled;
                    layoutPassword.setError(enabled ? null : getString(R.string.err_small_password));
                    layoutPassword.setErrorEnabled(enabled);
                    for (boolean isEnabled : isRegistrationEnabled) {
                        enabled = enabled && isEnabled;
                    }
                    buttonRegistration.setClickable(enabled);
                }));

        EditText editPasswordConfirm = findViewById(R.id.edit_password_confirm);
        editPasswordConfirm
                .addTextChangedListener(new TextWatcherErrorChecker(editable -> {
                    TextInputLayout layoutPassword = findViewById(R.id.edit_password_confirm_input_layout);
                    boolean enabled = editable.equals(editPassword.getText());

                    isRegistrationEnabled[1] = enabled;
                    layoutPassword.setError(enabled ? null : getString(R.string.err_different_password));
                    layoutPassword.setErrorEnabled(enabled);
                    for (boolean isEnabled : isRegistrationEnabled) {
                        enabled = enabled && isEnabled;
                    }
                    buttonRegistration.setClickable(enabled);
                }));

        buttonRegistration
                .setOnClickListener(e -> {

                    SharedPreferences preferences = getSharedPreferences(USER_DATA, MODE_PRIVATE);

                    String loginEdit = ((EditText) findViewById(R.id.edit_login)).getText().toString();
                    String passwordEdit = editPassword.getText().toString();
                    String passwordConfirmEdit = editPasswordConfirm.getText().toString();
                    String nameEdit = ((EditText) findViewById(R.id.edit_name)).getText().toString();

                    if(!passwordEdit.equals(passwordConfirmEdit))
                    {
                        return;
                    }

                    preferences
                            .edit()
                            .putBoolean(LOGGED_IN, true)
                            .putBoolean(REGISTERED, true)
                            .putString(LOGIN, loginEdit)
                            .putString(PASSWORD, passwordEdit)
                            .putString(NAME, nameEdit)
                            .apply();

                    Intent intent = new Intent(
                            RegistrationConstraintLayoutActivity.this,
                            ProfileConstraintLayoutActivity.class);

                    intent.putExtra(TITLE, getString(R.string.title_profile));

                    startActivity(intent);
                });
    }
}
