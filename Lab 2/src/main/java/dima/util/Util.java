package dima.util;

import dima.document.Document;
import dima.entities.Commit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

public class Util {
    public static void makeCommit() {
        Commit commit = new Commit(localDateTimeToFileTime(LocalDateTime.now()), getFiles());
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

    public static FileTime localDateTimeToFileTime(LocalDateTime localDateTime) {

        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();

        return FileTime.from(instant);
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
