/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;


public class Libro {

    private String cod_ejemplar;
    private String isbn;
    private String nombre;

    public Libro(String isbn, String nombre) {
        this.isbn = isbn;
        this.nombre = nombre;
    }

    public Libro(String cod_ejemplar, String isbn, String nombre) {
        this.cod_ejemplar = cod_ejemplar;
        this.isbn = isbn;
        this.nombre = nombre;
    }

    public Libro() {
    }
    
    
    
    public String getIsbn() {
        return isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCod_ejemplar() {
        return cod_ejemplar;
    }
    
    

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
    
}
