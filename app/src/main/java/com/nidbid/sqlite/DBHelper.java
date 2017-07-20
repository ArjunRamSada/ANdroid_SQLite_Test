package com.nidbid.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nidish_ubuntu1604 on 19/7/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "Registers.db";
    public static final String TABLE_NAME = "Data_Table";
    public static final String COL_0 = "SNo";
    public static final String COL_1 = "Name";
    public static final String COL_2 = "Email_ID";
    public static final String COL_3 = "User_Name";
    public static final String COL_4 = "Password";

    public DBHelper(Context context ) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+" ("
                +COL_0+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COL_1+" TEXT, "
                +COL_2+" TEXT, "
                +COL_3+" TEXT, "
                +COL_4+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertintoDB(String Name, String Email_ID, String User_Name, String Password ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cval = new ContentValues();
        cval.put(COL_1, Name);
        cval.put(COL_2, Email_ID);
        cval.put(COL_3, User_Name);
        cval.put(COL_4, Password);
        long result = db.insert(TABLE_NAME, null, cval);
        if (result==-1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME, null);
        return res;
    }

    public Cursor checkPasswordRet(String UNAM, String PWD) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" where "+COL_3+"='"+UNAM+"'", null);
        return res;
    }
}
