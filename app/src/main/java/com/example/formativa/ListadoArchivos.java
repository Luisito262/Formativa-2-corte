package com.example.formativa;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.Toast;

public class ListadoArchivos extends AppCompatActivity {

    ListView listado;

    ArchivoCursorAdapter arcur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_archivos);
        listado = (ListView) findViewById(R.id.lstlistado);
        ArchivoControl arc = new ArchivoControl(this);
        Cursor cur = arc.allArchivos();
        if (cur.getCount() > 0) {
            arcur = new ArchivoCursorAdapter(this, cur, false);
            listado.setAdapter(arcur);
            listado.setTextFilterEnabled(true);
            arcur.setFilterQueryProvider(new FilterQueryProvider() {
                @Override
                public Cursor runQuery(CharSequence constraint) {
                    return null;
                }
            });
        }
        else
            Toast.makeText(getApplicationContext(), "No hay datos",Toast.LENGTH_SHORT).show();
    }


}
