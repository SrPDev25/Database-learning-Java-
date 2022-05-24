/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataBaseControl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
/**
 *
 * @author dam
 */
public class Conexion {
    
    private Connection conexion;
    
    /**
     * Hace un testeo para confirmar de que la libreria de la base de datos
     * existe
     *
     * @return
     */
    public int registrarDriver() {
        int resultado;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//una vez creado este el 
            //resto se añade en el solucionador de problemas
            resultado = 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName())
                    .log(Level.SEVERE, null, ex);
            resultado = -1;
        }
        return resultado;
    }
     public Connection getConexion() {
        return conexion;
    }

    /**
     * Establece la conexion
     *
     * @param url
     * @return retorna por si fallos
     */
    public int establecer(String url) {
        int resultado;
        resultado = registrarDriver();//Comprueba si esta el driver
        if (resultado != -1) {//Si no está no conecta
            resultado = conectar(url);//Conecta con la base
        }

        return resultado;
    }

    /**
     * Hace conexion con el servidor
     *
     * @param url
     * @return retorna un numero con el numero del fallo
     */
    public int conectar(String url) {
        int resultado;
        try {
            //Se utiliza la contraseña y usuario de la base de datos
            conexion = DriverManager.getConnection(url, "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        resultado = 0;
        return resultado;
    }
    
    public void cerrar(){
        
    }
    
}
