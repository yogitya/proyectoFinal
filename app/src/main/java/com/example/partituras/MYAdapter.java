package com.example.partituras;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MYAdapter extends RecyclerView.Adapter<MYAdapter.ModelViewHolder> {
    Context context;
    ArrayList<Data>dataArrayList=new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;

    public MYAdapter(Context context, ArrayList<Data> dataArrayList, SQLiteDatabase sqLiteDatabase) {
        this.context = context;
        this.dataArrayList = dataArrayList;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @NonNull
    @Override
    public MYAdapter.ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_name,null);
        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYAdapter.ModelViewHolder holder, int position) {
        final Data model = dataArrayList.get(position);
        holder.txtNombre11.setText(model.getNombre());
        holder.txtAutor.setText(model.getAutor());
    }

    @Override
     public int getItemCount() {
        return dataArrayList.size();
    }

    public class ModelViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre11, txtAutor;
        public ModelViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre11=(TextView)itemView.findViewById(R.id.txtNombre11);
            txtNombre11=(TextView)itemView.findViewById(R.id.txtAutor);
        }
    }
}
