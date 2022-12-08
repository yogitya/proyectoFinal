package com.example.partituras;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button btnLearned, btnToLearn, btnAdd, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnLearned = findViewById(R.id.btnLearned);
        btnToLearn = findViewById(R.id.btnToLearn);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);

        //Aprendidas
        btnLearned.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, LearnedActivity.class);
            startActivity(intent);
        });

        //Piezas por aprender
        btnToLearn.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, ToLearnActivity.class);
            startActivity(intent);
        });

        //Agregar Pieza
        btnAdd.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, AddActivity.class);
            startActivity(intent);
        });

        //Eliminar Pieza
        btnDelete.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, DeleteActivity.class);
            startActivity(intent);
        });
    }

}

