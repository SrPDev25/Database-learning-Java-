/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dam
 */
public class Enfermo {
    private String numeroSeguridadSocial;
    private String nombre;

    public Enfermo(String numeroSeguridadSocial, String nombre) {
        this.numeroSeguridadSocial = numeroSeguridadSocial;
        this.nombre = nombre;
    }

    public String getNumeroSeguridadSocial() {
        return numeroSeguridadSocial;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    
    
}
