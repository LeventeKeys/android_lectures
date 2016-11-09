package com.somniatores.lesson4;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import static com.somniatores.lesson4.TaskContentProvider.AUTHORITY;
import static com.somniatores.lesson4.TaskContentProvider.BASE_PATH;
import static com.somniatores.lesson4.TaskContentProvider.CONTENT_URI;
import static com.somniatores.lesson4.TaskSQLiteHelper.COLUMN_TASK;

public class TaskActivity extends Activity {

    private Button createTaskButton;
    private EditText taskText;
    private Button backButton;
    private SimpleCursorAdapter adapter;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        getIntent().getStringExtra("user-name");

        list = (ListView) findViewById(R.id.list_of_task);
        createTaskButton = (Button) findViewById(R.id.button_create_task);
        backButton = (Button) findViewById(R.id.button_back);
        taskText = (EditText) findViewById(R.id.editText_task);
        fillList();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        createTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = taskText.getText().toString();
                ContentValues value = new ContentValues();
                value.put(COLUMN_TASK, text);
                getContentResolver().insert(CONTENT_URI, value);

                updateList();
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri uri = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH + "/" + id);
                getContentResolver().delete(uri, "_id = ? ", null);
                updateList();
            }
        });
    }

    private void updateList() {
        Cursor cursor = getContentResolver().query(CONTENT_URI, new String[]{COLUMN_TASK}, null, null, null);
        adapter.changeCursor(cursor);
        adapter.notifyDataSetChanged();
    }

    private void fillList() {
        // Fields from the database (projection)
        // Must include the _id column for the adapter to work
        String[] from = new String[]{COLUMN_TASK};
        // Fields on the UI to which we map
        int[] to = new int[]{R.id.textView_task};

        Cursor cursor = getContentResolver().query(CONTENT_URI, from, null, null, null);
        adapter = new SimpleCursorAdapter(this, R.layout.task_row, cursor, from, to);

        list.setAdapter(adapter);
    }
}
