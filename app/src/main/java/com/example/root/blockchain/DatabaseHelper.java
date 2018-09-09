package com.example.root.blockchain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "/mnt/sdcard/Blockchain.db";
    public static final String TABLE_NAME = "blockchain";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "DATA";
    public static final String COL_3 = "HASH";
    public static final String COL_4 = "PREVHASH";
    public static final String COL_5 = "TIMESTAMP";
    public static final String COL_6 = "NONCE";







    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,DATA TEXT,HASH TEXT,PREVHASH TEXT,TIMESTAMP TEXT,NONCE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String data,String hash,String prevhash,String timestamp,String nonce) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,data);
        contentValues.put(COL_3,hash);
        contentValues.put(COL_4,prevhash);
        contentValues.put(COL_5,timestamp);
        contentValues.put(COL_6,nonce);





        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

}