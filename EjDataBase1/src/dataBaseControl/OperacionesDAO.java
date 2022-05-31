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
import model.Categoria;
import model.Lista;
import model.Producto;

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

    public int eliminarCategoria(int codigo) {
        String sql = "delete from tblCategorias where codigo_categoria='" + codigo + "' ";
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

    private boolean existeCategoria(int codigo) {
        boolean existe = false;
        String sql = "select codigo_categoria from tblcategorias where codigo_categoria='" + codigo + "'";
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

    public ArrayList<Categoria> getCategorias() {
        ArrayList<Categoria> categorias = new ArrayList<>();
        String sql = "select codigo_categoria, denominacion from tblcategorias";
        Statement sentencia;
        ResultSet resultado;

        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                categorias.add(new Categoria(
                        resultado.getInt("codigo_categoria"),
                         resultado.getString("denominacion")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categorias;
    }

    
    public int insertarProducto(int codigo, String denominacion, int codigo_categoria) {
        String sql = "insert into tblProductos values ('" + codigo + "','" + denominacion + "','" + codigo_categoria + "');";
        Statement sentencia;
        int resultado = -1;
        if (!existeProducto(codigo)) {

            try {
                sentencia = bd.getConexion().createStatement();
                resultado = sentencia.executeUpdate(sql);
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultado;
    }

    public int eliminarProducto(int codigo) {
        String sql = "delete from tblProductos where codigo_producto='" + codigo + "' ";
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

    private boolean existeProducto(int codigo) {
        boolean existe = false;
        String sql = "select codigo_Producto from tblProductos where codigo_producto='" + codigo + "'";
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
    
    public ArrayList<Producto> getProductos() {
        ArrayList<Producto> categorias = new ArrayList<>();
        String sql = "select codigo_producto, denominacion, codigo_categoria from tblProductos";
        Statement sentencia;
        ResultSet resultado;

        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                categorias.add(new Producto(
                        resultado.getInt("codigo_producto"),
                         resultado.getString("denominacion")
                        ,resultado.getInt("codigo_categoria")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categorias;
    }
    
    public ArrayList<Producto> getProductos(int codigoCategoria) {
        ArrayList<Producto> categorias = new ArrayList<>();
        String sql = "select codigo_producto, denominacion, codigo_categoria from tblProductos where codigo_categoria='"+codigoCategoria+"'";
        Statement sentencia;
        ResultSet resultado;

        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                categorias.add(new Producto(
                        resultado.getInt("codigo_producto"),
                         resultado.getString("denominacion")
                        ,resultado.getInt("codigo_categoria")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categorias;
    }
    
    public int insertarLista(int codigo, String denominacion) {
        String sql = "insert into tblLista values ('" + codigo + "','" + denominacion + "')";
        Statement sentencia;
        int resultado = -1;
        if (!existeProducto(codigo)) {

            try {
                sentencia = bd.getConexion().createStatement();
                resultado = sentencia.executeUpdate(sql);
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultado;
    }

    public int eliminarLista(int codigo) {
        String sql = "delete from tblListas where codigo_Lista='" + codigo + "' ";
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

    private boolean existeLista(int codigo) {
        boolean existe = false;
        String sql = "select codigo_Lista from tblListas where codigo_Lista='" + codigo + "'";
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
    
    public ArrayList<Lista> getListas() {
        ArrayList<Lista> categorias = new ArrayList<>();
        String sql = "select codigo_producto, denominacion from tblListas";
        Statement sentencia;
        ResultSet resultado;

        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                categorias.add(new Lista(
                        resultado.getInt("codigo_producto"),
                         resultado.getString("denominacion")
                        ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categorias;
    }
    
}
