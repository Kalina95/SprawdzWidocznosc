package PhaseI;

import java.io.*;
import java.util.Scanner;

public class ManageFiles {

    String URL;
    File file;

    public ManageFiles(String URL) {
        this.URL = URL;
        this.file = new File(URL);
    }

    public File getFile() {
        return file;
    }

     public void deleteFile(File file) {
        file.delete();

     }



}
