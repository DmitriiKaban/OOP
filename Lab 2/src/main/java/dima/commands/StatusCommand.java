package dima.commands;

import dima.util.Util;

public class StatusCommand implements Command {
    @Override
    public void invoke() {
        System.out.println(Util.getLatestCommit());
    }
}
