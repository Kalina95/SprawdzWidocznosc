import GUI.Constants;
import PhaseI.EncodeToUTF8;
import PhaseI.ManageFiles;
import PhaseIV.ExportToTXT;

public class Main {


    public static void main(String[] args) {

        /*
        Application during creation process was divided into 4 Phases:
        PhaseI - Import and decode txt file.
        PhaseII - PhaseII.Filter and normalize values.
        PhaseIII - Calculate visibility and inclination, showing data on chart.
        PhaseIV - Exporting values to txt, csv and dxf files.
         */

        Constants constants = new Constants();

        //containers
        constants.getWindow().mainFrameProperties("title", 900, 500);
        constants.getWindow().menuBarProperties();
        constants.getWindow().panelWithButtonsProperties();
        constants.getWindow().panelWithChartsProperties();
        constants.getWindow().fileChooserProperties("wybierz plik");
        constants.getWindow().speedListComboBoxProperties();
        constants.getWindow().buttonCalculateProperties("oblicz widoczność");
        constants.getWindow().labelLineProperties("");
        constants.getWindow().labelExportProperties("Wybierz format:");
        constants.getWindow().extensionsListComboBoxProperties();
        constants.getWindow().buttonExportProperties("export");
        constants.getWindow().panelWithchartProprties(constants.getWindow().getPanelWithChart());

        constants.getWindow().showMainFrame();

    }
}
