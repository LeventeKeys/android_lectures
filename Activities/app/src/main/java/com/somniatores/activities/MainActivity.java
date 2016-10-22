package com.somniatores.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lesson3", "MainActivity onCreate");

        Button startEmaulActivity = (Button) findViewById(R.id.button_start_email_activity);
        startEmaulActivity.setOnClickListener(this);

        Button startIntentFilterActivityButton =
                (Button) findViewById(R.id.button_start_intent_filter_activity);
        startIntentFilterActivityButton.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lesson3", "MainActivity onStart");
        // The activity is about to become visible.
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lesson3", "MainActivity onResume");
        // The activity has become visible (it is now "resumed").
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lesson3", "MainActivity onPause");
        // Another activity is taking focus (this activity is about to be "paused").
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lesson3", "MainActivity onStop");
        // The activity is no longer visible (it is now "stopped")
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lesson3", "MainActivity onDestroy");
        Log.d("Lesson3", "-------------------");
        // The activity is about to be destroyed.
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d("Lesson3", "MainActivity onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.d("Lesson3", "MainActivity onRestoreInstanceState");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_start_email_activity:
                Intent startSecondActivity = new Intent(this, EmailActivity.class);
                startActivity(startSecondActivity);
                break;
            case R.id.button_start_intent_filter_activity:
                Intent startSomeAction = new Intent("com.somniatores.activities.startSomeAction");
                startSomeAction.putExtra("my_action", "Some parameters 123");
                startActivity(startSomeAction);
                break;
            default:
                break;
        }
    }
}
