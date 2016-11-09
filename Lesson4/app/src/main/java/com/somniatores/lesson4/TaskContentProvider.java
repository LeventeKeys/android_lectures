package com.somniatores.lesson4;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TaskContentProvider extends ContentProvider {
    public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/tasks";
    public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/tasks";

    static final String AUTHORITY = "com.somniatores.lesson4";
    static final String BASE_PATH = "tasks";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);
    // used for the UriMacher
    private static final int TASKS = 10;
    private static final int TASK_ID = 20;
    private static final UriMatcher sURIMatcher = new UriMatcher(
            UriMatcher.NO_MATCH);

    static {
        sURIMatcher.addURI(AUTHORITY, BASE_PATH, TASKS);
        sURIMatcher.addURI(AUTHORITY, BASE_PATH + "/#", TASK_ID);
    }

    // database
    private TaskDataSource database;

    public TaskContentProvider() {
        new ArrayList<>().size()logm
    }

    @Override
    public boolean onCreate() {
        database = new TaskDataSource(getContext());
        database.open();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        // check if the caller has requested a column which does not exists
        checkColumns(projection);


        int uriType = sURIMatcher.match(uri);
        switch (uriType) {
            case TASKS:
                return database.getAll();
            case TASK_ID:
                long id = Long.valueOf(uri.getLastPathSegment());
                // adding the ID to the original query
                return database.get(id);
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }

    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        int uriType = sURIMatcher.match(uri);
        long id;
        switch (uriType) {
            case TASKS:
                id = database.create(values);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse(BASE_PATH + "/" + id);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int uriType = sURIMatcher.match(uri);

        long id = Long.valueOf(uri.getLastPathSegment());

        int rowsDeleted;
        switch (uriType) {
            case TASK_ID:
                rowsDeleted = database.delete(id);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return rowsDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {

        int uriType = sURIMatcher.match(uri);
        int rowsUpdated;
        switch (uriType) {
            case TASK_ID:
                rowsUpdated = database.update(values);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return rowsUpdated;
    }

    private void checkColumns(String[] projection) {
        String[] available = TaskDataSource.allColumns;
        if (projection != null) {
            HashSet<String> requestedColumns = new HashSet<>(Arrays.asList(projection));
            HashSet<String> availableColumns = new HashSet<>(Arrays.asList(available));

            // check if all columns which are requested are available
            if (!availableColumns.containsAll(requestedColumns)) {
                throw new IllegalArgumentException(
                        "Unknown columns in projection");
            }
        }
    }


}
