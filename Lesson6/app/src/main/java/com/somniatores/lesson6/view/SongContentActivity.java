package com.somniatores.lesson6.view;

import android.os.Bundle;
import android.app.Activity;

import com.somniatores.lesson6.R;

public class SongContentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_content);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
