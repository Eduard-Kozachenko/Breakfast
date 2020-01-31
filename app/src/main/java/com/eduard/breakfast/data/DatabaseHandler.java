package com.eduard.breakfast.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLClientInfoException;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(@Nullable Context context) {
        super(context, "imageDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table images(id integer primary key,img blob not null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists images");
    }

    public Boolean insertImg (String x , Integer i){

        SQLiteDatabase database = this.getWritableDatabase();
        try{
            FileInputStream fileInputStream = new FileInputStream(x);
            byte[] imgByte = new byte[fileInputStream.available()];
            fileInputStream.read(imgByte);
            ContentValues contentValues = new ContentValues();
            contentValues.put("id",i);
            contentValues.put("img",imgByte);
            database.insert("images",null,contentValues);
            fileInputStream.close();
            return true;

        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }
}
