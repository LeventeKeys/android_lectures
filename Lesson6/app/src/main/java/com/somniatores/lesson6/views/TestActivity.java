package com.somniatores.lesson6.views;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.somniatores.lesson6.Application;
import com.somniatores.lesson6.R;
import com.somniatores.services.TestRepository;

public class TestActivity extends Activity {
    private TestRepository dictionaryTestStorage = Application.dictionaryTestStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.recyclerList);

        TestsAdapter adapter = new TestsAdapter(this, dictionaryTestStorage.getAll());
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }
}
