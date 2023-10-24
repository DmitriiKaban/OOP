package dima.commands;

import dima.entities.Commit;

public class CommitCommand implements Command {
    @Override
    public void invoke() {
        Commit.makeCommit();
        System.out.println("Commit performed!");
    }
}
