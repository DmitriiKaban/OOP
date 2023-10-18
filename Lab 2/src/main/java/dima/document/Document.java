package dima.document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public abstract class Document {
    public static final String folderPath = "C:/Users/Valeria/IdeaProjects/OOP/Lab 2/src/main/resources/FolderManagedByDimaGIT";
    public String fileName;
    public FileTime creationDate;
    public FileTime updateDate;

    public Document(String fileName) throws IOException {
        this.fileName = fileName;
        this.creationDate = getCreationTime();
        this.updateDate = getLastUpdateTime();
    }

    public String getFileName() {
        return fileName.substring(0, fileName.indexOf("."));
    }

    public String getFileExtension() {
        return fileName.substring(fileName.indexOf(".") + 1);
    }

    public FileTime getCreationTime() throws IOException {
        BasicFileAttributes attributes = Files.readAttributes(getFolderPath(), BasicFileAttributes.class);
        return attributes.creationTime();
    }

    public FileTime getLastUpdateTime() throws IOException {
        BasicFileAttributes attributes = Files.readAttributes(getFolderPath(), BasicFileAttributes.class);
        return attributes.lastModifiedTime();
    }

    public Path getFolderPath() {
        return Paths.get(folderPath + "/" + this.fileName);
    }

    public void printBasicInfo() throws IOException {
        System.out.println("Unknown file");
        System.out.println("File name: " + getFileName()
            + "\nFile extension: " + getFileExtension()
            + "\nDate created: " + getCreationTime()
            + "\nDate last update: " + getLastUpdateTime());
    }

}
