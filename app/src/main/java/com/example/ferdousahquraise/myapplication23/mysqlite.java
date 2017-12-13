package com.example.ferdousahquraise.myapplication23;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ferdous Ah Quraise on 1/1/2017.
 */
public class mysqlite extends SQLiteOpenHelper {


    private  static final  String DATABASE_NAME = "mydatabase.db";
    private  static final  String TABLE_NAME = "mytable";
    private   static final  String COLUMN1 = "id";
    private  static final  String COLUMN2 = "FIRSTNAME";
    private  static final  String COLUMN3 = "LASTNAME";
    private  static final  String COLUMN4 = "EMAIL";


    public mysqlite(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
           String quary;
        quary = "CREATE TABLE "+TABLE_NAME+"(" +COLUMN1+ " INTEGER PRIMARY KEY, "+COLUMN2+" TEXT, " +COLUMN3+ " TEXT, "+COLUMN4+ " TEXT "+") ";
        db.execSQL(quary);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                    db.execSQL("DROP IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public  boolean addtotable(String id,String fname,String lname,String email)
    {
          SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN1,id);
        contentValues.put(COLUMN2,fname);
        contentValues.put(COLUMN3,lname);
        contentValues.put(COLUMN4,email);
        long ch=  sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
          if(ch == -1)
              return false;
        else
              return true;

    }
    public Cursor display(String id)
    {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor res;
        String[] projection = {COLUMN2,COLUMN3,COLUMN4};
        String selection = COLUMN1+" LIKE ?";
        String []selection_args = {id};
        res = sqLiteDatabase.query(TABLE_NAME,projection,selection,selection_args,null,null ,null);
        return res;
    }
}
