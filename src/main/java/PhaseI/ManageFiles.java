package PhaseI;

import java.io.*;

public class ManageFiles {

    String URL;
    File file;

    public ManageFiles(){}
    public ManageFiles(String URL) {
        this.URL = URL;
        this.file = new File(URL);
    }

    public File getFile() {
        return file;
    }

     public void deleteFile(String URL) {
        File fileToDelete = new File(URL);
        fileToDelete.delete();
     }



}
