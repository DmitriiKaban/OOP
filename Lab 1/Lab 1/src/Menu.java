public class Menu {

    public static void printMainCommands() {
        System.out.println("Welcome to TUM's student management system!\n\n"
                + "What do you want to do?\n"
                + "g - General operations\n"
                + "f - Faculty operations\n"
                + "s - Student operations\n\n"
                + "q - Quit program\n"
                + "your input> ");
    }

    public static void printFacultyCommands() {
        System.out.println("Faculty operations\n"
                + "What do you want to do?\n\n"
                + "ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year> - create student\n"
                + "gs/<email> - graduate student\n"
                + "ds/<faculty abbreviation> - display enrolled students\n"
                + "dg/<faculty abbreviation> - display graduated students\n"
                + "bf/<faculty abbreviation>/<email> - check if student belongs to faculty\n\n"
                + "b - Back\n"
                + "q - Quit Program");
    }

    public static void printGeneralCommands() {
        System.out.println("General operations\n"
                + "What do you want to do?\n\n"
                + "nf/<faculty name>/<faculty abbreviation>/<field> - create faculty\n"
                + "ss/<student email> - search student and show faculty\n"
                + "df - display faculties\n"
                + "df/field - display all faculties of a field\n\n"
                + "b - Back\n"
                + "q - Quit Program");
    }

    public static void printStudentCommand() {
        System.out.println("Student operations\n"
                + "What do you want to do?\n\n"
                + "No options available at the moment.\n\n"
                + "b - Back\n"
                + "q - Quit Program");
    }
}
