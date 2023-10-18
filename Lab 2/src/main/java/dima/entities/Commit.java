package dima.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Commit {

    private LocalDateTime commitTime;
    private ArrayList<String> files;

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
        return commitTime + "\n" + printFiles();
    }

    private String printFiles() {
        StringBuilder string = new StringBuilder();
        for (String s: files)
            string.append(s).append("\n");

        return string.toString();
    }
}
