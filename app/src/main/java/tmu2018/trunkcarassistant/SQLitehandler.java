package tmu2018.trunkcarassistant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Float.parseFloat;

/**
 * Created by Marcin on 13.03.2018.
 */

public class SQLitehandler extends SQLiteOpenHelper implements Database{

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "trunk_assistant.db";

    //2 basic tables
    private static final String TABLE_LUGGAGES = "luggages";
    private static final String TABLE_TRUNKS = "trunks";

    //columns luggages
    private static final String luggage_name = "name";
    private static final String luggage_width = "width";
    private static final String luggage_length = "length";
    private static final String luggage_heigth = "heigth";
    private static final String luggage_usercreated = "usercreated";

    //columns trunks
    private static final String trunk_name = "name";
    private static final String trunk_width = "width";
    private static final String trunk_length = "length";
    private static final String trunk_heigth = "heigth";
    private static final String trunk_usercreated = "usercreated";


    public SQLitehandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //create tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_luggages_table = "CREATE TABLE "+TABLE_LUGGAGES+ " ("
                +luggage_name+" TEXT,"
                +luggage_width+" TEXT,"
                +luggage_length+" TEXT,"
                +luggage_heigth+" TEXT,"
                +luggage_usercreated+" TEXT)";

        String create_trunks_table = "CREATE TABLE "+TABLE_TRUNKS+ " ("
                +trunk_name+" TEXT,"
                +trunk_width+" TEXT,"
                +trunk_length+" TEXT,"
                +trunk_heigth+" TEXT,"
                +trunk_usercreated+" TEXT)";

        db.execSQL(create_luggages_table);
        db.execSQL(create_trunks_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_LUGGAGES);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_TRUNKS);

        onCreate(db);
    }

    public void addLuggage(Luggage luggage) throws IllegalArgumentException
    {

        //if there is no such luggage, add it to db
        try
        {
            readLuggage(luggage.getName());
        }
        catch (IllegalArgumentException exc)
        {
            ContentValues values = new ContentValues();
            values.put(luggage_name,luggage.getName());
            values.put(luggage_width,""+luggage.getWidth());
            values.put(luggage_length,""+luggage.getLength() );
            values.put(luggage_heigth,""+luggage.getHeight());
            values.put(luggage_usercreated,""+luggage.isUsercreated());

            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(TABLE_LUGGAGES,null,values);
            db.close();
            return;
        }

        //there is such luggage
        throw new IllegalArgumentException("There is already such luggage");

    }

    public void addTrunk(Trunk trunk) throws IllegalArgumentException
    {

        //if there are no such trunk, add it to db
        try
        {
            readTrunk(trunk.getName());
        }
        catch (IllegalArgumentException exc)
        {
            ContentValues values = new ContentValues();
            values.put(trunk_name,trunk.getName());
            values.put(trunk_width,""+trunk.getWidth());
            values.put(trunk_length,""+trunk.getLength() );
            values.put(trunk_heigth,""+trunk.getHeight());
            values.put(trunk_usercreated,""+trunk.isUsercreated());

            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(TABLE_TRUNKS,null,values);
            db.close();
            return;
        }

        //there is such trunk
        throw new IllegalArgumentException("There is already such trunk");

    }

    //return single luggage with certain name
    public Luggage readLuggage(String name) throws IllegalArgumentException
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = luggage_name+" =?";
        String[] selectionArgs = {name};
        String sort = luggage_name+" DESC";

        Cursor cursor = db.query(
                TABLE_LUGGAGES,     //table
                null,       //columns to return
                selection,                    //columns for where
                selectionArgs,                   //values for where
                null,                   //do not group rows
                null,                    //do not filter by row groups
                sort                    //sort order
        );

        if (cursor != null)
            cursor.moveToFirst();

        if(cursor.getCount() == 0)
        {
            db.close();
            throw new IllegalArgumentException("Cannot find name");
        }


        Luggage luggage = new Luggage(
                cursor.getString(0),
                parseFloat(cursor.getString(1)),
                parseFloat(cursor.getString(2)),
                parseFloat(cursor.getString(3)),
                parseBoolean(cursor.getString(4)) );
        return luggage;
    }

    //returns all Luggages, return empty list if there are none
    public List<Luggage> readAllLuggages()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Luggage> luggages = new ArrayList<Luggage>();

        String string_query = "SELECT * FROM "+TABLE_LUGGAGES;
        Cursor cursor = db.rawQuery(string_query, null);

        if (cursor.moveToFirst()) {
            do {
                Luggage luggage = new Luggage(
                        cursor.getString(0),
                        parseFloat(cursor.getString(1)),
                        parseFloat(cursor.getString(2)),
                        parseFloat(cursor.getString(3)),
                        parseBoolean(cursor.getString(4))
                );

                luggages.add(luggage);
            } while (cursor.moveToNext());
        }

        return luggages;
    }

    //read trunk with certain name
    public Trunk readTrunk(String name) throws IllegalArgumentException
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = trunk_name+" =?";
        String[] selectionArgs = {name};
        String sort = trunk_name+" DESC";

        Cursor cursor = db.query(
                TABLE_TRUNKS,     //table
                null,       //columns to return
                selection,                    //columns for where
                selectionArgs,                   //values for where
                null,                   //do not group rows
                null,                    //do not filter by row groups
                sort                    //sort order
        );

        if (cursor != null)
            cursor.moveToFirst();

        if(cursor.getCount() == 0)
        {
            db.close();
            throw new IllegalArgumentException("Cannot find name");
        }

        Trunk trunk = new Trunk(
                cursor.getString(0),
                parseFloat(cursor.getString(1)),
                parseFloat(cursor.getString(2)),
                parseFloat(cursor.getString(3)),
                parseBoolean(cursor.getString(4)) );

        return trunk;
    }

    //read all trunks, returns empty list if there are none
    public List<Trunk> readAllTrunks()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Trunk> trunks = new ArrayList<Trunk>();

        String string_query = "SELECT * FROM "+TABLE_TRUNKS;
        Cursor cursor = db.rawQuery(string_query, null);

        if (cursor.moveToFirst()) {
            do {
                Trunk trunk = new Trunk(
                        cursor.getString(0),
                        parseFloat(cursor.getString(1)),
                        parseFloat(cursor.getString(2)),
                        parseFloat(cursor.getString(3)),
                        parseBoolean(cursor.getString(4))
                );

                trunks.add(trunk);
            } while (cursor.moveToNext());
        }

        return trunks;
    }

    //replace oldLuggage data with newLuggage data
    public void updateLuggage(Luggage oldLuggage, Luggage newLuggage) throws IllegalArgumentException
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //throw exception if there are no such luggage
        readTrunk(oldLuggage.getName());

        //name is the same, no need to check
        if(oldLuggage.getName().equals(newLuggage.getName()))
        {
            deleteLuggage(oldLuggage);
            addLuggage(newLuggage);
            db.close();
            return;
        }

        try
        {
            readLuggage(newLuggage.getName());
        }
        catch (IllegalArgumentException exception)
        {
            deleteLuggage(oldLuggage);
            addLuggage(newLuggage);
            db.close();
            return;
        }

        //old and new names are not the same, new name is already in db
        db.close();
        throw new IllegalArgumentException("New trunk name is already used");


    }

    //deletes luggage with certain name
    public void deleteLuggage(Luggage luggage)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_LUGGAGES, luggage_name + " = ?",
                new String[] { luggage.getName() });
        db.close();
    }

    //deletes trunk with certain name
    public void deleteTrunk(Trunk trunk)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TRUNKS, trunk_name + " = ?",
                new String[] { trunk.getName() });
        db.close();
    }

    public void updateTrunk(Trunk oldTrunk,Trunk newTrunk) throws IllegalArgumentException
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //throw exception if there are no such trunk
        readTrunk(oldTrunk.getName());

        //name is the same, no need to check
        if(oldTrunk.getName().equals(newTrunk.getName()))
        {
            deleteTrunk(oldTrunk);
            addTrunk(newTrunk);
            db.close();
            return;
        }

        try
        {
            readTrunk(newTrunk.getName());
        }
        catch (IllegalArgumentException exception)
        {
            deleteTrunk(oldTrunk);
            addTrunk(newTrunk);
            db.close();
            return;
        }

        //old and new names are not the same, new name is already in db
            db.close();
            throw new IllegalArgumentException("New trunk name is already used");

    }

}
