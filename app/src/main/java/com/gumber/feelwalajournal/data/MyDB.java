package com.gumber.feelwalajournal.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gumber.feelwalajournal.Constants;

/**
 * Created by Tejaswin on 30-01-2016.
 */
public class MyDB {
    private final Context context;
    private final DBHelper dbHelper;
    private SQLiteDatabase db;

    public MyDB(Context c) {
        context = c;
        dbHelper = new DBHelper(c, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);

    }

    public void open() {
        //Open the database
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        //Close the database
        dbHelper.close();
    }

    public long insertEntry(String title, String content, Long date) {
        //Insert a new entry
        ContentValues cv = new ContentValues();
        cv.put(Constants.TITLE, title);
        cv.put(Constants.DESCRIPTION, content);
        cv.put(Constants.DATE, date);
        return dbHelper.getWritableDatabase().insert(Constants.TABLE_NAME, null, cv);

    }
    public Cursor getEntries(){
        Cursor c = dbHelper.getWritableDatabase().query(Constants.TABLE_NAME, null, null, null, null, null, null);
        return c;
    }


}
