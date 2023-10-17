package dima.document;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFile extends Document{
    public TextFile(String fileName) throws IOException {
        super(fileName);
    }

    public int getLineCount() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(folderPath + "/" + super.fileName));
        int lineCount = 0;

        while (reader.readLine() != null) {
            lineCount++;
        }

        reader.close();
        return lineCount;
    }

    public int getWordCount() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(folderPath + "/" + super.fileName));
        int wordCount = 0;

        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+"); // Split by one or more spaces
            wordCount += words.length;
        }

        reader.close();

        return wordCount;
    }

    public int getCharacterCount() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(folderPath + "/" + super.fileName));
        int charCount = 0;
        int c;
        while ((c = reader.read()) != -1) {
            if (!Character.isWhitespace((char) c)) {
                charCount++;
            }
        }

        reader.close();
        return charCount;
    }

    public void printBasicInfo() throws IOException {
        super.printBasicInfo();
        System.out.println("Number of lines: " + getLineCount());;
        System.out.println("Number of words: " + getWordCount());;
        System.out.println("Number of characters: " + getCharacterCount());;
    }
}
