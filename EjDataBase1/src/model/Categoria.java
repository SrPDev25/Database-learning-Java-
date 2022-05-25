
package model;


public class Categoria {

    private int codigo;
    private String denominacion;

    public Categoria(int codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }

    @Override
    public String toString() {
        return codigo + " " + denominacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }
    
    
}
