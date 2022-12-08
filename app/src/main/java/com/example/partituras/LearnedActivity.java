package com.example.partituras;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

public class LearnedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learned);

        ListView lv_Registros = findViewById(R.id.lv_Registros);

        DatabaseHelper databaseHelper = new DatabaseHelper(LearnedActivity.this);
        List<Data> partituras = databaseHelper.getEveryone();

        ArrayAdapter partiturasArrayAdapter = new ArrayAdapter<Data>(LearnedActivity.this, android.R.layout.simple_list_item_1, partituras);
        lv_Registros.setAdapter(partiturasArrayAdapter);
    }
}