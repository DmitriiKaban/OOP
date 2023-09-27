import model.Faculty;
import model.Student;
import model.StudyField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DataManager {

    private static ArrayList<Faculty> faculties = FileManager.loadData();

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

    public static void createStudent(ArrayList<String> parsedCommand) {

        if (parsedCommand.size() != 8) {
            System.out.println("Incorrect command");
            return;
        }

        String email = parsedCommand.get(4);

        if (getStudentByEmail(email) != null) {
            System.out.println("Email is already taken, try another one");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String dateOfBirthStr = parsedCommand.get(5) + "/" + parsedCommand.get(6) + "/" + parsedCommand.get(7);
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);


        String facultyAbbreviation = parsedCommand.get(1);

        Faculty faculty = getFacultyByAbbreviation(facultyAbbreviation);
        if (faculty != null) {

            Student student = new Student(parsedCommand.get(2), parsedCommand.get(3), email, LocalDate.now()
                    , dateOfBirth, false);
            faculty.getStudents().add(student);

            System.out.println("Student:" + student + ", was successfully added to the faculty " + faculty.getName());

        } else {
            System.out.println("Incorrect faculty abbreviation");
        }

    }

    public static void graduateStudent(ArrayList<String> parsedCommand) {
        Student student = getStudentByEmail(parsedCommand.get(1));

        if (student == null) {
            System.out.println("Student with email " + parsedCommand.get(1) + " is not present");
            return;
        }

        student.setGraduated(true);
        FileManager.saveData(faculties);
        System.out.println("Student " + student + " is now graduated!");
    }

    public static Student getStudentByEmail(String email) {
        for (Faculty faculty : faculties) {
            for (Student st : faculty.getStudents()) {
                if (st.getEmail().equals(email))
                    return st;
            }
        }

        return null;
    }

    public static Faculty getFacultyByAbbreviation(String abbreviation) {
        for (Faculty faculty : faculties) {
            if (faculty.getAbbreviation().equalsIgnoreCase(abbreviation))
                return faculty;
        }

        return null;
    }

    public static void displayAllStudentsByFaculty(ArrayList<String> params) {

        if (params.size() != 2)
            System.out.println("Incorrect command");

        Faculty faculty = getFacultyByAbbreviation(params.get(1));
        if (faculty == null) {
            System.out.println("Incorrect abbreviation");
            return;
        }
        for (Student st : faculty.getStudents())
            System.out.println(st);
    }

    public static void displayAGraduatedStudentsByFaculty(ArrayList<String> parsedCommand) {

        if (parsedCommand.size() != 2)
            System.out.println("Incorrect command");

        Faculty faculty = getFacultyByAbbreviation(parsedCommand.get(1));
        if (faculty == null) {
            System.out.println("Incorrect abbreviation");
            return;
        }

        for (Student st : faculty.getStudents())
            if (st.isGraduated())
                System.out.println(st);
    }

    public static void checkIfStudentIsPresentInFaculty(ArrayList<String> parsedCommand) {
        Student student = getStudentByEmail(parsedCommand.get(2));
        Faculty faculty = getFacultyByAbbreviation(parsedCommand.get(1));

        if (student != null) {
            if (faculty != null){
                for (Student st: faculty.getStudents())
                    if (st.equals(student)) {
                        System.out.println("Student belongs to faculty!");
                        return;
                    }
            } else {
                System.out.println("Faculty is not present");
            }
        } else {
            System.out.println("Email is not found");
        }

        System.out.println("Student doesn't belong to faculty");

    }
}
