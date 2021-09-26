package PhaseII;

import DataContainers.MainDataContainer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Filter {

    public void reader(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            if(scanner.hasNext()) {
                String word = scanner.next();
                if(mainFilter(word)) {
                    sendValuesToContainer(normalizer(scanner.next()), MainDataContainer.kmStartListInt);
                    sendValuesToContainer(normalizer(scanner.next()), MainDataContainer.hStartListInt);
                    sendValuesToContainer(normalizer(scanner.next()), MainDataContainer.kmEndListInt);
                    sendValuesToContainer(normalizer(scanner.next()), MainDataContainer.hEndListInt);
                    //System.out.println("------------");
                }
            }
            else{
                break;
            }
        }
    }

    boolean mainFilter(String nextString){
        if(nextString.equals("Liniowy")|nextString.equals("Parabola")){
            return true;
        }
        else{
            return false;
        }
    }

    void sendValuesToContainer(String stringToSend, ArrayList list){
        list.add(stringToSend);
    }
    void sendValuesToContainer(Double intToSend, ArrayList list){
        list.add(intToSend);
    }

    Double normalizer(String stringToNormalize){
        String newString= null;
        if (stringToNormalize.contains("+") | stringToNormalize.contains(".")){
            newString=stringToNormalize.replace("+", "");
            //newString=newString.replace(".", ",");
        }
        double intValueOfString;
        if (newString.equals("0000.00")){
            newString="0.00";
            intValueOfString=Double.valueOf(newString);
            //System.out.println(intValueOfString);
            return intValueOfString;
        }
        else{
            if(newString.startsWith("00")){
                newString=newString.substring(2);
            }
            if(newString.startsWith("0")){
                newString=newString.substring(1);
            }
        }
        intValueOfString=Double.valueOf(newString);
        //System.out.println(intValueOfString);
        return intValueOfString;
    }




}
