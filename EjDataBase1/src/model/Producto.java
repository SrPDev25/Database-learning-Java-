/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class Producto {

    private int codigo;
    private String denominacion;
    private int codigo_categoria;

    public Producto(int codigo, String denominacion, int codigo_categoria) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.codigo_categoria = codigo_categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public int getCodigo_categoria() {
        return codigo_categoria;
    }

    @Override
    public String toString() {
        return codigo +" "+  denominacion ;
    }
    
    
}
