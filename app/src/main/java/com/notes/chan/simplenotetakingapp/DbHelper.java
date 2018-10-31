package com.notes.chan.simplenotetakingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;

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

    public long insertNote(SQLiteDatabase db, String title, String body){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);

        ContentValues cv = new ContentValues();
        cv.put(C_TITLE, title);
        cv.put(C_BODY, body);
        cv.put(C_CREATEDAT, year + "-" + month + "-" + day);
        cv.put(C_UPDATEDAT, year + "-" + month + "-" + day);

        long id = db.insert(TABLE_NOTES, null, cv);
        return id;
    }

    public boolean updateNote(SQLiteDatabase db, long id, String title, String body){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);

        ContentValues cv = new ContentValues();
        cv.put(C_TITLE, title);
        cv.put(C_BODY, body);
        cv.put(C_UPDATEDAT, year + "-" + month + "-" + day);

        int numberOfRowsAffected = db.update(TABLE_NOTES, cv, ID+"="+id, null);
        return numberOfRowsAffected > 0;
    }

    public boolean deleteNote(SQLiteDatabase db, long id){
        int numberOfRowsDeleted = db.delete(TABLE_NOTES, ID + "=" + id, null);
        return numberOfRowsDeleted > 0;
    }

    public ArrayList<Note> getAllNotes(SQLiteDatabase db)
    {
        ArrayList<Note> notes = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NOTES, null, null, null,null,null,null,null);
        while(cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(ID));
            String title = cursor.getString(cursor.getColumnIndex(C_TITLE));
            String body = cursor.getString(cursor.getColumnIndex(C_BODY));
            String createdat = cursor.getString(cursor.getColumnIndex(C_CREATEDAT));
            String updatedat = cursor.getString(cursor.getColumnIndex(C_UPDATEDAT));

            Note note = new Note(id, title, body, createdat, updatedat);

            notes.add(note);
        }
        return notes;
    }


}
