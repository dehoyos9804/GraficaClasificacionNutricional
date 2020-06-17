/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import graficas.Graficas;
import java.awt.Color;
import java.awt.Window;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.data.xy.XYSeries;

/**
 *
 * @author dehoyos
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            //preparar los datos que se agregarán {x, y}
            double[][] XYBoys = {
                {50, 3},
                {55, 4},
                {60, 6},
                {65, 8},
                {70, 10},
                {75, 11},
                {80, 12},
                {85, 14},
                {90, 16},
                {96, 17},
            };
            
            double[][] XYGirls = {
                {50, 4},
                {55, 6},
                {60, 8},
                {65, 9},
                {70, 11},
                {75, 12},
                {80, 13},
                {85, 15},
                {90, 17},
                {95, 16},
            };
            
            XYSeries series[] = new XYSeries[2];
            
            //instanacio la nueva graafica
            Graficas example = new Graficas("GRAFICAS DE LOS PATRONES DE CRECIMIENTO OMS PARA NIÑAS, NIÑOS Y ADOLESCENTES MENORES DE 18 AÑOS.");
            
            //agrego mi nuevas series
            series[0] = example.series("paciente", XYBoys);
            series[1] = example.series("girls", XYGirls);
            
            //creo la nueva gráfica
            example.createChart("Peso para la talla de niños (0 a 2 años)", "Longitud (cm)", "Peso (kg)", series);
            example.changeRangeX(45, 110, 5);
            example.changeRangeY(0, 26, 1);
            example.addImagePlot("/img/0-2.png", new Color(51,204,255), Color.WHITE);
            example.createPanel();
            
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);//centrar panel
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
    
}
