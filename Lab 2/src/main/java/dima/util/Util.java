package dima.util;

import dima.document.Document;
import dima.entities.Commit;

import java.io.*;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Util {
    public static void makeCommit() {
        Commit commit = new Commit(LocalDateTime.now(), getFiles());
        saveCommit(commit);
    }

    private static void saveCommit(Commit commit) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("commit.txt"))) {

            writer.write(commit.getCommitTime().toString());
            writer.newLine();

            for (String file : commit.getFiles()) {
                writer.write(file);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Commit getLatestCommit() {
        Commit latestCommit = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("commit.txt"))) {
            String line;
            ArrayList<String> files = new ArrayList<>();
            LocalDateTime commitTime = null;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");

            while ((line = reader.readLine()) != null) {
                if (commitTime == null) {
                    // Parse the commit time with the formatter
                    commitTime = LocalDateTime.parse(line, formatter);
                } else {
                    files.add(line);
                }
            }

            if (commitTime != null) {
                latestCommit = new Commit(commitTime, files);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return latestCommit;
    }

    public static ArrayList<String> getFiles() {

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
}
