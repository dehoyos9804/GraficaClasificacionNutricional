/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficas;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ChartUtilities;
import sun.java2d.pipe.BufferedBufImgOps;

/**
 *
 * @author dehoyos
 */
public class Graficas extends JFrame{
    
    private JFreeChart chart;
    private XYDataset dataset;
    private XYPlot plot;
    private NumberAxis xAxis;
    public Graficas(String title){
        super(title);

        // Create dataset
        dataset = createDataset();

        // Create chart
        chart = ChartFactory.createScatterPlot(
                "Peso para la talla de niños (0 a 2 años)",
                "X-Longitu (cm)", "Y-Peso (kg)", dataset);
    
        //Changes background color
        plot = (XYPlot) chart.getPlot();
        
        //rango eje x
        xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setRange(45, 110);//agrego el raango en el eje de las x
        xAxis.setTickUnit(new NumberTickUnit(5));//agrego el espacio entre cada rango
        
        //rango eje y
        plot.getRangeAxis().setRange(0, 26);
        
        try {
            String path = getClass().getClassLoader().getResource(".").getPath();
            
            File file = new File(path + "/img/0-2.png");
            BufferedImage image = ImageIO.read(file);
            //chart.setBackgroundImage(image);
            chart.setBackgroundPaint(new Color(51,204,255));
            
            //color del fondo
            //plot.setBackgroundPaint(new Color(255, 228, 196));
            plot.setBackgroundPaint(Color.WHITE);
            
            //agregar imagen de fondo
            plot.setBackgroundImage(image);
            
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo " +e.getMessage());
        }
        
        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    public XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();

        //Boys (Age,weight) series
        XYSeries series1 = new XYSeries("Boys");
        //series.add(x, y)
        series1.add(50, 3);
        series1.add(55, 4);
        series1.add(60, 6);
        series1.add(65, 8);
        series1.add(70, 10);
        series1.add(75, 11);
        series1.add(80, 12);
        series1.add(85, 14);
        series1.add(90, 16);
        series1.add(96, 17);

        dataset.addSeries(series1);

        return dataset;
    }

    public JFreeChart getChart() {
        return chart;
    }

    public void setChart(JFreeChart chart) {
        this.chart = chart;
    }

    public XYDataset getDataset() {
        return dataset;
    }

    public void setDataset(XYDataset dataset) {
        this.dataset = dataset;
    }

    public XYPlot getPlot() {
        return plot;
    }

    public void setPlot(XYPlot plot) {
        this.plot = plot;
    }
    
  
}
