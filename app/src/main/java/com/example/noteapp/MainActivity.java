package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createNewNoteButton = findViewById(R.id.createNewNoteButton);
        Button showAllNoteButton = findViewById(R.id.showAllNoteButton);

        createNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editNoteIntent = new Intent(MainActivity.this, EditNoteActivity.class);
                startActivity(editNoteIntent);
            }
        });

        showAllNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showListIntent = new Intent(MainActivity.this, ShowListActivity.class);
                startActivity(showListIntent);
            }
        });

        
    }
}