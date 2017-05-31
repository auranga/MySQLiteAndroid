package com.alexurangareyes.mysqlite.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.alexurangareyes.mysqlite.DbHelper;

/**
 * Created by alexurangareyes on 5/31/17.
 */

public class DataBaseManager {

    private DbHelper helper;
    private SQLiteDatabase db;

    public static final String TABLE_NAME = "Places";

    public static final String CN_ID = "_id";
    public static final String CN_NAME = "name";
    public static final String CN_STATE = "state";
    public static final String CN_MUNICIPALITY = "municipality";
    public static final String CN_FAV = "favourite";

    public static final String CN_LAT = "lat";
    public static final String CN_LON = "lon";


    public static final String CREATE_TABLE = "create table " + TABLE_NAME + " ("
            + CN_ID + " INTEGER primary key autoincrement, "
            + CN_NAME + " TEXT not null,"
            + CN_STATE + " TEXT not null,"
            + CN_MUNICIPALITY + " TEXT not null,"
            + CN_FAV + " INTEGER not null,"
            + CN_LAT + " REAL not null,"
            + CN_LON + " REAL not null);";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME;

    //manager.addPlace("El nombre 1","El estado","El Mun",0,"121212.1212","12212");

    public static final String INSERT_DEFAULT_ROWS = "INSERT INTO " + TABLE_NAME + " (" + CN_NAME + "," + CN_STATE + "," + CN_MUNICIPALITY + "," + CN_FAV + "," + CN_LAT + "," + CN_LON + ") " +
            "VALUES ('Palacio Municipal','Coahuila','Saltillo',0,'25.4282775','-101.0326965')" +
            ",('Cristo de la noas','Coahuila','Torreon',1,'25.5252544','-103.4581523')" +
            ",('Plaza de las culturas','Coahuila','Piedras Negras',0,'28.6948234','-100.5251208');";

    public DataBaseManager(Context context) {

        helper = new DbHelper(context);
        db = helper.getWritableDatabase();

    }

    private ContentValues genContentValues(String name, String state, String municipality, Integer favourite, String lat, String lon) {

        ContentValues values = new ContentValues();
        values.put(CN_NAME, name);
        values.put(CN_STATE, state);
        values.put(CN_MUNICIPALITY, municipality);
        values.put(CN_FAV, favourite);
        values.put(CN_LAT, lat);
        values.put(CN_LON, lon);

        return values;
    }

    public void addPlace(String name, String state, String municipality, Integer favourite, String lat, String lon) {

        db.insert(TABLE_NAME, null, genContentValues(name, state, municipality, favourite, lat, lon));

    }

    public void deletePlace(String name) {

        db.delete(TABLE_NAME, CN_NAME + "=?", new String[]{name});
    }

    public void deletePlaces(String name1, String name2) {
        db.delete(TABLE_NAME, CN_NAME + "IN(?,?)", new String[]{name1, name2});
    }

    public void modifyPlaceState(String name, String newState, String municipality, Integer favourite, String lat, String lon) {

        db.update(TABLE_NAME, genContentValues(name, newState, municipality, favourite, lat, lon), CN_NAME + "=?", new String[]{name});

    }

    public Cursor loadCursorPlaces() {

        String[] columns = new String[]{CN_ID, CN_NAME, CN_STATE, CN_MUNICIPALITY, CN_FAV, CN_LAT, CN_LON};

        return db.query(TABLE_NAME, columns, null, null, null, null, null, null);

    }

    public Cursor loadCursorPlacesFav() {

        String[] columns = new String[]{CN_ID, CN_NAME, CN_STATE, CN_MUNICIPALITY, CN_FAV, CN_LAT, CN_LON};

        return db.query(TABLE_NAME, columns, CN_FAV + "=?",new String[]{"1"} , null, null, null, null);

    }

    /*public long getProfilesCount() {
        //SQLiteDatabase db = this.getReadableDatabase();
        long cnt  = DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return cnt;
    }*/

    /*public ArrayList<Place> getAllData() {

        mCursor = loadCursorPlaces();

        ArrayList<Place> mArrayList = new ArrayList<>();

        while (mCursor.moveToNext()) {

            int index = mCursor.getColumnIndex(DataBaseManager.CN_ID);
            int index2 = mCursor.getColumnIndex(DataBaseManager.CN_NAME);
            int index3 = mCursor.getColumnIndex(DataBaseManager.CN_STATE);

            int cid = mCursor.getInt(index);
            String name = mCursor.getString(index2);
            String state = mCursor.getString(index3);

            //Place bean = new Place(cid, name);
            Place place = new Place();
            place.setId(cid);
            place.setName(name);
            place.setState(state);

            mArrayList.add(place);
        }
        return mArrayList;
    }*/


}