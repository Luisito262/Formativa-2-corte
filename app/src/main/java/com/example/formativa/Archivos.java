package com.example.formativa;

public class Archivos {
    private String codigo;
    private String nombre;
    private String tamano;
    private String tipo;

    public Archivos(String codigo,String nombre,String tamano,String tipo){
        this.codigo = codigo;
        this.nombre = nombre;
        this.tamano = tamano;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getTamano(){
        return tamano;
    }
    public void setTamano(String tamano){
        this.tamano = tamano;
    }
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Archivos{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tamaño='" + tamano + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
