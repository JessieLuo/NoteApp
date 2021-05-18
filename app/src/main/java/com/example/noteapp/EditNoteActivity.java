package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.noteapp.DatabaseHelper.NoteDatabase;
import com.example.noteapp.model.UserNote;

public class EditNoteActivity extends AppCompatActivity {
    NoteDatabase noteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        EditText enterNoteEditText = findViewById(R.id.enterNoteEditText);
        Button saveButton = findViewById(R.id.saveButton);
        noteDatabase = new NoteDatabase(this);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNote = enterNoteEditText.getText().toString();
                long result = noteDatabase.insertNote(new UserNote(5, userNote));
                if(result > 0){
                    Toast.makeText(EditNoteActivity.this, "Success add content!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditNoteActivity.this, "Failed add content", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}