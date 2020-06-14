/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficas;

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
    private NumberAxis yaxis;
    
    //Constructor
    public Graficas(String title){
        super(title);
    }
    
    //Crear nuevo chart
    public void createChart(String titulo, String tituloX, String tituloY){
        //dataset = createDataset();
        
        chart = ChartFactory.createScatterPlot(
                titulo,
                tituloX, 
                tituloY, 
                null);
        
        plot = (XYPlot) chart.getPlot();
    }
    
    //crear nuevo chart con dataset
    public void createChart(String titulo, String titulo_x, String titulo_y, XYSeries series[]){
        dataset = createDataset(series);
        
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
        xAxis.setRange(limiteInitial, limiteFinal);//agrego el rango en el eje de las x
        xAxis.setTickUnit(new NumberTickUnit(space));//agrego el espacio entre cada rango
    }
    
    //actualizar rango en y
    public void changeRangeY(double limiteInitial, double limiteFinal, double space){
        //rango eje y
        //plot.getRangeAxis().setRange(limiteInitial, limiteFinal);
        yaxis = (NumberAxis) plot.getRangeAxis();
        yaxis.setRange(limiteInitial, limiteFinal);//agrego el rango en el eje de las y
        yaxis.setTickUnit(new NumberTickUnit(space));//agrego el espacio entre cada rango
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

    public XYDataset createDataset(XYSeries[] series) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        //Boys (Age,weight) series
        /*XYSeries series1 = new XYSeries("Boys");
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

        dataset.addSeries(series1);*/
        //dataset.addSeries(series);
        for (int i = 0; i < series.length; i++) {
            dataset.addSeries(series[i]);
        }

        return dataset;
    }
    
    public XYSeries series(String titulo, double[][] seriesXY){
        XYSeries datos = new XYSeries(titulo);
        
        for (int j = 0; j < seriesXY.length ; j++) {
            datos.add(seriesXY[j][0], seriesXY[j][1]);
        }
        
        return datos;
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

    public NumberAxis getxAxis() {
        return xAxis;
    }

    public void setxAxis(NumberAxis xAxis) {
        this.xAxis = xAxis;
    }

    public NumberAxis getYaxis() {
        return yaxis;
    }

    public void setYaxis(NumberAxis yaxis) {
        this.yaxis = yaxis;
    }
    
    
    
}
