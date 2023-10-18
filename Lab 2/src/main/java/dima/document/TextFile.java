package dima.document;

import java.io.BufferedReader;
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
            String[] words = line.split("\\W+"); // Split by non-word characters
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount++;
                }
            }
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

    public StringBuilder getBasicInfo() throws IOException {
        StringBuilder string = super.getBasicInfo();
        string.append("\nNumber of lines: ").append(getLineCount());
        string.append("\nNumber of words: ").append(getWordCount());
        string.append("\nNumber of characters: ").append(getCharacterCount());

        return string;
    }
}
