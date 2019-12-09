package com.example.project.MedicalStore;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.project.DatabaseOpenHelper;

import java.util.ArrayList;

public class DatabaseAccessM {
    private SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase db;
    private static DatabaseAccessM instance;
    Cursor c = null;                //initialization of cursor
    ArrayList<String> All = new ArrayList<>();              //declaration of arraylist
    ArrayList<String> cont = new ArrayList<>();
    ArrayList<String>locAll = new ArrayList<>();
    int count = 0;
    private DatabaseAccessM(Context context) {
        this.sqLiteOpenHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccessM getInstance(Context context) {                    //checking if database is opened
        if (instance == null) {
            instance = new DatabaseAccessM(context);
        }
        return instance;
    }

    public void open() {                                    //to open the database
        this.db = sqLiteOpenHelper.getWritableDatabase();

    }

    public void close() {                                   //to cloase the database
        if (db != null) {
            this.db.close();
        }
    }

    public void getProfilesCount() {
        c = db.rawQuery("select count(*) from MedicalStore", new String[]{});
        while (c.moveToNext())
            count = count + 1;
    }

    public ArrayList<String> getContact() {
        return cont;
    }           //returning all contacts
    public ArrayList<String> getLocation() {
        return locAll;
    }       //returning all locations
    public ArrayList<String> getData(String area) {                 //to get all data
        All=new ArrayList<>();
        // locAll=new ArrayList<>();

        //query to be fired in the database
        c = db.rawQuery("select * from MedicalStore where Area='"+area+"'", new String[]{});
        while (c.moveToNext()) {
            MedicalStoreObject medicalStoreObject = new MedicalStoreObject();
            String NameH = c.getString(2);
            String AddressH = c.getString(3);
            String ContactH = c.getString(4);
            locAll.add(AddressH);
            cont.add(ContactH);
            medicalStoreObject.getAll(NameH,AddressH,ContactH);
            All.add(medicalStoreObject.toString());
        }
        c=null;
        return All;
    }
}
