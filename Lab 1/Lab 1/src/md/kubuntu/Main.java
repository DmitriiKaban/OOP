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

        Scanner scanner = new Scanner(System.in);
        String nextCommand = null;

        while (!Objects.equals(nextCommand, "q")) {
            Menu.printMainCommands();
            nextCommand = scanner.nextLine();
            ArrayList<String> parsedCommand = parseCommand(nextCommand);

            switch (parsedCommand.get(0)) {
                case "g":
                    new GeneralCommand(scanner);
                    break;
                case "f":
                    new FacultyCommand(scanner);
                    break;
                case "s":
                    new StudentCommand(scanner);
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
