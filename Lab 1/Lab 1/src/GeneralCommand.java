import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class GeneralCommand {

    public GeneralCommand() {

        Scanner scanner = new Scanner(System.in);
        String nextCommand = null;

        while (!Objects.equals(nextCommand, "b")) {

            Menu.printGeneralCommands();
            nextCommand = scanner.nextLine();
            ArrayList<String> parsedCommand = Main.parseCommand(nextCommand);

            switch (parsedCommand.get(0)) {
                case "nf":
                    try {
                        DataManager.createFaculty(parsedCommand);
                    } catch (Exception e) {
                        System.out.println("Incorrect command, try one more time");
                    }
                    break;
                case "ss":
                    DataManager.searchStudent(parsedCommand);
                    break;
                case "df":
                    try {
                        DataManager.displayFaculties(parsedCommand);
                    } catch (Exception e) {
                        System.out.println("Incorrect command, try one more time");
                    }
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
