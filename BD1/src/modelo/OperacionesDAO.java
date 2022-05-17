package modelo;

import baseDeDatos.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OperacionesDAO {

    Conexion bd;

    public OperacionesDAO(Conexion bd) {
        this.bd = bd;
    }

    public Usuario existeUsuario(String pass, String login) {
        Usuario u = null;
        String sql = "Select login,pass, nombre, codigo, tipoUsuario"
                + " from tblUsuarios where login='"
                + login + "' and pass='" + pass + "'";

        Statement sentencia;
        ResultSet resultado;//Guarda el resultado de select en sql

        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);//Ejecuta la sentencia sql
            if (resultado.next()) {//Comprueba si existe información en el resultado
                u = new Usuario(resultado.getString("nombre"),
                        resultado.getString("pass"),
                        resultado.getString("login"),
                        resultado.getInt("Codigo"),
                        resultado.getString("tipoUsuario").charAt(0));//devuelve solo un caracter

            }
        } catch (SQLException ex) {
            //Logger.getLogger(OperacionDAO.class.getName())
        }
        //"Select login,pass, nombre from tblUsuarios where login='+login+'and pass='pass'"
        return u;
    }

    public char existeUsuarioChar(String pass, String login) {
        char u = ' ';
        String sql = "Select login, pass, nombre, codigo, tipoUsuario"
                + " from tblUsuarios where login='"
                + login + "' and pass='" + pass + "'";

        Statement sentencia;
        ResultSet resultado;//Guarda el resultado de select en sql

        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);//Ejecuta la sentencia sql
            if (resultado.next()) {//Comprueba si existe información en el resultado
                u = resultado.getString("tipoUsuario").charAt(0);//devuelve solo un caracter
            }
        } catch (SQLException ex) {
            //Logger.getLogger(OperacionDAO.class.getName())
        }
        //"Select login,pass, nombre from tblUsuarios where login='+login+'and pass='pass'"
        return u;
    }

    public ArrayList<Enfermo> getEnfermos() {
        ArrayList<Enfermo> list=new ArrayList<>();
        Statement sentencia;
        ResultSet resultado;
        Enfermo e;
        //Retorna una tabla de todos los pacientes, se ponen los nombre para mayor mantenimiento
        String sql="SELECT numeroSeguridadSocial, nombre "
                + "FROM tvlenfermos";
        try{
            sentencia=bd.getConexion().createStatement();
            resultado=sentencia.executeQuery(sql);
            while(resultado.next()){
                //Puedes usar la ubicacion de columna o su nombre (pref nombre)
                e=new Enfermo(resultado.getString("numeroSeguridadSocial")
                        ,resultado.getString(1));
            }
        }catch(SQLException ex){
            
        }
        
        
        return list;
    }

    /**
     * Metodo creado porque se puede
     *
     * @return
     */
    public ArrayList<Usuario> getTodoslosUsuarios() {
        Usuario u = null;
        ArrayList<Usuario> usuarios = new ArrayList<>();

        String sql = "Select login,pass, nombre"
                + " from tblUsuarios";

        Statement sentencia;
        ResultSet resultado;//Guarda el resultado de select en sql

        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);//Ejecuta la sentencia sql
            while (resultado.next()) {//Comprueba si existe información en el resultado
                u = new Usuario(resultado.getString("nombre"),
                        resultado.getString("pass"),
                        resultado.getString("login"),
                        resultado.getInt("codigo"),
                        resultado.getString("tipoUsuario").charAt(0));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(OperacionDAO.class.getName())
        }
        //"Select login,pass, nombre from tblUsuarios where login='+login+'and pass='pass'"
        return usuarios;
    }
}
