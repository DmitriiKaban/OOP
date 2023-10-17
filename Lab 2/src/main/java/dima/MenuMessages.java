package dima;

public class MenuMessages {

    public static void printMainCommands() {
        System.out.println("""
                Welcome to DimaGit
                What do you want to do?
                commit - update previous snapshot
                info <filename> - general info about the file
                status - show all the changes in the folder

                q - Quit program
                your input>\s""");
    }
}
