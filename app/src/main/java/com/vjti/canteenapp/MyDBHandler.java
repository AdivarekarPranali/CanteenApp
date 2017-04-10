package com.vjti.canteenapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.view.View;

public class MyDBHandler extends SQLiteOpenHelper{
    private static final int DB_VERSION=1;
    private static final String DB_NAME="Canteen";
    private static final String TABLE_MENU="Menu";
    private static final String COLUMN_DISH_ID="id";
    private static final String COLUMN_DISH_NAME="dishname";
    private static final String COLUMN_PRICE="price";


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE"+ TABLE_MENU +"("+
                COLUMN_DISH_ID +" INTEGER PRIMARY KEY AUTOINCREMENT "+
                COLUMN_DISH_NAME + "TEXT"+
                COLUMN_PRICE +"INTEGER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_MENU);
        onCreate(db);
    }

    //adding dishes to TABLE_MENU
    public void addDish(Menu menu)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_DISH_NAME, menu.getDishname());
        values.put(COLUMN_PRICE, menu.getPrice());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_MENU,null,values);
        db.close();
    }

    //Delete a product from the database
    public void deleteDish(String dish)
    {
        SQLiteDatabase db= getWritableDatabase();
        db.execSQL("DELETE FROM "+ TABLE_MENU +" WHERE "+ COLUMN_DISH_NAME + "=\""+ dish + "\"");
    }

    public String databaseToString()
    {
        String dbString="";
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+ TABLE_MENU ;

        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();

        while(!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex("dishname"))!=null && c.getString((c.getColumnIndex("price")))!=null)
            {
                dbString+=c.getString(c.getColumnIndex("dishname"));
                dbString+="\t";
                dbString+=c.getString(c.getColumnIndex("price"));
                dbString+="\n";
            }
        }

        db.close();
        return dbString;
    }

}
