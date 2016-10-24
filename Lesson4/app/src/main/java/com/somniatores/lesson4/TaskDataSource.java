package com.somniatores.lesson4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import static com.somniatores.lesson4.TaskSQLiteHelper.*;

/**
 * Created by locisvv on 24.10.2016.
 */

public class TaskDataSource {

    public static String[] allColumns = {
            TaskSQLiteHelper.COLUMN_ID,
            COLUMN_TASK,
            COLUMN_IS_DONE};

    // Database fields
    private SQLiteDatabase database;
    private TaskSQLiteHelper dbHelper;

    public TaskDataSource(Context context) {
        dbHelper = new TaskSQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long create(ContentValues task) {
        return database.insert(TABLE_TASKS, null, task);
    }

    public int update(ContentValues task) {
        long id = (long) task.get(COLUMN_ID);
        return database.update(TABLE_TASKS, task, COLUMN_ID + " = " + id, null);
    }

    public int delete(long taskId) {
        return database.delete(TABLE_TASKS, COLUMN_ID + " = " + taskId, null);
    }

    public Cursor getAll() {
        Cursor cursor = database.query(TABLE_TASKS,
                allColumns, null, null, null, null, null);

        return cursor;
    }

    public Cursor get(long id) {
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(TABLE_TASKS);
        builder.appendWhere("id = " + id);
        builder.query(database, allColumns, null, null, null, null, null);
        Cursor cursor = database.query(TABLE_TASKS,
                allColumns, null, null, null, null, null);

        return cursor;
    }

    private Task cursorToTask(Cursor cursor) {
        Task task = new Task();
        task.setId(cursor.getLong(0));
        task.setTask(cursor.getString(1));
        task.setDone(cursor.getInt(2));
        return task;
    }
}
