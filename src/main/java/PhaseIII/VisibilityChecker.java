package PhaseIII;

import DataContainers.MainDataContainer;
import DataContainers.VisibilityTable;
import GUI.Constants;

public class VisibilityChecker {

    //connection to GUI
    Constants constants = new Constants();


    //I don't really know why I did it like that but I had a plan. It needs to be check...
    public int indexChecker(double inclination){
        int i=0;
        int j=0;
        for (int value : VisibilityTable.inclinationList){
            j++;
            if(inclination<value){
                i=value;
                break;
            }
        }
        return j;
    }

    //I don't really know why I did it like that but I had a plan. It needs to be check...
    public int valueChecker(double inclination){
        int i=0;
        int j = 0;
        int[] indexes = {0,0};
        for (int value : VisibilityTable.inclinationList){
            j++;
            if(inclination<value){
                i=value;
                break;
            }
        }
        return i;
    }



    public int[] checkWhatSpeedIsSelected(){
        String speedString;
        speedString = constants.getWindow().getjComboBoxSpeedList().getSelectedItem().toString();
        int speed = Integer.parseInt(speedString);
        if(speed == 130)return VisibilityTable.speed130;
        if(speed == 120)return VisibilityTable.speed120;
        if(speed == 110)return VisibilityTable.speed110;
        if(speed == 100)return VisibilityTable.speed100;
        if(speed == 90)return VisibilityTable.speed90;
        if(speed == 80)return VisibilityTable.speed80;
        if(speed == 70)return VisibilityTable.speed70;
        if(speed == 60)return VisibilityTable.speed60;
        if(speed == 50)return VisibilityTable.speed50;
        if(speed == 40)return VisibilityTable.speed40;
        if(speed == 30)return VisibilityTable.speed30;
        else{return null;
        }
    }

    public void checkVisibilityWithInterpolation(){
        VisibilityChecker Visibility = new VisibilityChecker();
        Interpolation interp = new Interpolation();
        for (double value : MainDataContainer.inclination) {
            MainDataContainer.interpolatedVisibilityRange.add(interp.interpolate(
                    Visibility.valueChecker(value) - 2,
                    Visibility.valueChecker(value),
                    checkWhatSpeedIsSelected()[Visibility.indexChecker(value) - 1],
                    checkWhatSpeedIsSelected()[Visibility.indexChecker(value)],
                    value)
            );
        }
        for (double value : MainDataContainer.inclination) {
            MainDataContainer.interpolatedVisibilityRangeToExport.add(interp.interpolate(
                    Visibility.valueChecker(value) - 2,
                    Visibility.valueChecker(value),
                    checkWhatSpeedIsSelected()[Visibility.indexChecker(value) - 1],
                    checkWhatSpeedIsSelected()[Visibility.indexChecker(value)],
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
        for (double value : MainDataContainer.inclination) {
            MainDataContainer.nonInterpolatedVisibilityRangeToExport.add
                    (interp.lookForVisibilityRangeWithoutInterpolation(
                            VisibilityTable.speed130[Visibility.indexChecker(value) - 1],
                            VisibilityTable.speed130[Visibility.indexChecker(value)],
                            value)
                    );
        }
    }






}
