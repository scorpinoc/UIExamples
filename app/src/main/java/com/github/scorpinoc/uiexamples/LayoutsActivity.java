package com.github.scorpinoc.uiexamples;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.github.scorpinoc.uiexamples.layouts.*;

import static com.github.scorpinoc.uiexamples.MainActivity.TITLE;

public class LayoutsActivity extends BaseGetTitleActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts);

        setChangeActivityAction(findViewById(R.id.btn_layouts_linear), LinearLayoutActivity.class, getString(R.string.btn_layouts_linear));
        setChangeActivityAction(findViewById(R.id.btn_layouts_relative), RelativeLayoutActivity.class, getString(R.string.btn_layouts_relative));
        setChangeActivityAction(findViewById(R.id.btn_layouts_table), TableLayoutActivity.class, getString(R.string.btn_layouts_table));
        setChangeActivityAction(findViewById(R.id.btn_layouts_grid), GridLayoutActivity.class, getString(R.string.btn_layouts_grid));
        setChangeActivityAction(findViewById(R.id.btn_layouts_frame), FrameLayoutActivity.class, getString(R.string.btn_layouts_frame));
        setChangeActivityAction(findViewById(R.id.btn_layouts_constraint), ConstraintLayoutActivity.class, getString(R.string.btn_layouts_constraint));
    }

    // todo rework
    private void setChangeActivityAction(Button button, Class activityClass, String title) {
        button.setOnClickListener(e -> {

            Intent intent = new Intent(LayoutsActivity.this, activityClass);

            intent.putExtra(TITLE, title);

            startActivity(intent);
        });
    }
}
