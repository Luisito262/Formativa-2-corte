package com.example.formativa;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ArchivoCursorAdapter extends CursorAdapter {

    public ArchivoCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.fila_archivos,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView id = view.findViewById(R.id.txtcodigo);
        TextView nombre = view.findViewById(R.id.txtnombre);
        TextView tamano = view.findViewById(R.id.txttamano);
        TextView tipo = view.findViewById(R.id.txttipo);

        id.setText("Codigo: " + cursor.getInt(0));
        nombre.setText("Nombre: "+ cursor.getString(1));
        tamano.setText("Tamaño: "+ cursor.getString(2));
        tipo.setText("Tipo: "+ cursor.getString(3));


    }

}
