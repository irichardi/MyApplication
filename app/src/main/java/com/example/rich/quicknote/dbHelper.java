package com.example.rich.quicknote;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rich on 4/8/2016.
 */
public class dbHelper  extends SQLiteOpenHelper {
    //variables holding db values
    public static final String dbName = "notes.db";
    public static final String dbTable = "notesTable";
    public static final String cID = "id";
    public static final String cTitle = "title";
    public static final String cCat = "category";
    public static final String cDesc = "description";
    public static final String cDate = "date";
    //database
    public dbHelper(Context context) {
        super(context, dbName, null, 1);
    }
    //creates table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + dbTable +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT,category TEXT,description TEXT,date TEXT)");
    }
    //drops old table if it exists
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop old table"+dbTable);
        onCreate(db);
    }
    //inserts to database note table
    public boolean insertData(String title,String category,String description, String date) {
        //gets db and inserts values
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(cTitle,title);
        contentValues.put(cCat,category);
        contentValues.put(cDesc,description);
        contentValues.put(cDate,date);
        //adds to result for check and inserts db table
        long result = myDB.insert(dbTable,null ,contentValues);
        //if errors
        if(result == -1)
            return false;
        else
            return true;
    }
}
