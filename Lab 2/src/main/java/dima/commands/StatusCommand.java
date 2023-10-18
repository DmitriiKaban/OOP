package dima.commands;

import dima.entities.Commit;
import dima.util.Util;

import java.time.Instant;
import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StatusCommand implements Command {
    @Override
    public void invoke() {

        Commit lastCommit = Util.getLatestCommit();
        LocalDateTime lastCommitTime = lastCommit.getCommitTime();
        ArrayList<String> lastCommitFiles = lastCommit.getFiles();

        ArrayList<File> currentFiles = Util.getFiles();

        Set<File> noChangeFiles = new HashSet<>();
        Set<File> modifiedFiles = new HashSet<>();
        Set<String> deletedFiles = new HashSet<>(lastCommitFiles);
        Set<File> createdFiles = new HashSet<>();

        for (File f: currentFiles) {
            if (lastCommitFiles.contains(f.getName())) {

                deletedFiles.remove(f.getName());

                long lastModifiedMillis = f.lastModified();
                Instant instant = Instant.ofEpochMilli(lastModifiedMillis);

                LocalDateTime newFileDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();

                if (newFileDateTime.isAfter(lastCommitTime)) {
                    modifiedFiles.add(f);
                } else {
                    noChangeFiles.add(f);
                }
            } else {
                createdFiles.add(f);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Last commit made at: ").append(lastCommitTime).append("\nFrom that time there are the following changes:\n");
        if (!noChangeFiles.isEmpty()) {
            stringBuilder.append("Files without changes:\n");
            for (File file: noChangeFiles) {
                stringBuilder.append(file.getName()).append("\n");
            }
        }
        if (!modifiedFiles.isEmpty()) {
            stringBuilder.append("Modified files:\n");
            for (File file: modifiedFiles) {
                stringBuilder.append(file.getName()).append("\n");
            }
        }
        if (!createdFiles.isEmpty()) {
            stringBuilder.append("Created files:\n");
            for (File file: createdFiles) {
                stringBuilder.append(file.getName()).append("\n");
            }
        }
        if (!deletedFiles.isEmpty()) {
            stringBuilder.append("Deleted files:\n");
            for (String file: deletedFiles) {
                stringBuilder.append(file).append("\n");
            }
        }

        System.out.println(stringBuilder);
    }
}
