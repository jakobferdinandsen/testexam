package worker;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Created by jakob on 23-11-16.
 */
public class DirReader {

    public DirReader(){}

    public ArrayList<String> composeNumberOfLines(Path path){
        ArrayList<String> result = new ArrayList<>();
        File[] files = new File("path").listFiles();
        for (File file : files) {

        }



        return result;
    }


    public int getNumberOfLines(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader textReader = new BufferedReader(fr);
        int count = 0;
        String aLine;
        while ((aLine = textReader.readLine()) != null) {
            count++;
        }
        textReader.close();
        return count;
    }
}
