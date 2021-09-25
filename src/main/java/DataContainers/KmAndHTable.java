package DataContainers;

import java.util.ArrayList;

public class KmAndHTable {
    public static ArrayList<Double> kmStartListInt = new ArrayList<Double>();
    public static ArrayList<Double> hStartListInt = new ArrayList<Double>();
    public static ArrayList<Double> kmEndListInt = new ArrayList<Double>();
    public static ArrayList<Double> hEndListInt = new ArrayList<Double>();

    public static ArrayList<Double> inclination = new ArrayList<Double>();

    public static int[] inclinationTable = {-10, -8, -6, -4, -2, 0, 2, 4, 6, 8, 10};
    public static int[] speed130 = {0, 0, 390, 350, 330, 310, 300, 290, 280, 0, 0};

    public static void printAllValues(ArrayList list){
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
