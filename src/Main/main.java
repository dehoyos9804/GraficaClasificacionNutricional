/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Graficas.Graficas;
import java.awt.Color;
import java.awt.Window;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author dehoyos
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //private static int COUNT = 110;
        //private static int UNITS = 5;
        SwingUtilities.invokeLater(()->{
            Graficas example = new Graficas("GRAFICAS DE LOS PATRONES DE CRECIMIENTO OMS PARA NIÑAS, NIÑOS Y ADOLESCENTES MENORES DE 18 AÑOS.");
            example.setSize(800, 700);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
    
}
