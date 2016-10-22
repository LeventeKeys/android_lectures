package com.somniatores.lesson4;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Map;

public class SharedPreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final SharedPreferences sp = getSharedPreferences("test", 0);

        final EditText keyEditText = (EditText) findViewById(R.id.editText_key);
        final EditText valueText = (EditText) findViewById(R.id.editText_value);

        Button saveButton = (Button) findViewById(R.id.saveSharedPreferenceButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sp.edit().putString(keyEditText.getText().toString(),
                        valueText.getText().toString());
            }
        });

        Map<String, String> all = (Map<String, String>) sp.getAll();
        ListView listView = (ListView) findViewById(R.id.sharedPreferenceListView);
//        listView.setAdapter(new ArrayAdapter<String>(this, 10, ""));

    }

}
