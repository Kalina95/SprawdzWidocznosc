package GUI;

import javax.swing.*;
import java.io.File;

public class Actions {

    public Actions(){

    }

    private static File file;
    private static Constants constants = new Constants();

    public void openFile(){
        final JFileChooser chooseFile = new JFileChooser();
        chooseFile.setDialogTitle("Open file");
        chooseFile.setCurrentDirectory(file);
        int returnVal = chooseFile.showOpenDialog(constants.getWindow().getMainFrame());
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            file = chooseFile.getSelectedFile();
        }
        else{
            System.out.println("Dialog cancelled");
        }
    }

    public void calculate(){

    }

    public void export(){

    }
}
