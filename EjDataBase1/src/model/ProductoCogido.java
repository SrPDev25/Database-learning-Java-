/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.util.Objects;


public class ProductoCogido {
    private Producto productoCogido;
    private int cantidad;

    public ProductoCogido(Producto productoCodigo, int cantidad) {
        this.productoCogido = productoCodigo;
        this.cantidad = cantidad;
    }

    public ProductoCogido(Producto productoCogido) {
        this.productoCogido = productoCogido;
    }

    
    
    public Producto getProductoCodigo() {
        return productoCogido;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return  productoCogido +"  " +cantidad +" Unidades";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.productoCogido);
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
        final ProductoCogido other = (ProductoCogido) obj;
        if (!Objects.equals(this.productoCogido, other.productoCogido)) {
            return false;
        }
        return true;
    }
    
    
}
