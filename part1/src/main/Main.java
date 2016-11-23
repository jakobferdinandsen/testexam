package main;

import struct.Result;
import worker.DirReader;
import worker.FileSearcher;
import java.util.Scanner;

/**
 * Created by jakob on 23-11-16.
 */
public class Main {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        DirReader dirReader = new DirReader();
        FileSearcher fileSearcher = new FileSearcher();
        dirReader.writeNumberOfLinesFile();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(currentDir + ": ");
            String input = scanner.next();
            for (Result result : fileSearcher.searchFiles(input, dirReader.getFilesFromDir(currentDir + "/searchdir/"))) {
                System.out.println("I found "+result.getCount()+" occurances of \""+input+"\" in "+result.getResultString());
            }
        }

    }
}
