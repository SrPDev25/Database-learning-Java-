/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataBaseControl;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dam
 */
public class OperacionesDAO {

    Conexion bd;

    public OperacionesDAO(Conexion bd) {
        this.bd = bd;
    }

    public char verificarUsuario(String login, String pass) {
        Character permiso = ' ';
        String sql = "select cod_usuario u from tbl_usuarios where login='" + login + "' and pass='" + pass + "'";
        Statement sentencia;
        ResultSet resultado;

        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);
            String codigo="";
            if (resultado.next()) {
                codigo = resultado.getString("u");
            }
            if (codigo.length() != 0) {
                permiso = codigo.charAt(0);
            }
            resultado.close();
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return permiso;

    }

}
