package com.example.project.UserFeature;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.project.UserFeature.UserNotes;

import java.util.ArrayList;

public class UserNotesDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "notes_db";


    public UserNotesDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(UserNotes.CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + UserNotes.TABLE_NAME);

        // Create tables again
        onCreate(db);

    }

    public long insertNote(String note) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(UserNotes.COLUMN_NOTE, note);

        // insert row
        long id = db.insert(UserNotes.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }
    public UserNotes getNote(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(UserNotes.TABLE_NAME,
                new String[]{UserNotes.COLUMN_ID, UserNotes.COLUMN_NOTE, UserNotes.COLUMN_TIMESTAMP},
                UserNotes.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        UserNotes note = new UserNotes(
                cursor.getInt(cursor.getColumnIndex(UserNotes.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(UserNotes.COLUMN_NOTE)),
                cursor.getString(cursor.getColumnIndex(UserNotes.COLUMN_TIMESTAMP)));

        // close the db connection
        cursor.close();

        return note;
    }

    public ArrayList<String> getAllNotes() {
        ArrayList<String> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + UserNotes.TABLE_NAME + " ORDER BY " +
                UserNotes.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                String note;
                //UserNotes note = new UserNotes();
                //note.setId(cursor.getInt(cursor.getColumnIndex(UserNotes.COLUMN_ID)));
                note=cursor.getString(cursor.getColumnIndex(UserNotes.COLUMN_NOTE));
                //note.setNote(cursor.getString(cursor.getColumnIndex(UserNotes.COLUMN_NOTE)));
                //note.setTimestamp(cursor.getString(cursor.getColumnIndex(UserNotes.COLUMN_TIMESTAMP)));

                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + UserNotes.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateNote(String note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(UserNotes.COLUMN_NOTE, note.getNote());

        // updating row
        return db.update(UserNotes.TABLE_NAME, values, UserNotes.COLUMN_NOTE + " = ?",
                new String[]{note});
    }

    public void deleteNote(UserNotes note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UserNotes.TABLE_NAME, UserNotes.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }

}
