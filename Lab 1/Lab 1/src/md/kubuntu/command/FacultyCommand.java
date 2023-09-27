package md.kubuntu.command;

import md.kubuntu.data.DataManager;
import md.kubuntu.Main;
import md.kubuntu.Menu;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class FacultyCommand {

    public FacultyCommand() {

        Scanner scanner = new Scanner(System.in);
        String nextCommand = null;

        while (!Objects.equals(nextCommand, "b")) {

            Menu.printGeneralCommands();
            nextCommand = scanner.nextLine();
            ArrayList<String> parsedCommand = Main.parseCommand(nextCommand);

            switch (parsedCommand.get(0)) {
                case "ns":
                    try {
                        DataManager.createStudent(parsedCommand);
                    } catch (Exception e) {
                        System.out.println("Incorrect command, try one more time");
                    }
                    break;
                case "gs":
                    DataManager.graduateStudent(parsedCommand);
                    break;
                case "ds":
                    DataManager.displayAllStudentsByFaculty(parsedCommand);
                    break;
                case "dg":
                    DataManager.displayAGraduatedStudentsByFaculty(parsedCommand);
                    break;
                case "bf":
                    DataManager.checkIfStudentIsPresentInFaculty(parsedCommand);
                    break;
                case "b":
                    break;
                default:
                    System.out.println("Unknown command!");
                    break;
            }
        }

        scanner.close();

    }
}
