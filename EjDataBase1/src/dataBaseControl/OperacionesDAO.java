/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataBaseControl;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam
 */
public class OperacionesDAO {

    Conexion bd;

    public OperacionesDAO(Conexion bd) {
        this.bd = bd;
    }

    public int insertarCategoria(int codigo, String denominacion) {
        String sql = "insert into tblCategorias values ('" + codigo + "','" + denominacion + "');";
        Statement sentencia;
        int resultado = -1;
        if (!existeCategoria(codigo)) {

            try {
                sentencia = bd.getConexion().createStatement();
                resultado = sentencia.executeUpdate(sql);
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultado;
    }

    private boolean existeCategoria(int codigo) {
        boolean existe = false;
        String sql = "select codigo_categoria from tblcategorias where codigo_categoria='"+codigo+"'";
        Statement sentencia;
        ResultSet resultado;

        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);
            existe = resultado.next();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;

    }
}
