/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dam
 */
public class Usuario {
    private String nombre;
    private String pass;
    private String login;
    private int codigo;
    private char tipoUsuario;

    public Usuario(String nombre, String pass, String login, int codigo, char tipoUsuario) {
        this.nombre = nombre;
        this.pass = pass;
        this.login = login;
        this.codigo = codigo;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPass() {
        return pass;
    }

    public String getLogin() {
        return login;
    }
    
    
}
