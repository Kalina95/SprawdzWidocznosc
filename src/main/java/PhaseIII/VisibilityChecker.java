package PhaseIII;

import DataContainers.MainDataContainer;
import DataContainers.VisibilityTable;

import java.util.ArrayList;

public class VisibilityChecker {
    static int designSpeed;
    static int[] inclinationTable = {-10, -8, -6, -4, -2, 0, 2, 4, 6, 8, 10};


    public int indexChecker(double inclination){
        int i=0;
        int j = 0;
        int[] indexes = {0,0};
        for (int value : inclinationTable){
            j++;
            if(inclination<value){
                i=value;
                break;
            }
        }

        return j;
    }

    public int valueChecker(double inclination){
        int i=0;
        int j = 0;
        int[] indexes = {0,0};
        for (int value : inclinationTable){
            j++;
            if(inclination<value){
                i=value;
                break;
            }
        }

        return i;
    }


    public void checkVisibilityWithInterpolation(){
        VisibilityChecker Visibility = new VisibilityChecker();
        Interpolation interp = new Interpolation();
        for (double value : MainDataContainer.inclination) {
            MainDataContainer.interpolatedVisibilityRange.add(interp.interpolate(
                    Visibility.valueChecker(value) - 2,
                    Visibility.valueChecker(value),
                    VisibilityTable.speed130[Visibility.indexChecker(value) - 1],
                    VisibilityTable.speed130[Visibility.indexChecker(value)],
                    value)
            );
        }
    }

    public void checkVisibilityWithoutInterpolation(){
        VisibilityChecker Visibility = new VisibilityChecker();
        Interpolation interp = new Interpolation();
        for (double value : MainDataContainer.inclination) {
            MainDataContainer.nonInterpolatedVisibilityRange.add
                    (interp.lookForVisibilityRangeWithoutInterpolation(
                    VisibilityTable.speed130[Visibility.indexChecker(value) - 1],
                    VisibilityTable.speed130[Visibility.indexChecker(value)],
                    value)
            );
        }
    }






}
