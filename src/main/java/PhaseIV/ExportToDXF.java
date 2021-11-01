package PhaseIV;

import DataContainers.MainDataContainer;

import java.awt.*;
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


        for (int i=0; i<xData.size()-1;){

            System.out.println("x"+ i + " --- " + xData.get(i));
            System.out.println("y"+ i + " --- " + yData.get(i));
            i++;
            System.out.println("x"+ i + " --- " + xData.get(i));
            System.out.println("y"+ i + " --- " + yData.get(i));

        }
        Double globalX2=0.00;
        Double globalY2=0.00;
        for (int i=0; i<xData.size()-1;){
            Double x1 = xData.get(i);
            Double y1 = yData.get(i);
            i++;
            Double x2 = xData.get(i);
            Double y2 = yData.get(i);


            String stringX = String.valueOf(Math.round(x1*100.00)/100.00);
            String stringY = String.valueOf(Math.round(y1*100.00)/100.00);
            String coordinates = "[" + stringX + ";" + stringY + "]";

            dxfGraphics.drawLine(x1,-y1*100,x2,-y2*100);
            dxfGraphics.drawPoint(x1,-y1*100);

            dxfGraphics.setFont(new Font(Font.MONOSPACED,
                    Font.PLAIN, 50));
            dxfGraphics.drawString(coordinates,x1,-y1*100);
            globalX2=x2;
            globalY2=y2;
        }

        String stringX = String.valueOf(Math.round(globalX2*100.00)/100.00);
        String stringY = String.valueOf(Math.round(globalY2*100.00)/100.00);
        String coordinates = "[" + stringX + ";" + stringY + "]";

        dxfGraphics.drawPoint(globalX2,-globalY2*100);

        dxfGraphics.setFont(new Font(Font.MONOSPACED,
                Font.PLAIN, 50));
        dxfGraphics.drawString(coordinates,globalX2,-globalY2*100);


        String dxfText = dxfDocument.toDXFString();
        FileWriter fileWriter = new FileWriter(URL);
        fileWriter.write(dxfText);
        fileWriter.flush();
        fileWriter.close();

    }
}
