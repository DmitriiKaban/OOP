package md.kubuntu.command;

import md.kubuntu.Main;
import md.kubuntu.MenuMessages;
import md.kubuntu.data.DataManager;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class StudentCommand {

    public static void start(Scanner scanner) {

        String nextCommand = null;

        while (!Objects.equals(nextCommand, "b")) {

            MenuMessages.printStudentCommand();
            nextCommand = scanner.nextLine();
            ArrayList<String> parsedCommand = Main.parseCommand(nextCommand);

            switch (parsedCommand.get(0)) {
                case "ba":
                    DataManager.batchAddStudents(parsedCommand);
                    break;
                case "b":
                    break;
                case "q":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unknown command!");
                    break;
            }
        }


    }
}
