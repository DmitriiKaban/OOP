package dima.entities;

import java.nio.file.attribute.FileTime;
import java.util.ArrayList;

public class Commit {

    private FileTime commitTime;
    private ArrayList<String> files;

    public Commit(FileTime commitTime, ArrayList<String> files) {
        this.commitTime = commitTime;
        this.files = files;
    }

    public FileTime getCommitTime() {
        return commitTime;
    }

    public ArrayList<String> getFiles() {
        return files;
    }

    @Override
    public String toString() {
        return commitTime + printFiles();
    }

    private String printFiles() {
        StringBuilder string = new StringBuilder();
        for (String s: files)
            string.append(s).append("\n");

        return string.toString();
    }
}
