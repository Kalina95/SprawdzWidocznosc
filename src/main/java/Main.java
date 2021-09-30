import GUI.Constants;

public class Main {


    public static void main(String[] args) {

        /*
        Application is divided into 4 Phases:
        PhaseI - Import and decode txt file.
        PhaseII - PhaseII.Filter and normalize values.
        PhaseIII - Calculate visibility and inclination.
        PhaseIV - Show Values on charts.

        Creating GUI is another task.
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
        //End of Phase IV
        //************************************************************************

    }
}
