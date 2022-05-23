/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dam
 */
public class Medicamento {
    private String denominacion;
    private String codeMedicamento;
    private String indicaciones;

    public Medicamento(String denominacion, String codeMedicamento, String indicaciones) {
        this.denominacion = denominacion;
        this.codeMedicamento = codeMedicamento;
        this.indicaciones = indicaciones;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public String getCodeMedicamento() {
        return codeMedicamento;
    }

    public String getIndicaciones() {
        return indicaciones;
    }
    
    
}
