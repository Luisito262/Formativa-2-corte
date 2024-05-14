package com.example.formativa;

public class defBd {
    public static final String nameDB = "Archivos";
    public static final String tabla_ar = "archivo";
    public static final String col_cod = "codigo";
    public static final String col_nombre = "nombre";
    public static final String col_tam = "tamano";
    public static final String col_tipo= "tipo";

    public static final String crear_tabla = "CREATE TABLE IF NOT EXISTS "
            + defBd.tabla_ar + "(" + defBd.col_cod + " text primary key," +
            defBd.col_nombre + " text," +
            defBd.col_tam + " text," +
            defBd.col_tipo + " text);";
}

