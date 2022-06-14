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
import model.Usuario;

/**
 *
 * @author dam
 */
public class OperacionesDAO {
    
    Conexion bd;
    
    public OperacionesDAO(Conexion bd) {
        this.bd = bd;
    }
    
    public String verificarUsuario(String login, String pass) {
        Character permiso = ' ';
        String usuario = "";
        String sql = "select tipo_usuario, cod_usuario from tbl_usuarios where login='" + login + "' and pass='" + pass + "'";
        Statement sentencia;
        ResultSet resultado;
        
        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);
            if (resultado.next()) {
                usuario = resultado.getString("tipo_usuario") + "/" + resultado.getString("cod_usuario");
            }
            resultado.close();
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuario;
        
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
                nombre = resultado.getString("nombre");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nombre;
    }
    
    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT cod_usuario, nombre, tipo_usuario FROM tbl_usuarios";
        Statement sentencia;
        ResultSet resultado;
        
        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                usuarios.add(new Usuario(resultado.getString("cod_usuario"),
                        resultado.getString("tipo_usuario").charAt(0),
                         resultado.getString("nombre")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarios;
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
    
    public ArrayList<Libro> getLibros(String codUsuario) {
        ArrayList<Libro> libros = new ArrayList<>();
        String sql = "Select e.codigo_ejemplar, l.isbn, l.nombre "
                + "from tbl_ejemplares e, tbl_libros l where l.isbn=e.isbn and codigo_usuario='" + codUsuario + "'";
        Statement sentencia;
        ResultSet resultado;
        
        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                libros.add(new Libro(resultado.getString("codigo_ejemplar"), resultado.getString("isbn"),
                        resultado.getString("nombre")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return libros;
    }
    
    public String isExistEjemplar(String isbn) {
        String sql = "select codigo_ejemplar from tbl_ejemplares where isbn='" + isbn + "' and situacion='disponible';";
        Statement sentencia;
        ResultSet resultado;
        String cod_ejemplar = "";
        
        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);
            if (resultado.next()) {
                cod_ejemplar = resultado.getString("codigo_ejemplar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cod_ejemplar;
    }
    
    public int prestarLibro(String codigo_ejemplar, String usuario) {
        String sql = "UPDATE `tbl_ejemplares` SET `situacion`='Prestado', codigo_usuario=" + usuario + ","
                + " fecha_devolucion=(select DATE_ADD(current_date, INTERVAL 15 DAY))"
                + " WHERE `codigo_ejemplar`=" + codigo_ejemplar + ";";
        Statement sentencia;
        int resultado = -1;
        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
//    select codigo_ejemplar from tbl_ejemplares where fecha_devolucion<current_date and codigo_ejemplar='';

    /**
     * Comprueba si la fecha de devolución ha pasado
     *
     * @param codEjemplar
     * @return
     */
    private int isFechaPasada(String codEjemplar) {
        int puede = 0;
        String sql = "select codigo_ejemplar from tbl_ejemplares where fecha_devolucion<current_date and codigo_ejemplar=' " + codEjemplar + " ' ";
        Statement sentencia;
        ResultSet resultado;
        
        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);
            if (resultado.next()) {
                puede = -2;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return puede;
    }

    /**
     * Comprueba si se ha renovado ya este producto
     *
     * @param codEjemplar
     * @return
     */
    private int isRenovado(String codEjemplar) {
        int puede = -3;
        String sql = "select codigo_ejemplar from tbl_ejemplares where renovado='si' and codigo_ejemplar=' " + codEjemplar + " ' ";
        Statement sentencia;
        ResultSet resultado;
        
        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);
            if (!resultado.next()) {
                puede = 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return puede;
    }
    
    private int isPosibleRenovacion(String codEjemplar) {
        int resultado = isFechaPasada(codEjemplar);
        
        if (resultado == 0) {
            resultado = isRenovado(codEjemplar);
        }
        
        return resultado;
    }
    
    public int comprobarRenovacion(String codEjemplar) {
        int resultado = 0;
        String sql = "UPDATE `tbl_ejemplares` SET "
                + " fecha_devolucion=(select DATE_ADD(current_date, INTERVAL 15 DAY)), renovado='si' "
                + " WHERE `codigo_ejemplar`=" + codEjemplar + ";";
        Statement sentencia;
        
        resultado = isPosibleRenovacion(codEjemplar);
        
        if (resultado == 0) {
            try {
                sentencia = bd.getConexion().createStatement();
                resultado = sentencia.executeUpdate(sql);
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
    
    public int renovar(String codEjemplar){
        String sql = "UPDATE `tbl_ejemplares` SET renovado='si', "
                + "fecha_devolucion=(select DATE_ADD(fecha_devolucion, INTERVAL 15 DAY)) " 
                + "WHERE `codigo_ejemplar`='"+codEjemplar+"';";
        Statement sentencia;
        int resultado = -1;
        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
}
