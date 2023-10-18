package dima.commands;

import dima.util.Util;

public class CommitCommand implements Command {
    @Override
    public void invoke() {
        Util.makeCommit();
        System.out.println("Commit performed!");
    }
}
