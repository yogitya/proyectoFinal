package com.example.partituras;

public class Data {

    private int id;
    private String nombre;
    private String autor;
    private String dificultad;
    private int seleccion;

    public Data(int id, String nombre, String autor, String dificultad, int seleccion) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.dificultad = dificultad;
        this.seleccion = seleccion;
    }

    public Data() {
    }

    public String toString() {
        return "Data {" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", autor=" + autor +
                ", dificultad=" + dificultad +
                ", seleccion=" + seleccion +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }
}
