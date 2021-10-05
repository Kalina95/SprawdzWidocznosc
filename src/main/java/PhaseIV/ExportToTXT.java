package PhaseIV;

import DataContainers.MainDataContainer;

import javax.lang.model.element.Element;
import java.io.*;
import java.util.ArrayList;

public class ExportToTXT {

    private File exportedFile;
    private ArrayList xData;
    private ArrayList yData;

    public ExportToTXT(ArrayList xData, ArrayList yData){
        this.xData = xData;
        this.yData = yData;
    }

    public void export(String URL) throws IOException {
        MainDataContainer dataContainer = new MainDataContainer();
        exportedFile = new File(URL);
        FileWriter writer = new FileWriter(exportedFile);

        int i = 0;
        for (Object o : xData){
            writer.write(xData.get(i) + " " + yData.get(i) + "\n");
            i++;
        }
        writer.close();


    }
}
