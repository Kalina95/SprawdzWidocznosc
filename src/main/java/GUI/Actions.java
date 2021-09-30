package GUI;

import DataContainers.MainDataContainer;
import PhaseI.EncodeToUTF8;
import PhaseI.ManageFiles;
import PhaseII.Filter;
import PhaseIII.InclinationCalculator;
import PhaseIII.VisibilityChecker;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Actions {

    public Actions(){

    }

    private static File file;
    private static String URL;
    private static Constants constants = new Constants();

    public void openFile(){
        final JFileChooser chooseFile = new JFileChooser();
        chooseFile.setDialogTitle("Open file");
        chooseFile.setCurrentDirectory(file);
        int returnVal = chooseFile.showOpenDialog(constants.getWindow().getMainFrame());
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            file = chooseFile.getSelectedFile();
            URL = chooseFile.getSelectedFile().getPath();

            try {
                //Import
                ManageFiles file = new ManageFiles(URL);
                //Encoding and creating new file
                EncodeToUTF8 encodeFile = new EncodeToUTF8();
                encodeFile.encode(file.getFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
            String newUrl = EncodeToUTF8.newFileAdress;
            ManageFiles encodedFile = new ManageFiles(newUrl);
            Filter kmFilter = new Filter();
            try {
                kmFilter.reader(encodedFile.getFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Dialog cancelled");
        }
    }

    public void calculate(){
        InclinationCalculator calc = new InclinationCalculator();
        int i = 0;
        for (double value : MainDataContainer.kmStartListInt) {
            MainDataContainer.inclination.add(calc.calculateInclination(
                    MainDataContainer.kmStartListInt.get(i),
                    MainDataContainer.hStartListInt.get(i),
                    MainDataContainer.kmEndListInt.get(i),
                    MainDataContainer.hEndListInt.get(i)));
            i++;
        }

        VisibilityChecker checkVisibility = new VisibilityChecker();
        checkVisibility.checkVisibilityWithInterpolation();
        checkVisibility.checkVisibilityWithoutInterpolation();

        constants.getWindow().getPanelWithCharts().removeAll();
        constants.getWindow().getPanelWithCharts().revalidate();

        ChartMaker newChart = new ChartMaker();
        ChartPanel newPanelWithChart = new ChartPanel(newChart.createChart(newChart.dataset()));
        constants.getWindow().getPanelWithCharts().add(newPanelWithChart);
        constants.getWindow().getPanelWithCharts().repaint();

        MainDataContainer dataContainer = new MainDataContainer();
        dataContainer.clearContainers();

    }

    public void export(){

    }
}
