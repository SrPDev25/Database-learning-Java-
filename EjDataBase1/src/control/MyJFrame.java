/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author dam
 */
public class MyJFrame extends JFrame {//Clase que hereda de JFrame

    /**
     * Centra el Jframe en la pantalla
     */
    public void centrar() {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize(); //Coge la dimension de la pantalla
        int height = pantalla.height; //coge la altura de la pantalla
        int width = pantalla.width; //coge el ancho de la pantalla
        setSize(width / 2, height / 2); //Determina el tamaño de la pantalla

        setLocationRelativeTo(null); //no mueve la localización de la pantalla
        setVisible(true);
        pack();
    }

    /**
     * Muestra un mensaje de confirmacion para cierre la ventana
 Recuerda deshabilitar el cierre en las propiedades del JFrame
     */
    public void cerrar() {
        int eleccion = JOptionPane.showConfirmDialog(this, "Desea cerrar el programa", "Cerrar", JOptionPane.WARNING_MESSAGE);
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

}
