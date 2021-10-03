package GUI;

import DataContainers.MainDataContainer;
import DataContainers.VisibilityTable;
import PhaseIII.VisibilityChecker;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

public class ChartMaker {

    private Constants constants = new Constants();

    //data imported to chart
    public XYDataset dataset(){
        var series = new XYSeries("interpolowana widoczność");
        int j=0;
        for(Double value : MainDataContainer.interpolatedVisibilityRange) {
            series.add(MainDataContainer.kmStartListInt.get(j), value);
            j++;
        }
        var dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }

    //method which creates chart itself so all visual attributes are also here
    public JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Wykres Widoczności",
                "pikietaż",
                "wymagana widoczność w [m]",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        // Create an NumberAxis. Range of y axis depends on max values of speed row in visibility ta table
        NumberAxis yAxis = new NumberAxis();
        try{
            String speedString = constants.getWindow().getjComboBoxSpeedList().getSelectedItem().toString();
            if (speedString.equals("130"))yAxis.setRange(270,400);
            if (speedString.equals("120"))yAxis.setRange(230,350);
            if (speedString.equals("110"))yAxis.setRange(190,290);
            if (speedString.equals("100"))yAxis.setRange(160,230);
            if (speedString.equals("90"))yAxis.setRange(110,200);
            if (speedString.equals("80"))yAxis.setRange(90,170);
            if (speedString.equals("70"))yAxis.setRange(70,120);
            if (speedString.equals("60"))yAxis.setRange(50,90);
            if (speedString.equals("50"))yAxis.setRange(40,60);
            if (speedString.equals("40"))yAxis.setRange(30,50);
            if (speedString.equals("30"))yAxis.setRange(0,30);
        } catch(NullPointerException e){
            yAxis.setRange(0,400);
        }
        plot.setRangeAxis(yAxis);

        chart.setTitle(new TextTitle("Wykres Widoczności",
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );

        return chart;
    }


}
