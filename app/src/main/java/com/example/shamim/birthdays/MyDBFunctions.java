package com.example.shamim.birthdays;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Shamim on 05-Jan-18.
 */

public class MyDBFunctions extends SQLiteOpenHelper{

    //Creating DATABASE
    private static final String DATABASE_NAME ="mydb";
    private static final String TABLE_NAME  ="mytab";

    private static final String TAB_ID ="id";
    private static final String TAB_NAME  ="name";
    private static final String TAB_DAYS ="days";

    MyDBFunctions(Context c){

        super(c , DATABASE_NAME, null, 1);

    }


    //Query For Creating DATABASE

    @Override
    public void onCreate(SQLiteDatabase db) {

        String s = "CREATE TABLE " +TABLE_NAME+" ("+TAB_ID+" INTEGER PRIMARY KEY, "+TAB_NAME+" TEXT,"+TAB_DAYS+ " TEXT)";
        db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Adding Data to DATABASE

    void addingDataToTable(DateTemp dt){

        SQLiteDatabase sqd = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TAB_NAME, dt.getName());
        cv.put(TAB_DAYS,dt.getDay());

        sqd.insert(TABLE_NAME,null,cv);
        sqd.close();
    }

    //Showing DATA

    String[] my_data(){

        SQLiteDatabase sq = this.getReadableDatabase();

        String q = "SELECT * FROM " + TABLE_NAME;
        Cursor c = sq.rawQuery(q,null);

        String[] receive_data = new String[c.getCount()];

        c.moveToFirst();

        if(c.moveToFirst()){
            int count =0;

            do{
                receive_data[count] = "Name :"+ c.getString(c.getColumnIndex(TAB_NAME+"")) +"\nBirthday: "+
                        c.getString(c.getColumnIndex(TAB_DAYS+""));
                count++;
            }while(c.moveToNext());
        }

        return  receive_data;

    }

    //For Update Edit Text

    String fetch_day(int id){

        SQLiteDatabase sq = this.getReadableDatabase();

        String q = "SELECT "+TAB_DAYS+" FROM "+ TABLE_NAME +" WHERE "+TAB_ID+"="+id;
        Cursor c = sq.rawQuery(q,null);

        String s="";

       if(c.moveToFirst()){

           s = c.getString(c.getColumnIndex(TAB_DAYS+""));
       }

      return s;

    }

    //-----//


    ///Update Birthday Date

    int update_birthday(int id, String bday){

        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TAB_DAYS,bday);

        return  sq.update(TABLE_NAME, cv, TAB_ID+ "= ?", new String[]{id+""});
    }


    //-----//


    //DELETE DATA FROM DATABASE


    int delete_data(String bday){

        SQLiteDatabase sq = this.getWritableDatabase();

        return sq.delete(TABLE_NAME, TAB_DAYS+ " =? ", new String[] {bday} );
    }
}
