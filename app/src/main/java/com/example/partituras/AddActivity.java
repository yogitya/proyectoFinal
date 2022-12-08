package com.example.partituras;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    TextView txtNombre, txtAutor, txtDificultad;
    EditText edtNombre, edtAutor;
    Button  btnAddPieza, btnAddWish, btnReturn;
    RadioButton btnDificil,btnFacil, btnMedio;
    SQLiteDatabase sqLiteDatabase;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        databaseHelper = new DatabaseHelper(getApplicationContext());
        txtNombre =findViewById(R.id.txtNombre);
        txtAutor =findViewById(R.id.txtAutor);
        txtDificultad =findViewById(R.id.txtDificultad);
        edtNombre =findViewById(R.id.edtNombre);
        edtAutor = findViewById(R.id.edtAutor);
        btnDificil = findViewById(R.id.btnDificil);
        btnFacil = findViewById(R.id.btnFacil);
        btnMedio = findViewById(R.id.btnMedio);
        btnAddPieza = findViewById(R.id.btnAddPieza);
        btnAddWish = findViewById(R.id.btnAddWish);
        btnReturn = findViewById(R.id.btnReturn);
        findid();
        AddPieza();
        AddWish();

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
    // PARA OPCION DE PIEZAS COMPLETADAS
    private void AddPieza() {
        btnAddPieza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues = new ContentValues();
                String getNombre = edtNombre.getText().toString();
                String getAutor = edtAutor.getText().toString();
                contentValues.put("nombre",getNombre);
                contentValues.put("autor",getAutor);
                //RadioButton
                if (btnDificil.isChecked()){
                    contentValues.put("Dificultad",btnDificil.getText().toString());
                } else if (btnMedio.isChecked()){
                    contentValues.put("Dificultad",btnMedio.getText().toString());
                } else {
                    contentValues.put("Dificultad",btnFacil.getText().toString());
                }
                contentValues.put("seleccion",1);
                sqLiteDatabase=databaseHelper.getWritableDatabase();
                Long rec = sqLiteDatabase.insert("Piezas",null,contentValues);
                if (rec!=null) {
                    Toast.makeText(AddActivity.this,"Registro Confirmado",Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddActivity.this);
                    builder.setTitle("Error");
                    builder.setPositiveButton("ok",null);
                    builder.setCancelable(true);
                    builder.show();
                }
            }
        });
    }
    private void findid() {
        btnDificil=(RadioButton)findViewById(R.id.btnDificil);
        btnMedio=(RadioButton)findViewById(R.id.btnMedio);
        btnFacil=(RadioButton)findViewById(R.id.btnFacil);
    }

    private void AddWish() {
        btnAddWish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues = new ContentValues();
                String getNombre = edtNombre.getText().toString();
                String getAutor = edtAutor.getText().toString();
                contentValues.put("nombre", getNombre);
                contentValues.put("autor", getAutor);
                //RadioButton
                if (btnDificil.isChecked()) {
                    contentValues.put("Dificultad", btnDificil.getText().toString());
                } else if (btnMedio.isChecked()) {
                    contentValues.put("Dificultad", btnMedio.getText().toString());
                } else {
                    contentValues.put("Dificultad", btnFacil.getText().toString());
                }
                contentValues.put("seleccion", 0);
                sqLiteDatabase = databaseHelper.getWritableDatabase();
                Long rec = sqLiteDatabase.insert("Piezas", null, contentValues);
                if (rec != null) {
                    Toast.makeText(AddActivity.this, "Registro Confirmado", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddActivity.this);
                    builder.setTitle("Error");
                    builder.setPositiveButton("ok", null);
                    builder.setCancelable(true);
                    builder.show();
                }
            }
        });
    }
}