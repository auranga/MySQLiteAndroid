package com.alexurangareyes.mysqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.alexurangareyes.mysqlite.model.DataBaseManager;

/**
 * Created by alexurangareyes on 5/30/17.
 */

public class DbHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "Places.sqlite";
    private static final int DB_SCHEMA_VERSION = 5;


    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE);

        //and insert the pre loaded records here
        sqLiteDatabase.execSQL(DataBaseManager.INSERT_DEFAULT_ROWS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL(DataBaseManager.SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}