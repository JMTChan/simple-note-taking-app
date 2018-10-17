package com.notes.chan.simplenotetakingapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

    public static final String TAG = "DbHelper";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "app_notes.db";

    public static final String TABLE_NOTES = "notes";
    public static final String ID = "id";
    public static final String C_TITLE = "title";
    public static final String C_BODY = "body";
    public static final String C_CREATEDAT = "created_at";
    public static final String C_UPDATEDAT = "updated_at";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createnotetable = "CREATE TABLE " + TABLE_NOTES + "(" +ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                C_TITLE + " TEXT," +
                C_BODY + " TEXT," +
                C_CREATEDAT + " TEXT," +
                C_UPDATEDAT + " TEXT" + ")";

        sqLiteDatabase.execSQL(createnotetable);
        Log.d(TAG, createnotetable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
