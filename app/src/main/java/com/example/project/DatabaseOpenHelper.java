package com.example.project;


import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {

        private static String DATABASE_NAME="project.db";
        private static final int DATABASE_VERSION=1;

        public DatabaseOpenHelper(Context context) {
            super(context,DATABASE_NAME,null,DATABASE_VERSION);

        }
    }


