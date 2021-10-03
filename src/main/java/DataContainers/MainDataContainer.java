package DataContainers;

import java.util.ArrayList;

public class MainDataContainer {

    //here are values imported from
    public static ArrayList<Double> kmStartListInt = new ArrayList<Double>();
    public static ArrayList<Double> hStartListInt = new ArrayList<Double>();
    public static ArrayList<Double> kmEndListInt = new ArrayList<Double>();
    public static ArrayList<Double> hEndListInt = new ArrayList<Double>();

    //here are values calculated in PhaseI
    public static ArrayList<Double> inclination = new ArrayList<Double>();
    public static ArrayList<Double> interpolatedVisibilityRange = new ArrayList<Double>();
    public static ArrayList<Double> nonInterpolatedVisibilityRange = new ArrayList<Double>();

    //here are extensions to export
    public static String[] extensionsList = {"dxf", "txt", "csv"};


    //method clearContainers is used in Actions/Calculate to avoid
    //pointer exception when Visibility range is calculated for another speed
    public void clearContainers(){
        inclination.clear();
        interpolatedVisibilityRange.clear();
        interpolatedVisibilityRange.clear();
        nonInterpolatedVisibilityRange.clear();
    }
}
