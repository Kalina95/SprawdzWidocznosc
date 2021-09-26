package GUI;

import DataContainers.MainDataContainer;
import org.jfree.JCommon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class GuiMaker {

    private JFrame mainFrame;
    private JMenuBar menu;
    private Button buttonChooseFile;
    private Button buttonInstructions;
    private Button buttonCalculate;
    private Button buttonExport;
    private JRadioButton exportExtension;
    private JFileChooser fileChooser;
    private JPanel panelWithButtons;
    private JPanel panelWithCharts;
    private JFreeChart chartWithInterpolatedValues;
    private JFreeChart chartWithNoninterpolatedValues;
    private JLabel labelExport;
    private JLabel labelLine;
    private ChartPanel panelWithChart;


    public GuiMaker() {
        this.mainFrame = new JFrame();
        this.menu = new JMenuBar();
        this.buttonChooseFile = new Button();
        this.buttonInstructions = new Button();
        this.buttonCalculate = new Button();
        this.buttonExport = new Button();
        this.exportExtension = new JRadioButton();
        this.fileChooser = new JFileChooser();
        this.panelWithButtons = new JPanel();
        this.panelWithCharts = new JPanel();
        //this.chartWithNoninterpolatedValues = new JFreeChart();
        this.labelExport = new JLabel();
        this.labelLine = new JLabel();
        ChartMaker createChart = new ChartMaker();
        this.panelWithChart = new ChartPanel(createChart.createChart(createChart.dataset()));

    }

    public void mainFrameProperties(String fileName, int width, int height){
        this.mainFrame.setSize(width, height);
        this.mainFrame.setResizable(false);
        this.mainFrame.setLayout(new BorderLayout());
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setTitle("Sprawdz Widocznosc " + fileName);
    }

    public void showMainFrame(){
        this.mainFrame.setVisible(true);
    }

    public void menuBarProperties(){
        this.mainFrame.add(menu, BorderLayout.NORTH);
        this.mainFrame.setJMenuBar(menu);
    }

    public void updateMainFrameTitle(String title){
        this.mainFrame.setTitle(title);
    }

    public void panelWithButtonsProperties(){
        this.panelWithButtons.setLayout(new GridLayout(15,1,1,1));
        this.mainFrame.add(panelWithButtons, BorderLayout.WEST);
    }

    public void panelWithChartsProperties(){
        this.mainFrame.add(panelWithCharts, BorderLayout.EAST);
    }

    public void buttonChooseFileProperties(){
        this.panelWithButtons.add(buttonChooseFile);
    }

    public void buttonInstructionsProperties(String label){
        this.panelWithButtons.add(buttonInstructions);
        this.buttonInstructions.setSize(20,5);
        this.buttonInstructions.setLabel(label);
    }

    public void fileChooserProperties(String label){
        this.panelWithButtons.add(buttonChooseFile);
        this.buttonChooseFile.setLabel(label);
    }

    public void buttonCalculateProperties(String label){
        this.panelWithButtons.add(buttonCalculate);
        this.buttonCalculate.setLabel(label);
    }

    public void buttonExportProperties(String label){
        this.panelWithButtons.add(buttonExport);
        this.buttonExport.setLabel(label);
    }

    public void radioButtonProperties(String label){
        this.panelWithButtons.add(exportExtension);
        this.exportExtension.setText(label);
    }

    public void labelExportProperties(String label){
        this.panelWithButtons.add(labelExport);
        this.labelExport.setText(label);
    }

    public void labelLineProperties(String label){
        this.panelWithButtons.add(labelLine);
        this.labelLine.setText(label);
    }

    public void panelWithchartProprties(){
        this.panelWithCharts.add(panelWithChart);
    }


    public JPanel getPanelWithButtons() {
        return panelWithButtons;
    }

    public JPanel getPanelWithCharts() {
        return panelWithCharts;
    }




}
