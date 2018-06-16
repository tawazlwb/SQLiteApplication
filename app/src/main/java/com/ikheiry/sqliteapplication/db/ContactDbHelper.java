package com.ikheiry.sqliteapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contact_db";
    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + ContactContract.ContactEntry.TABLE_NAME +
            "(" + ContactContract.ContactEntry.CONTACT_ID +" number, " +
            ContactContract.ContactEntry.NAME +" text, " +
            ContactContract.ContactEntry.EMAIL +" text);" ;

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + ContactContract.ContactEntry.TABLE_NAME;

    public ContactDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database Operations", "Database created...");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d("Database Operations", "Table created...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addContact(int id, String name, String email, SQLiteDatabase database){
        ContentValues values = new ContentValues();
        values.put(ContactContract.ContactEntry.CONTACT_ID, id);
        values.put(ContactContract.ContactEntry.NAME, name);
        values.put(ContactContract.ContactEntry.EMAIL, email);

        database.insert(ContactContract.ContactEntry.TABLE_NAME, null, values);
        Log.d("Database Operations", "One raw inserted...");
    }

    public Cursor readContact(SQLiteDatabase database){
        String[] projections = {
                ContactContract.ContactEntry.CONTACT_ID,
                ContactContract.ContactEntry.NAME,
                ContactContract.ContactEntry.EMAIL
        };
        Cursor cursor = database.query(
                ContactContract.ContactEntry.TABLE_NAME,
                projections,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }
}
