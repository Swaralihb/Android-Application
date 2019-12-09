package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.example.project.Hospital.DatabaseAccess;
import com.example.project.Hospital.HospitalObject;

import java.util.ArrayList;

public class DatabaseAccessUser {



        private SQLiteOpenHelper sqLiteOpenHelper;
        private SQLiteDatabase db;
        private static DatabaseAccessUser instance;
        Cursor c = null;
        ArrayList<String> All;
        ArrayList<String> cont = new ArrayList<>();
        ArrayList<String> locAll = new ArrayList<>();
        int count = 0;

        public DatabaseAccessUser(Context context) {
            this.sqLiteOpenHelper = new UserDatabaseOpenHelper(context);
        }

        DatabaseAccessUser getInstance(Context context) {
            if (instance == null) {
                instance = new DatabaseAccessUser(context);
            }
            return instance;
        }

        public void open() {
            this.db = sqLiteOpenHelper.getWritableDatabase();
        }

        public void close() {
            if (db != null) {
                this.db.close();
            }
        }

        public void getProfilesCount() {
            c = db.rawQuery("select count(*) from Hospital", new String[]{});
            while (c.moveToNext())
                count = count + 1;
        }

        public ArrayList<String> getContact() {
            return cont;
        }

        public ArrayList<String> getLocation() {
            return locAll;
        }

        public Boolean getData(String nm,String pwd) {
            All=new ArrayList<>();
            // locAll=new ArrayList<>();


            c = db.rawQuery("select * from UserDetails ", new String[]{});
            while (c.moveToNext()) {

                String mail = c.getString(1);
                String password = c.getString(2);
                Boolean result=nm.contentEquals(mail);
                Boolean result1=pwd.contentEquals(password);

                if(result&&result1)
                    return true;

            }
            return  false;


        }
}
