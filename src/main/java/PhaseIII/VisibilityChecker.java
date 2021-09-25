package PhaseIII;

import java.util.ArrayList;

public class VisibilityChecker {
    static int designSpeed;
    static int[] inclinationTable = {-10, -8, -6, -4, -2, 0, 2, 4, 6, 8, 10};


    public int IndexChecker(double inclination){
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

    public int ValueChecker(double inclination){
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



}
