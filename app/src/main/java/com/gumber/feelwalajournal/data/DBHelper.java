package com.gumber.feelwalajournal.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;

import com.gumber.feelwalajournal.Constants;

/**
 * Created by Tejaswin on 30-01-2016.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String CREATE_TABLE = "create table " +
            Constants.TABLE_NAME + " ( " +
            Constants.ID + " integer primary key autoincrement, " +
            Constants.TITLE + " text not null, " +
            Constants.DESCRIPTION + " text not null, " +
            Constants.DATE + " long); ";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + Constants.TABLE_NAME);
        onCreate(db);
    }
}
