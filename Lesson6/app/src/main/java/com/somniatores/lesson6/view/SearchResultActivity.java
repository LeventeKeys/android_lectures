package com.somniatores.lesson6.view;

import android.os.Bundle;
import android.app.Activity;

import com.somniatores.lesson6.R;

public class SearchResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
