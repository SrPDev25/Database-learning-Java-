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
import model.Libro;

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
        String sql = "select tipo_usuario from tbl_usuarios where login='" + login + "' and pass='" + pass + "'";
        Statement sentencia;
        ResultSet resultado;

        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);
            String codigo = "";
            if (resultado.next()) {
                codigo = resultado.getString("tipo_usuario");
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

    public String nombreSocio(int numSocio) {
        String sql = "select nombre from tbl_usuarios where cod_usuario='" + numSocio + "'";
        Statement sentencia;
        ResultSet resultado;

        String nombre = "";
        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);
            if (resultado.next()) {
                nombre=resultado.getString("nombre");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nombre;
    }

    public ArrayList<Libro> getLibros() {
        ArrayList<Libro> libros = new ArrayList<>();
        String sql = "SELECT ISBN, nombre FROM tbl_libros";
        Statement sentencia;
        ResultSet resultado;

        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                libros.add(new Libro(resultado.getString("isbn"),
                         resultado.getString("nombre")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return libros;
    }

    public String isExistEjemplar(String isbn) {
        String sql="select codigo_ejemplar from tbl_ejemplares where isbn='"+isbn+"' and situacion='disponible';";
        Statement sentencia;
        ResultSet resultado;
        String cod_ejemplar="";
        
        try {
            sentencia=bd.getConexion().createStatement();
            resultado=sentencia.executeQuery(sql);
            if(resultado.next()){
                cod_ejemplar=resultado.getString("codigo_ejemplar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cod_ejemplar;
    }
    
    public int prestarLibro (String codigo_ejemplar,String usuario){
        String sql="UPDATE `tbl_ejemplares` SET `situacion`='Prestado', codigo_usuario="+usuario+","
                + " fecha_devolucion=(select DATE_ADD(current_date, INTERVAL 15 DAY))"
                + " WHERE `codigo_ejemplar`="+codigo_ejemplar+";";
        Statement sentencia;
        int resultado=-1;
        try {
            sentencia=bd.getConexion().createStatement();
            resultado=sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
//    select codigo_ejemplar from tbl_ejemplares where fecha_devolucion<current_date and codigo_ejemplar='';
    
}
