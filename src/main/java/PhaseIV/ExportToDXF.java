package PhaseIV;

import DataContainers.MainDataContainer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.jsevy.jdxf.*;



public class ExportToDXF {

    private File exportedFile;
    private ArrayList<Double> xData;
    private ArrayList<Double> yData;

    public ExportToDXF(ArrayList xData, ArrayList yData){
        this.xData = xData;
        this.yData = yData;
    }

    public void export(String URL) throws IOException {


        MainDataContainer dataContainer = new MainDataContainer();
        DXFDocument dxfDocument = new DXFDocument("ExportChartToDXF");
        DXFGraphics dxfGraphics = new DXFGraphics(dxfDocument);


        for (int i=0; i<xData.size()-1; i++){
            Double x1 = xData.get(i);
            Double y1 = yData.get(i);
            i++;
            Double x2 = xData.get(i);
            Double y2 = yData.get(i);

            dxfGraphics.drawLine(x1,y1,x2,y2);
        }


        String dxfText = dxfDocument.toDXFString();
        FileWriter fileWriter = new FileWriter(URL);
        fileWriter.write(dxfText);
        fileWriter.flush();
        fileWriter.close();

    }
}
