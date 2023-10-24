package dima.entities;

import dima.util.Util;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Commit {

    private final LocalDateTime commitTime;
    private final ArrayList<String> files;

    public Commit(LocalDateTime commitTime, ArrayList<String> files) {
        this.commitTime = commitTime;
        this.files = files;
    }

    public LocalDateTime getCommitTime() {
        return commitTime;
    }

    public ArrayList<String> getFiles() {
        return files;
    }

    @Override
    public String toString() {
        return "Created snapshot at: " + commitTime + "\n" + printFiles();
    }

    private String printFiles() {
        StringBuilder string = new StringBuilder();
        for (String s: files)
            string.append(s).append("\n");

        return string.toString();
    }


    public static void makeCommit() {

        Commit commit = new Commit(LocalDateTime.now(), Util.getFileNames());

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
}
