package com.example.formativa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class ArchivoControl {
    private BaseDatos bd;
    private Context c;

    public ArchivoControl (Context c){
        this.bd = new BaseDatos(c,defBd.nameDB, 1);
        this.c = c;
    }
    public void agregarArchivos(Archivos a) {
        try {
            SQLiteDatabase sql = bd.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put(defBd.col_cod, a.getCodigo());
            valores.put(defBd.col_nombre, a.getNombre());
            valores.put(defBd.col_tam, a.getTamano());
            valores.put(defBd.col_tipo, a.getTipo());
            if (!buscarArchivos(a)) {
                long id = sql.insert(defBd.tabla_ar, null, valores);
                Toast.makeText(c, "El registro ha sido existoso", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(c, "El id que coloco ya existe en el sistema, vuelva intentar", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(c, "Error en la operacion " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public boolean buscarArchivos(Archivos a) {
        String[] arg = new String[]{a.getCodigo()};

        SQLiteDatabase sql = bd.getReadableDatabase();
        Cursor c = sql.query(defBd.tabla_ar, null, "codigo=?", arg, null, null, null);
        if (c.getCount() > 0) {
            bd.close();
            return true;
        } else {
            return false;
        }
    }
    public void actualizarArchivos(Archivos a) {
        try {
            SQLiteDatabase sql = bd.getWritableDatabase();
            String arg[] = {a.getCodigo()};
            ContentValues values = new ContentValues();
            values.put(defBd.col_nombre, a.getNombre());
            values.put(defBd.col_tam, a.getTamano());
            values.put(defBd.col_tipo, a.getTipo());
            sql.update(defBd.tabla_ar, values, "codigo=?", arg);
            Toast.makeText(this.c, "e ha Actualizado de manera exitosa", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(c, "Error en la operacion " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminarArchivos(String codigo) {
        try {
            SQLiteDatabase sql = bd.getWritableDatabase();
            String[] arg = new String[]{codigo};
            sql.delete(defBd.tabla_ar, "codigo=?", arg);
            Toast.makeText(this.c, "Se ha eliminado correctamente", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(c, "Error en la operacion " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor allArchivos() {
        Cursor cur;
        try {
            SQLiteDatabase sql = bd.getReadableDatabase();
            //cur = sql.query(DefBD.tabla_pel,null,null,null,null,null,DefBD.col_nombre);
            cur = sql.rawQuery("select codigo as _id, nombre, tamano, tipo from archivo order by " + defBd.col_nombre, null);
            return cur;
        } catch (Exception e) {
            Toast.makeText(c, "Error en la operacion " + e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }






}
