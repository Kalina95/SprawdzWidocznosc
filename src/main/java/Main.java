import DataContainers.MainDataContainer;
import DataContainers.VisibilityTable;
import PhaseI.EncodeToUTF8;
import PhaseI.ManageFiles;
import PhaseII.Filter;
import PhaseIII.InclinationCalculator;
import PhaseIII.Interpolation;
import PhaseIII.VisibilityChecker;

import java.io.IOException;

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


        //************************************************************************
        //Phase I
        //Importing, decoding and creating new file encoded to UTF-8.
        String URL = "src/main/resources/S19_niweleta.txt";
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
        //End of Phase I
        //new file should be created in resources.
        //************************************************************************


        //************************************************************************
        //Phase II
        ManageFiles encodedFile = new ManageFiles(newUrl);
        Filter kmFilter = new Filter();
        try {
            kmFilter.reader(encodedFile.getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //End of Phase II
        //Values from new File.txt are in Data Container
        //************************************************************************


        //************************************************************************
        //Phase III
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
        //End of Phase III
        //inclination and visibility range are now in Data container.
        //************************************************************************



        //************************************************************************
        //Phase IV

        //End of Phase IV
        //************************************************************************

    }
}
