package com.somniatores.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SomeActionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_some_action);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String myAction = getIntent().getStringExtra("my_action");
        TextView actionTextView = (TextView) findViewById(R.id.textView_someAction);
        actionTextView.setText(myAction);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
