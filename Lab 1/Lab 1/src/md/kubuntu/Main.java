package md.kubuntu;

import md.kubuntu.command.FacultyCommand;
import md.kubuntu.command.GeneralCommand;
import md.kubuntu.command.StudentCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final Logger logger = new Logger();
        logger.log("App started");

        Scanner scanner = new Scanner(System.in);
        String nextCommand = "";

        while (!Objects.equals(nextCommand, "q")) {
            MenuMessages.printMainCommands();
            nextCommand = scanner.nextLine();
            ArrayList<String> parsedCommand = parseCommand(nextCommand);

            switch (parsedCommand.get(0)) {
                case "g":
                    GeneralCommand.start(scanner);
                    break;
                case "f":
                    FacultyCommand.start(scanner);
                    break;
                case "s":
                    StudentCommand.start(scanner);
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
        String[] str = input.split("/");

        return new ArrayList<>(List.of(str));
    }
}
