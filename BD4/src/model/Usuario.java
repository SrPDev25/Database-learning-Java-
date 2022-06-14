/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author satan
 */
public class Usuario {

    private String codigoUsuario;
    private char tipoUsuario;
    private String nombre;

    public Usuario(String codigoUsuario, char tipoUsuario, String nombre) {
        this.codigoUsuario = codigoUsuario;
        this.tipoUsuario = tipoUsuario;
        this.nombre = nombre;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public char getTipoUsuario() {
        return tipoUsuario;
    }

    @Override
    public String toString() {
        return codigoUsuario + "  "+nombre;
    }
    
    
    
}
