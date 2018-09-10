package com.example.root.blockchain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;


public class DatabaseHelperNewNode extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "/mnt/sdcard/newnode.db";
    public static final String TABLE_NAME = "blockchain";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "SENDER";
    public static final String COL_3 = "RECIVER";
    public static final String COL_4 = "VALUE";
    public static final String COL_5 = "HASH";
    public static final String COL_6 = "PREVHASH";
    public static final String COL_7 = "TIMESTAMP";
    public static final String COL_8 = "NONCE";

    public static final String COL_9 = "MINER";







    public DatabaseHelperNewNode(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,SENDER TEXT,RECIVER TEXT,VALUE TEXT,HASH TEXT,PREVHASH TEXT,TIMESTAMP TEXT,NONCE TEXT,MINER TEXT)");
        db.delete(TABLE_NAME, null,null);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
  db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.delete(TABLE_NAME, null,null);

        onCreate(db);
    }

    public boolean insertData(String Sender,String Reciver,String value,String hash,String prevhash,String timestamp,String nonce,String Miner) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,Sender);
        contentValues.put(COL_3,Reciver);
        contentValues.put(COL_4,value);
        contentValues.put(COL_5,hash);
        contentValues.put(COL_6,prevhash);
        contentValues.put(COL_7,timestamp);
        contentValues.put(COL_8,nonce);
        contentValues.put(COL_9,Miner);






        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }




public int Delet(){
    SQLiteDatabase db = this.getWritableDatabase();
    db.delete(TABLE_NAME,null,null);

    return  0;
}







}