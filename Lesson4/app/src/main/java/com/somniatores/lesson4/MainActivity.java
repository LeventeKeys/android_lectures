package com.somniatores.lesson4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context that = this;
        Button button = (Button) findViewById(R.id.shared_preference_activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(that, SharedPreferencesActivity.class);
                startActivity(i);
            }
        });

        Button taskActivityButton = (Button) findViewById(R.id.button_task_activity);
        taskActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(that, TaskActivity.class);
                i.putExtra("user-name", "dd");
                startActivity(i);
            }
        });
    }
}
