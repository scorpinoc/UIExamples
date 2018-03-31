package com.github.scorpinoc.uiexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TITLE = "Title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setChangeActivityAction(findViewById(R.id.btn_layouts), LayoutsActivity.class, getString(R.string.btn_layouts));
        setChangeActivityAction(findViewById(R.id.btn_text_view), TextViewActivity.class, getString(R.string.btn_text_view));
        setChangeActivityAction(findViewById(R.id.btn_edit_text), EditTextActivity.class, getString(R.string.btn_edit_text));
        setChangeActivityAction(findViewById(R.id.btn_buttons), ButtonsActivity.class, getString(R.string.btn_buttons));
    }

    private void setChangeActivityAction(Button button, Class activityClass, String title) {
        button.setOnClickListener(e -> {

            Intent intent = new Intent(MainActivity.this, activityClass);

            intent.putExtra(TITLE, title);

            startActivity(intent);
        });
    }
}
