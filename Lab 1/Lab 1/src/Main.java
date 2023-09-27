import java.io.IOException;
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
                    new GeneralCommand();
                    break;
                case "f":
                    new FacultyCommand();
                    break;
                case "s":
                    new StudentCommand();
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

    static ArrayList<String> parseCommand(String input) {
        String[] str = input.split("/");

        return new ArrayList<>(List.of(str));
    }
}
