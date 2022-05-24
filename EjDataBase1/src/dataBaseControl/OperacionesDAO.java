/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataBaseControl;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam
 */
public class OperacionesDAO {
    
    Conexion bd;
    
    public OperacionesDAO(Conexion bd){
        this.bd=bd;
    }
    
    public int existeUsuario(String login, String pass){
        String sql="select count(*) from tblUsuarios where"
                + " login='"+login+"' and pass='"+pass+"'";
        int result=-1;
        
        Statement sentencia;
        ResultSet resultado;//guarda la tabla resutado de sql
        try {
            sentencia=bd.getConexion().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return result;
    }
    
}
