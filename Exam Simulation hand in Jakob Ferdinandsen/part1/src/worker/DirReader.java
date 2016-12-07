package worker;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by jakob on 23-11-16.
 */
public class DirReader {

    public DirReader() {
    }

    public File[] getFilesFromDir(String dir) {
        return new File(dir).listFiles();
    }


    public ArrayList<String> composeNumberOfLines(String path) {
        ArrayList<String> result = new ArrayList<>();
        for (File file : getFilesFromDir(path)) {
            result.add(file.getName() + " " + countLines(file));
        }
        return result;
    }


    public int countLines(File file) {
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader textReader = new BufferedReader(fr);
        int count = 0;
        String aLine;
        try {
            while ((aLine = textReader.readLine()) != null) {
                count++;
            }
            textReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void writeNumberOfLinesFile() {
        String currentDir = System.getProperty("user.dir");
        try {
            PrintWriter pw = new PrintWriter(currentDir + "/output/j1.txt");
            for (String line : composeNumberOfLines(currentDir + "/searchdir")) {
                pw.println(line);
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
