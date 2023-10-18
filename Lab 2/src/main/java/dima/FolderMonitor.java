package dima;

import dima.document.Document;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FolderMonitor {
    private static final String FOLDER_PATH = Document.folderPath;

    private Set<String> currentFiles = new HashSet<>();

    public void startFileMonitoring() {
        currentFiles = listFiles();

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            Set<String> updatedFiles = listFiles();

            // Check for added files
            for (String file : updatedFiles) {
                if (!currentFiles.contains(file)) {
                    System.out.println("File added: " + file);
                }
            }

            // Check for deleted files
            for (String file : currentFiles) {
                if (!updatedFiles.contains(file)) {
                    System.out.println("File deleted: " + file);
                }
            }

            // Check for modified files (compare file modification times)
            for (String file : updatedFiles) {
                File currentFile = new File(FOLDER_PATH, file);
                long currentTimeMillis = System.currentTimeMillis();
//
//                long lastModifiedMillis = file.lastModified();
//                Instant instant = Instant.ofEpochMilli(lastModifiedMillis);
//
//                LocalDateTime newFileDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
//
//                if (newFileDateTime.isAfter(lastCommitTime)) {
//                    modifiedFiles.add(f);
//                }

                if (currentFile.exists()
                        && currentTimeMillis - currentFile.lastModified() <= 5000) {
                    System.out.println("File modified: " + file);
                }
                System.out.println(currentTimeMillis - currentFile.lastModified());
            }

            // Update the current file list
            currentFiles = updatedFiles;
        }, 5, 5, TimeUnit.SECONDS);
    }

    private Set<String> listFiles() {
        File folder = new File(Document.folderPath);
        String[] fileNames = folder.list();
        assert fileNames != null;
        return new HashSet<>(Arrays.asList(fileNames));
    }
}