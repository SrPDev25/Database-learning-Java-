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

    public Producto(int codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
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
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return codigo +" "+  denominacion ;
    }
    
    
}
