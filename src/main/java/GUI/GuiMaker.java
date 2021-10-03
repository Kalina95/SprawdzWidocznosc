package GUI;

import DataContainers.MainDataContainer;
import DataContainers.VisibilityTable;
import org.jfree.chart.ChartPanel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GuiMaker {

    final private JFrame mainFrame;
    final private JMenuBar menuMenuBar;
    final private JButton chooseFileButton;
    final private JButton calculateButton;
    final private JButton buttonExport;
    final private JPanel panelWithButtons;
    final private JPanel panelWithCharts;
    final private JLabel labelExport;
    final private JLabel labelLine;
    final private ChartPanel panelWithChart;
    final private JComboBox jComboBoxSpeedList;
    final private JComboBox jComboBoxExtensionLsit;

    ActionListener actionListener = new AssignActions();

    ChartMaker createChart;


    public GuiMaker() {
        this.mainFrame = new JFrame();
        this.menuMenuBar = new JMenuBar();
        this.chooseFileButton = new JButton("openFile");
        this.calculateButton = new JButton("calculate");
        this.buttonExport = new JButton("export");
        this.panelWithButtons = new JPanel();
        this.panelWithCharts = new JPanel();
        this.labelExport = new JLabel();
        this.labelLine = new JLabel();
        this.createChart = new ChartMaker();
        this.panelWithChart = new ChartPanel(createChart.createChart(createChart.dataset()));


        this.jComboBoxSpeedList = new JComboBox(VisibilityTable.speedList);
        this.jComboBoxExtensionLsit = new JComboBox(MainDataContainer.extensionsList);

    }


    public ChartPanel getPanelWithChart() {
        return panelWithChart;
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
        this.mainFrame.add(menuMenuBar, BorderLayout.NORTH);
        this.mainFrame.setJMenuBar(menuMenuBar);
    }

    public void panelWithButtonsProperties(){
        this.panelWithButtons.setLayout(new GridLayout(15,1,1,1));
        this.mainFrame.add(panelWithButtons, BorderLayout.WEST);
        this.panelWithButtons.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    }

    public void panelWithChartsProperties(){
        this.mainFrame.add(panelWithCharts, BorderLayout.EAST);
        this.panelWithCharts.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

    }

    public void panelWithchartProprties(ChartPanel panelWithChart){
        this.panelWithCharts.add(panelWithChart);
    }

    public JPanel getPanelWithCharts() {
        return panelWithCharts;
    }

    public void fileChooserProperties(String label){
        this.panelWithButtons.add(chooseFileButton);
        this.chooseFileButton.setLabel(label);
        this.chooseFileButton.addActionListener(actionListener);

    }

    public void buttonCalculateProperties(String label){
        this.panelWithButtons.add(calculateButton);
        this.calculateButton.setLabel(label);
        this.calculateButton.addActionListener(actionListener);
    }

    public void buttonExportProperties(String label){
        this.panelWithButtons.add(buttonExport);
        this.buttonExport.setLabel(label);
        this.buttonExport.addActionListener(actionListener);
    }


    public void labelExportProperties(String label){
        this.panelWithButtons.add(labelExport);
        this.labelExport.setText(label);
    }

    public void labelLineProperties(String label){
        this.panelWithButtons.add(labelLine);
        this.labelLine.setText(label);
    }




    public void speedListComboBoxProperties(){
        this.panelWithButtons.add(jComboBoxSpeedList);
        this.jComboBoxSpeedList.addActionListener(actionListener);
    }

    public void extensionsListComboBoxProperties(){
        this.panelWithButtons.add(jComboBoxExtensionLsit);
        this.jComboBoxExtensionLsit.addActionListener(actionListener);
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public JComboBox getjComboBoxSpeedList() {
        return jComboBoxSpeedList;
    }

    public JComboBox getjComboBoxExtensionLsit() {
        return jComboBoxExtensionLsit;
    }
}
