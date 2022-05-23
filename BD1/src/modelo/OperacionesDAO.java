package modelo;

import baseDeDatos.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class OperacionesDAO {

    Conexion bd;

    public OperacionesDAO(Conexion bd) {
        this.bd = bd;
    }

    public OperacionesDAO() {
        this.bd = new Conexion();
        int resultado = bd.establecer("jdbc:mysql://localhost:3306/prog_primera_base");

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
        ArrayList<Enfermo> list = new ArrayList<>();
        Statement sentencia;
        ResultSet resultado;
        Enfermo e;
        //Retorna una tabla de todos los pacientes, se ponen los nombre para mayor mantenimiento
        String sql = "SELECT numeroSeguridadSocial, nombre "
                + "FROM tvlenfermos";
        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);
            //Pasa al siguiente registro del resultado, si no hay == false
            while (resultado.next()) {
                //Puedes usar la ubicacion de columna o su nombre (pref nombre)
                e = new Enfermo(resultado.getString("numeroSeguridadSocial"),
                        resultado.getString(2));
                list.add(e);
            }
        } catch (SQLException ex) {
        }

        return list;
    }

    public String getMedicamento(String codigo) {
        String nombre = "*****************";
        String sql = "select codigoMedicacion, denominacion, indicaciones"
                + " from medicaciones"
                + " where codigoMedicacion='" + codigo + "'";//Se usa comillas para un primitivo
        ResultSet resultado;
        Statement sentencia;
        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);
            if (resultado.next()) {
                nombre = resultado.getString("Denominacion");
            }
            resultado.close();//Se cierra para no mantener la información abierta
            sentencia.close();
        } catch (SQLException ex) {

        }

        return nombre;
    }

    public boolean existeMedicamento(String codigo) {
        boolean existe = false;
        String sql = "select codigoMedicacion"
                + " from medicaciones"
                + " where codigoMedicacion='" + codigo + "'";//Se usa comillas para un primitivo
        ResultSet resultado;
        Statement sentencia;
        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);
            existe = resultado.next();
            resultado.close();//Se cierra para no mantener la información abierta
            sentencia.close();
        } catch (SQLException ex) {

        }

        return existe;
    }

    public boolean existeMedicacion(String codigo, String numSeg) {
        boolean existe = false;
        String sql = "select codigoMedicacion,numeroSegSocial"
                + " from enfermoMedicacion"
                + " where codigoMedicacion='" + codigo + "'"
                + " and numeroSegSocial='" + numSeg + "'";//Se usa comillas para un primitivo
        ResultSet resultado;
        Statement sentencia;
        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);
            existe = resultado.next();
            resultado.close();//Se cierra para no mantener la información abierta
            sentencia.close();
        } catch (SQLException ex) {
            existe=true;
        }

        return existe;
    }

    public int asignarMedicacion(String codigoMedi, String numeroSeguridadSocial) {
        int resultado=-1;
        if (existeMedicamento(codigoMedi)) {
            if (!existeMedicacion(codigoMedi, numeroSeguridadSocial)) {
                resultado = anadirMedicamentoPaciente(codigoMedi, numeroSeguridadSocial);
            } else {
                resultado = -2;
            }
        }
        return resultado;
    }

    public int anadirMedicamentoPaciente(String codigoMedi, String codigoSS) {
        String sql = "INSERT INTO `enfermoMedicacion` "
                + "(`NumeroSegSocial`, `CodigoMedicacion`) VALUES ('"+codigoSS+"', '"+codigoMedi+"');";
        Statement sentencia;
        int resultado=-1;
        try {
            sentencia = bd.getConexion().createStatement();
            resultado=sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    /**
     * "')"; } Metodo creado porque se puede
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

    /**
     * Devuelve todos los medicamentos recetados a un paciente
     * @param nSeg
     * @return 
     */
    public ArrayList<Medicamento> consultMedicamento(String nSeg) {
        //Consulta que retorna la tabla de medicamentos de un paciente
        String sql="SELECT m.* FROM enfermoMedicación e\n" +
            "join medicaciones m on e.CodigoMedicacion=m.codigoMedicacion\n" +
            "where e.NumeroSegSocial='"+nSeg+"'";
        Statement sentencia;
        ArrayList<Medicamento> medi=new ArrayList<>();
        ResultSet resutlado;
        try {
            sentencia=bd.getConexion().createStatement();
            resutlado=sentencia.executeQuery(sql);
            while(resutlado.next()){
                Medicamento m= new Medicamento(
                        resutlado.getString("codigoMedicacion"),
                        resutlado.getString("Denominacion"), 
                        resutlado.getString("Indicaciones"));
                medi.add(m);
            }
            resutlado.close();
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return medi;
    }

}
