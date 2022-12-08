package com.example.partituras;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_PIEZAS = "Piezas";
    public static final String NOMBRE = "nombre";
    public static final String AUTOR = "autor";
    public static final String DIFICULTAD = "dificultad";
    public static final String SELECCION = "seleccion";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "myDataBase.db", null, 21);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_PIEZAS + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOMBRE+" TEXT NOT NULL, " +
                AUTOR+" TEXT NOT NULL, " +
                DIFICULTAD+" TEXT NOT NULL, " +
                SELECCION + " INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE Piezas");
        onCreate(db);
    }

   public List<Data> getEveryone() {
                List<Data> returnList =  new ArrayList<>();

                String queryString = "SELECT * FROM " + TABLE_PIEZAS+" WHERE "+SELECCION+"=1";
                SQLiteDatabase db = this.getReadableDatabase();
                Cursor cursor = db.rawQuery(queryString,null);

                if(cursor.moveToFirst()) {
                    do {
                        int P_ID = cursor.getInt(0);
                        String P_nombre = cursor.getString(1);
                        String P_autor = cursor.getString(2);
                        String P_dificultad = cursor.getString(3);
                        int P_Seleccion = cursor.getInt(4);

                        Data newData = new Data(P_ID,P_nombre,P_autor,P_dificultad,P_Seleccion);
                        returnList.add(newData);

                    } while (cursor.moveToNext());
        } else {

        }
        cursor.close();
        db.close();
        return returnList;
   }

}
