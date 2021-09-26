package GUI;

import DataContainers.MainDataContainer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
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

    //chart
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

        // Create an NumberAxis
        NumberAxis yAxis = new NumberAxis();
        yAxis.setRange(285,315);
        plot.setRangeAxis(yAxis);

        chart.setTitle(new TextTitle("Wykres Widoczności",
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );

        return chart;
    }


}
