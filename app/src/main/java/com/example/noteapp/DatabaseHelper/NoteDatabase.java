package com.example.noteapp.DatabaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.noteapp.Util.Util;
import com.example.noteapp.model.UserNote;

public class NoteDatabase extends SQLiteOpenHelper {
    public NoteDatabase(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    //create and initial table
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_NOTE_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "(" + Util.NOTE_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT , " + Util.NOTE_CONTENT + "TEXT)";
        sqLiteDatabase.execSQL(CREATE_NOTE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + Util.TABLE_NAME;
        db.execSQL(DROP_USER_TABLE, new String[]{Util.TABLE_NAME});
        onCreate(db);
    }

    //insert note to database and judge if it successful
    public long insertNote(UserNote userNote){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        final ContentValues contentValues = new ContentValues();
        //contentValues.put(Util.NOTE_ID, userNote.getUser_id());
        contentValues.put(Util.NOTE_CONTENT, userNote.getUserNote());
        sqLiteDatabase.insert(Util.TABLE_NAME, null, contentValues);
        long newRowId = sqLiteDatabase.insert(Util.TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
        return newRowId;

    }
}
