package com.bitm.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqliteDatabaseHelper extends SQLiteOpenHelper

{

    private static String DATABASE_NAME = "User.db";
    private static String TABLE_NAME = "User";
  public static String COL_ID = "Id";
    public static String COL_NAME = "Name";
    public static String COL_AGE = "Age";
    private static int VERSION = 1;
    private String createTable = "Create Table " + TABLE_NAME + "(Id Integer Primary key autoincrement,Name text,Age text)";

    public SqliteDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insertvalues(String name, String age) {

        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_AGE, age);
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        long id = sqLiteDatabase.insert(TABLE_NAME, null, values);
        sqLiteDatabase.close();
        return id;

    }

    public Cursor showData(){

        String show_all="SELECT * From "+TABLE_NAME;
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
       Cursor cursor= sqLiteDatabase.rawQuery(show_all,null);
        return cursor;

    }

}

