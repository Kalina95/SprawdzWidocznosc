package PhaseI;

import java.io.*;

public class EncodeToUTF8 {

    public static String newFileAdress;

    public void encode(File fileToEncode) throws IOException, FileNotFoundException {
        String fileAdress = fileToEncode.getCanonicalPath();

        BufferedReader in = new BufferedReader(
                new InputStreamReader((new FileInputStream(fileToEncode)), "UTF-8"));

        newFileAdress = fileAdress + "_UTF-8_temp";
        File newFile = new File(fileAdress + "_UTF-8_temp");
        FileWriter writer;
        writer = new FileWriter(newFile);
        String line;
        while ((line = in.readLine()) != null) {
            writer.write(line + "\n");
        }
        writer.close();

    }

}
