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
import model.Categoria;
import model.Lista;
import model.Producto;
import model.ProductoLista;

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
                sentencia.close();
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
            sentencia.close();
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
            resultado.close();
            sentencia.close();
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
            resultado.close();
            sentencia.close();
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
                sentencia.close();
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
            sentencia.close();
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
            resultado.close();
            sentencia.close();
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
                        resultado.getString("denominacion"),
                        resultado.getInt("codigo_categoria")));
            }
            resultado.close();
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categorias;
    }

    public ArrayList<Producto> getProductos(int codigoCategoria) {
        ArrayList<Producto> categorias = new ArrayList<>();
        String sql = "select codigo_producto, denominacion, codigo_categoria from tblProductos where codigo_categoria='" + codigoCategoria + "'";
        Statement sentencia;
        ResultSet resultado;

        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                categorias.add(new Producto(
                        resultado.getInt("codigo_producto"),
                        resultado.getString("denominacion"),
                        resultado.getInt("codigo_categoria")));
            }
            resultado.close();
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categorias;
    }

    public int insertarLista(int codigo, String denominacion, ArrayList<ProductoLista> lista) {
        String sql = "insert into tblListas values ('" + codigo + "','" + denominacion + "')";
        //INSERT INTO tbllistas VALUES ('3', '3')
        Statement sentencia;
        int resultado = -1;
        if (!existeLista(codigo)) {

            try {
                sentencia = bd.getConexion().createStatement();
                resultado = sentencia.executeUpdate(sql);
                insertarProductoEnLista(lista, codigo);
                sentencia.close();
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultado;
    }

    private void insertarProductoEnLista(ArrayList<ProductoLista> lista, int codigo_lista) {
        String sql;
        Statement sentencia;
        int resultado = -1;
        for (ProductoLista i : lista) {
            sql = "INSERT INTO `tbllistas_productos` (`codigo_lista`, `codigo_producto`, `cantidad`) VALUES ('" + codigo_lista + "', '" + i.getCodigoProducto() + "', '" + i.getCantidad() + "');";
            try {
                sentencia = bd.getConexion().createStatement();
                resultado = sentencia.executeUpdate(sql);
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (resultado == -1) {
                break;
            }
        }

    }

    public int eliminarLista(int codigo) {
        String sql = "DELETE FROM `tbllistas` WHERE (`codigo_lista` = '" + codigo + "');";
        Statement sentencia;
        int resultado = -1;

        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeUpdate(sql);
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    /**
     * Comprueba ya existe la lista
     *
     * @param codigo
     * @return
     */
    public boolean existeLista(int codigo) {
        boolean existe = false;
        String sql = "select codigo_Lista from tblListas where codigo_Lista='" + codigo + "'";
        Statement sentencia;
        ResultSet resultado;

        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);
            existe = resultado.next();
            resultado.close();
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;

    }

    public ArrayList<Lista> getListas() {
        ArrayList<Lista> categorias = new ArrayList<>();
        String sql = "select codigo_lista, denominacion from tblListas";
        Statement sentencia;
        ResultSet resultado;

        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                categorias.add(new Lista(
                        resultado.getInt("codigo_lista"),
                        resultado.getString("denominacion")
                ));
            }
            resultado.close();
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categorias;
    }

    public ArrayList<ProductoLista> getProductosLista(int codigo) {
        ArrayList<ProductoLista> listaProductos = new ArrayList();
        //Consulta que coge de la tabla productos y listas_producto
        String sql = "select p.codigo_producto, denominacion , cantidad "
                + "from tblListas_productos lp, tblProductos p "
                + "where lp.codigo_producto = p.codigo_producto "
                + "and lp.codigo_lista='" + codigo + "'";
        Statement sentencia;
        ResultSet resultado;

        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                listaProductos.add(new ProductoLista(new Producto(
                        resultado.getInt("p.codigo_producto"),
                         resultado.getString("denominacion")),
                         resultado.getInt("cantidad")));
            }
            resultado.close();
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaProductos;
    }

    public int actualizarLista(ArrayList<ProductoLista> productos, int lista) {
        ArrayList<ProductoLista> original = getProductosLista(lista);
        int resultado = 0;
        try {
            Statement sentencia = bd.getConexion().createStatement();
            for (ProductoLista p : productos) {
                String sql = "";
                //Si no existe el producto en esta lista, lo inserta 
                if (!existeProductoLista(p, lista)) {
                    sql = "INSERT INTO `tbllistas_productos` "
                            + "(`codigo_lista`, `codigo_producto`, `cantidad`) "
                            + "VALUES ('" + lista + "', '" + p.getCodigoProducto() + "'"
                            + ", '" + p.getCantidad() + "');";
                    sentencia.executeUpdate(sql);
                    //Si la cantidad del producto ya existente es 0 se elimina
                } else if (p.getCantidad() == 0) {
                    sql = "delete from tblListas_productos "
                            + "where codigo_producto='" + p.getCodigoProducto() + "'"
                            + " and codigo_lista='" + lista + "'";
                    sentencia.executeUpdate(sql);
                    //Si ya existe ejecutamos un update de la cantidad
                } else {
                    sql = "UPDATE `tbllistas_productos` SET `cantidad`='" + p.getCantidad()
                            + "' WHERE `codigo_lista`='" + lista + "' and`codigo_producto`='" + p.getCodigoProducto() + "'";
                    sentencia.executeUpdate(sql);
                }
            }

            //Si no existe un producto
            for (ProductoLista p : original) {
                if (productos.indexOf(p) == -1) {
                    String sql = "delete from tblListas_productos "
                            + "where codigo_producto='" + p.getCodigoProducto() + "'"
                            + " and codigo_lista='" + lista + "'";
                    sentencia.executeUpdate(sql);
                }
            }
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    /**
     * Comprueba si un producto ya existe en una lista
     *
     * @param comprobacion
     * @param lista
     * @return
     */
    private boolean existeProductoLista(ProductoLista comprobacion, int lista) {
        String sql = "select * from tblListas_Productos where codigo_lista='" + lista + "' and codigo_producto='" + comprobacion.getCodigoProducto() + "'";
        boolean existe = false;
        try {
            Statement sentencia = bd.getConexion().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            existe = resultado.next();
            resultado.close();
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }

}
