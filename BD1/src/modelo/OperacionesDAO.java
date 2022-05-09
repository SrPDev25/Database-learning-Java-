
package modelo;

import baseDeDatos.Conexion;


public class OperacionesDAO {
    Conexion bd;

    public OperacionesDAO(Conexion bd) {
        this.bd = bd;
    }
    
    public Usuario existeUsuario(String pass, String login){
        Usuario u=null;
        
        //"Select login,pass, nombre from tblUsuarios where login='+login+'and pass='pass'"
        
        
        
        return u;
    }
}
