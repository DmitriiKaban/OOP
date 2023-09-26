import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DataManager dataManager = new DataManager(FileManager.loadData());

        // close scanner
        Scanner scanner = new Scanner(System.in);
        String nextCommand = null;

        // TODO: meaningful condition
        while (!Objects.equals(nextCommand, "q")) {
            Menu.printMainCommands();
            nextCommand = scanner.nextLine();
            ArrayList<String> parsedCommand = parseCommand(nextCommand);

            switch (parsedCommand.get(0)) {
                case "g":
                    break;
                case "f":
                    break;
                case "s":
                    break;
                case "q":
                    break;
                default:
                    System.out.println("Unknown command!");
                    break;
            }
        }

        System.out.println("Exit");
        scanner.close();
    }

    private static ArrayList<String> parseCommand(String input) {
        String[] str = input.split("/");

        return new ArrayList<>(List.of(str));
    }
}
