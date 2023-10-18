package dima;

import dima.commands.Command;
import dima.commands.CommitCommand;
import dima.commands.InfoCommand;
import dima.commands.StatusCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String nextCommand = "";

        FolderMonitor fileMonitor = new FolderMonitor();
        fileMonitor.startFileMonitoring();

        while (!Objects.equals(nextCommand, "q")) {
            MenuMessages.printMainCommands();
            nextCommand = scanner.nextLine();
            ArrayList<String> parsedCommand = parseCommand(nextCommand);
            Command command;

            switch (parsedCommand.get(0)) {
                case "commit":
                    command = new CommitCommand();
                    command.invoke();
                    break;
                case "info":
                    if (parsedCommand.size() == 2) {
                        command = new InfoCommand(parsedCommand.get(1));
                        command.invoke();
                    } else {
                        System.out.println("Incorrect number of parameters");
                    }
                    break;
                case "status":
                    command = new StatusCommand();
                    command.invoke();
                    break;
                case "q":
                    System.exit(0);

                    break;
                default:
                    System.out.println("Unknown command!");
                    break;
            }
        }

        System.out.println("Exit");
        scanner.close();
    }

    public static ArrayList<String> parseCommand(String input) {
        String[] str = input.split(" ");

        return new ArrayList<>(List.of(str));
    }
}