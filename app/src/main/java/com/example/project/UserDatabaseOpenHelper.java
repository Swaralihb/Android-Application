package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class UserDatabaseOpenHelper extends SQLiteAssetHelper {
    private static String DATABASE_NAME="User.db";
    private static final int DATABASE_VERSION=1;

    public UserDatabaseOpenHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
}
