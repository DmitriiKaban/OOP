package dima.util;

import dima.document.Document;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public static ArrayList<String> getFileNames() {

        ArrayList<String> string = new ArrayList<>();

        File directory = new File(Document.folderPath);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        string.add(file.getName());
                    }
                }
            }
        }

        return string;
    }
    public static ArrayList<File> getFiles() {
        File directory = new File(Document.folderPath);
        ArrayList<File> files = new ArrayList<>();
        if (directory.isDirectory()) {
             files = new ArrayList<>(List.of(directory.listFiles()));
        }

        return files;
    }


}
