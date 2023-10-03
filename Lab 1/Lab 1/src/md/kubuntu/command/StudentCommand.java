package md.kubuntu.command;

import md.kubuntu.Main;
import md.kubuntu.Menu;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class StudentCommand {


    public static void start(Scanner scanner) {

        String nextCommand = null;

        while (!Objects.equals(nextCommand, "b")) {

            Menu.printStudentCommand();
            nextCommand = scanner.nextLine();
            ArrayList<String> parsedCommand = Main.parseCommand(nextCommand);

            if (parsedCommand.get(0).equals("q")) {
                System.exit(0);
            } else {
                System.out.println("Unknown command!");
            }
        }
    }
}
