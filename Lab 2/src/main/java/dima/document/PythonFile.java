package dima.document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PythonFile extends Document{
    public PythonFile(String fileName) throws IOException {
        super(fileName);
    }


    public int getLineCount() {
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(folderPath))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            System.err.println("Error while reading the file: " + e.getMessage());
        }

        return lineCount;
    }

    public int getClassCount() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(folderPath))) {
            int classCount = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("class") && line.contains(":")) {
                    System.out.println(line);
                    classCount++;
                }
            }

            return classCount;
        }
    }

    public int getMethodCount() throws IOException {
        int methodCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(folderPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("def ") && line.endsWith(":") && !line.contains("class")) {
                    methodCount++;
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
