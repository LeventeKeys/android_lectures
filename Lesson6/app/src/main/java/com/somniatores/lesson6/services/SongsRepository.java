package com.somniatores.lesson6.services;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

/**
 * Created by locisvv on 06.11.2016.
 */

public class SongsRepository {

    private final SongsDatabaseHelper database;

    public SongsRepository(Context context) {
        database = SongsDatabaseHelper.getInstance(context);
    }

    public Cursor getAllSongs() {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables("song_titles");

        SQLiteDatabase db = database.getReadableDatabase();
        return queryBuilder.query(db, null, null, null, null, null, null);
    }
}
