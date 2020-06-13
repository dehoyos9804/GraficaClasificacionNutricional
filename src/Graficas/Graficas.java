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
    
    //Constructor
    public Graficas(String title){
        super(title);
    }
    
    //Crear nuevo chart
    public void createChart(String titulo, String titulo_x, String titulo_y){
        dataset = createDataset();
        
        chart = ChartFactory.createScatterPlot(
                titulo,
                titulo_x, 
                titulo_y, 
                dataset);
        
        plot = (XYPlot) chart.getPlot();
    }
    
    //actualizar rango en x
    public void changeRangeX(double limiteInitial, double limiteFinal, double space){
        //rango eje x
        xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setRange(limiteInitial, limiteFinal);//agrego el raango en el eje de las x
        xAxis.setTickUnit(new NumberTickUnit(space));//agrego el espacio entre cada rango
    }
    
    //actualizar rango en y
    public void changeRangeY(double limiteInitial, double limiteFinal){
        //rango eje y
        plot.getRangeAxis().setRange(limiteInitial, limiteFinal);
    }
    
    //agregar imagen al plot
    public void addImagePlot(String path, Color color_fondo_chart, Color color_fondo_plot){
        try {
            String path_project = getClass().getClassLoader().getResource(".").getPath();
            
            File file = new File(path_project + path);
            BufferedImage image = ImageIO.read(file);
            //chart.setBackgroundImage(image);
            chart.setBackgroundPaint(color_fondo_chart);
            
            //color del fondo
            //plot.setBackgroundPaint(new Color(255, 228, 196));
            plot.setBackgroundPaint(color_fondo_plot);
            
            //agregar imagen de fondo
            plot.setBackgroundImage(image);
            
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo " +e.getMessage());
        }
    }
    
    public void createPanel(){
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
