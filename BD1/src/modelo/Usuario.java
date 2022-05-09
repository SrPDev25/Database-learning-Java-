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

    public Usuario(String nombre, String pass, String login) {
        this.nombre = nombre;
        this.pass = pass;
        this.login = login;
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
