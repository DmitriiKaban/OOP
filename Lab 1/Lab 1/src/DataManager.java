import model.Faculty;
import model.Student;
import model.StudyField;

import java.util.ArrayList;

public class DataManager {

    private static ArrayList<Faculty> faculties = FileManager.loadData();


    public static void getStudents() {
        System.out.println("Hi, We Are Students");
    }


    public static void createFaculty(ArrayList<String> parsedCommand) throws Exception {

        StudyField studyField = StudyField.findStudyField(parsedCommand.get(3));
        if (studyField == null)
            throw new Exception();

        Faculty newFaculty = new Faculty(parsedCommand.get(1), parsedCommand.get(2), new ArrayList<>(), studyField);

        System.out.println("New faculty created: " + newFaculty);

        faculties.add(newFaculty);
        FileManager.saveData(faculties);
    }

    public static void searchStudent(ArrayList<String> parsedCommand) {

        try {
            String email = parsedCommand.get(1);
            boolean studentFound = false;

            for (Faculty faculty : faculties) {
                for (Student st : faculty.getStudents()) {
                    if (st.getEmail().equals(email)) {
                        System.out.println("Student with email " + email + " is present in the faculty:" + faculty);
                    }
                    if (studentFound)
                        break;
                }
                if (studentFound)
                    break;
            }

            if (!studentFound)
                System.out.println("Student with email " + email + " doesn't exist");

        } finally {
            System.out.println("Incorrect command, try one more time");
        }

    }

    public static void displayFaculties(ArrayList<String> params) throws Exception {

        if (params.size() > 1) {
            StudyField studyField = StudyField.findStudyField(params.get(1));

            if (studyField == null)
                throw new Exception();

            for (Faculty f : faculties) {
                if (f.getStudyField().equals(studyField))
                    System.out.println(f);
            }
        } else {
            for (Faculty f : faculties)
                System.out.println(f);

        }
    }
}
