package com.alexurangareyes.mysqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by alexurangareyes on 5/30/17.
 */

public class DataBaseManager {

    private DbHelper helper;
    private SQLiteDatabase db;

    public static final String TABLE_NAME = "Places";

    public static final String CN_ID = "_id";
    public static final String CN_NAME = "name";
    public static final String CN_STATE = "state";
    public static final String CN_MUNICIPALITY = "municipality";
    public static final String CN_PHOTO = "photo";

    public static final String CN_LAT = "lat";
    public static final String CN_LON = "lon";

    public static final String CREATE_TABLE = "create table " + TABLE_NAME + " ("
            + CN_ID + " INTEGER primary key autoincrement, "
            + CN_NAME + " TEXT not null,"
            + CN_STATE + " TEXT not null,"
            + CN_MUNICIPALITY + " TEXT not null,"
            + CN_PHOTO + " TEXT not null,"
            + CN_LAT + " REAL not null,"
            + CN_LON + " REAL not null);";

    public DataBaseManager(Context context) {

        helper = new DbHelper(context);
        db = helper.getWritableDatabase();

    }

    private ContentValues genContentValues(String name, String state, String municipality, String photo, String lat, String lon) {

        ContentValues values = new ContentValues();
        values.put(CN_NAME, name);
        values.put(CN_STATE, state);
        values.put(CN_MUNICIPALITY, municipality);
        values.put(CN_PHOTO, photo);
        values.put(CN_LAT, lat);
        values.put(CN_LON, lon);

        return values;
    }

    public void addPlace(String name, String state, String municipality, String photo, String lat, String lon) {

        db.insert(TABLE_NAME, null, genContentValues(name, state, municipality, photo, lat, lon));

    }

    public void deletePlace(String name) {

        db.delete(TABLE_NAME, CN_NAME + "=?", new String[]{name});
    }

    public void deletePlaces(String name1,String name2){
        db.delete(TABLE_NAME, CN_NAME + "IN(?,?)", new String[]{name1,name2});
    }

    public void modifyPlaceState(String name, String newState, String municipality, String photo, String lat, String lon) {

        db.update(TABLE_NAME, genContentValues(name, newState, municipality, photo, lat, lon), CN_NAME + "=?", new String[]{name});

    }




}