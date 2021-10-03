package PhaseI;

import java.io.*;

//this class is needed because file I received has been in some weird encoding.
public class EncodeToUTF8 {

    private static String newFileAdress;

    public void encode(File fileToEncode) throws IOException, FileNotFoundException {
        String fileAdress = fileToEncode.getCanonicalPath();

        BufferedReader in = new BufferedReader(
                new InputStreamReader((new FileInputStream(fileToEncode)), "UTF-8"));

        newFileAdress = fileAdress + "_UTF-8_temp.txt";
        File newFile = new File(fileAdress + "_UTF-8_temp.txt");
        FileWriter writer;
        writer = new FileWriter(newFile);
        String line;
        while ((line = in.readLine()) != null) {
            writer.write(line + "\n");
        }
        writer.close();

    }

    public static String getNewFileAdress() {
        return newFileAdress;
    }
}
