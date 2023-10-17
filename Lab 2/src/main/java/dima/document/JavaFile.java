package dima.document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaFile extends Document{
    public JavaFile(String fileName) throws IOException {
        super(fileName);
    }

    public int getLineCount() throws IOException {
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(folderPath + "/" + super.fileName))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            System.err.println("Error while reading the file: " + e.getMessage());
        }

        return lineCount;
    }

    public int getClassCount() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(folderPath + "/" + super.fileName))) {
            int classCount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                line.replace("(", " ").replace(")", " ");
                String[] splittedLine = line.split(" ");
                if (!line.startsWith("//")) {
                    if ((splittedLine[0].equals("public") || splittedLine[0].equals("private") || splittedLine[0].equals("protected")) && (splittedLine[1].equals("class") || splittedLine[1].equals("interface") || (splittedLine[1].equals("abstract") && splittedLine[2].equals("class")))) {
//                        System.out.println(line);
                        classCount++;
                    }
                }
            }
            return classCount;
        }
    }

    public int getMethodCount() throws IOException {
        int methodCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(folderPath + "/" + super.fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                line.replace("(", " ").replace(")", " ");
                String[] splittedLine = line.split(" ");
                if (!line.startsWith("//")) {
                    if (splittedLine.length >= 3 &&
                            (splittedLine[0].equals("public") || splittedLine[0].equals("private") || splittedLine[0].equals("protected")) &&
                            !splittedLine[1].equals("class") && !splittedLine[1].equals("interface") && !splittedLine[1].equals("abstract") && line.contains("(")) {
//                        System.out.println(line);
                        methodCount++;
                    }
                }
            }
        }

        return methodCount;
    }

    public void printBasicInfo() throws IOException {
        StringBuilder string = new StringBuilder();
        string.append("File name: ").append(getFileName()).append("\n");
        string.append("File extension: ").append(getFileExtension()).append("\n");
        string.append("File created at ").append(getCreationTime()).append("\n");
        string.append("File updated at ").append(getLastUpdateTime()).append("\n");
        string.append("Number of lines: ").append(getLineCount()).append("\n");
        string.append("Number of classes: ").append(getClassCount()).append("\n");
        string.append("Number of methods: ").append(getMethodCount()).append("\n");

        System.out.println(string);
    }
}
