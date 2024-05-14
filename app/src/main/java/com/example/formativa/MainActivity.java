package com.example.formativa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText codigo, nombre, tamano, tipo;

    Button guardar, consultar, actualizar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //EditText
        codigo = (EditText) findViewById(R.id.edtcodigoArchivo);
        nombre = (EditText) findViewById(R.id.edtnombreArchivo);
        tamano = (EditText) findViewById(R.id.edttamanoArchivo);
        tipo = (EditText) findViewById(R.id.edttiposArchivo);
        //Botones
        guardar = (Button) findViewById(R.id.btnguardar);
        consultar = (Button) findViewById(R.id.btnconsultar);
        actualizar = (Button) findViewById(R.id.btnactualizar);
        eliminar = (Button) findViewById(R.id.btnborrar);

        //Funcionalidad
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Archivos ar = new Archivos(codigo.getText().toString(), nombre.getText().toString(),
                        tamano.getText().toString(), tipo.getText().toString());
                ArchivoControl arc = new ArchivoControl(getApplicationContext());
                arc.agregarArchivos(ar);
            }
        });

        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ListadoArchivos.class);
                startActivity(i);
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Archivos ar = new Archivos(codigo.getText().toString(), nombre.getText().toString(),
                        tamano.getText().toString(), tipo.getText().toString());
                ArchivoControl arc = new ArchivoControl(getApplicationContext());
                arc.actualizarArchivos(ar);
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArchivoControl arc = new ArchivoControl(getApplicationContext());
                arc.eliminarArchivos(codigo.getText().toString());

            }
        });




    }
}