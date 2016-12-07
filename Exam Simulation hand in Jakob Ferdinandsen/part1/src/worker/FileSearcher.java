package worker;

import struct.Result;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jakob on 23-11-16.
 */
public class FileSearcher {
    public ArrayList<Result> searchFiles(String phrase, File[] files) {
        ArrayList<Result> result = new ArrayList<>();
        for (File file : files) {
            Result searchResult = searchForPhrase(phrase, file);
            if (!searchResult.getResultString().equals("Not found")) {
                result.add(searchResult);
            }
        }
        Collections.sort(result);
        return result;
    }

    public Result searchForPhrase(String phrase, File file) {
        String result = "Not found";
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader textReader = new BufferedReader(fr);
        String aLine;
        int count = 0;
        try {
            while ((aLine = textReader.readLine()) != null) {
                int lastIndex = 0;
                while (lastIndex != -1) {
                    lastIndex = aLine.indexOf(phrase, lastIndex);
                    if (lastIndex != -1) {
                        count++;
                        lastIndex++;
                        result = file.getName();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result(count, result);
    }
}
