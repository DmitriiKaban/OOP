package md.kubuntu;

import md.kubuntu.model.Faculty;
import md.kubuntu.model.Student;
import md.kubuntu.model.StudyField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DataManager {

    private static ArrayList<Faculty> faculties = FileManager.loadData();

    public static void createFaculty(ArrayList<String> parsedCommand) throws Exception {

        if (parsedCommand.size() != 4) {
            System.out.println("Incorrect command");
            return;
        }

        StudyField studyField = StudyField.findStudyField(parsedCommand.get(3));
        if (studyField == null)
            throw new Exception();

        Faculty newFaculty = new Faculty(parsedCommand.get(1), parsedCommand.get(2), new ArrayList<>(), studyField);

        System.out.println("New faculty created: " + newFaculty);

        faculties.add(newFaculty);
        FileManager.saveData(faculties);
    }

    public static void searchStudent(ArrayList<String> parsedCommand) {

        if (parsedCommand.size() != 2) {
            System.out.println("Incorrect command");
            return;
        }

        try {
            String email = parsedCommand.get(1);
            boolean studentFound = false;

            for (Faculty faculty : faculties) {
                for (Student st : faculty.getStudents()) {
                    if (st.getEmail().equals(email)) {
                        studentFound = true;
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

        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Incorrect command, try one more time");
        }

    }

    public static void displayFaculties(ArrayList<String> parsedCommand) throws Exception {

        System.out.println("======Faculties======");
        if (parsedCommand.size() == 2) {
            StudyField studyField = StudyField.findStudyField(parsedCommand.get(1));

            if (studyField == null)
                throw new Exception();

            boolean facultiesByFieldPresent = false;

            for (Faculty f : faculties) {
                if (f.getStudyField().equals(studyField)) {
                    System.out.println(f);
                    facultiesByFieldPresent = true;
                }
            }

            if (!facultiesByFieldPresent)
                System.out.println("Faculty list is empty");

        } else if (parsedCommand.size() == 1) {

            if (faculties.isEmpty()) {
                System.out.println("Faculty list is empty");
            } else {
                for (Faculty f : faculties)
                    System.out.println(f);
            }
        }
        System.out.println("======Faculties======");
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

        String dateOfBirthStr = parsedCommand.get(5) + "/" + parsedCommand.get(6) + "/" + parsedCommand.get(7);
        System.out.println(dateOfBirthStr);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);

        System.out.println("after data");


        String facultyAbbreviation = parsedCommand.get(1);

        Faculty faculty = getFacultyByAbbreviation(facultyAbbreviation);
        if (faculty != null) {

            Student student = new Student(parsedCommand.get(2), parsedCommand.get(3), email, LocalDate.now()
                    , dateOfBirth, false);
            faculty.getStudents().add(student);
            FileManager.saveData(faculties);
            System.out.println("Student:" + student + ", was successfully added to the faculty " + faculty.getName());

        } else {
            System.out.println("Incorrect faculty abbreviation");
        }

    }

    public static void graduateStudent(ArrayList<String> parsedCommand) {

        if (parsedCommand.size() != 2) {
            System.out.println("Incorrect command");
            return;
        }

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

        if (params.size() != 2) {
            System.out.println("Incorrect command");
            return;
        }

        Faculty faculty = getFacultyByAbbreviation(params.get(1));
        if (faculty == null) {
            System.out.println("Incorrect abbreviation");
            return;
        }
        System.out.println("======STUDENTS from " + faculty.getName() + "======");
        for (Student st : faculty.getStudents())
            System.out.println(st);
        System.out.println("======STUDENTS from " + faculty.getName() + "======");
    }

    public static void displayGraduatedStudentsByFaculty(ArrayList<String> parsedCommand) {

        if (parsedCommand.size() != 2) {
            System.out.println("Incorrect command");
            return;
        }

        Faculty faculty = getFacultyByAbbreviation(parsedCommand.get(1));
        if (faculty == null) {
            System.out.println("Incorrect abbreviation");
            return;
        }

        System.out.println("======STUDENTS graduated from " + faculty.getName() + "======");
        for (Student st : faculty.getStudents())
            if (st.isGraduated())
                System.out.println(st);
        System.out.println("======STUDENTS graduated from " + faculty.getName() + "======");
    }

    public static void checkIfStudentIsPresentInFaculty(ArrayList<String> parsedCommand) {

        if (parsedCommand.size() != 3) {
            System.out.println("Incorrect command");
            return;
        }

        Student student = getStudentByEmail(parsedCommand.get(2));
        Faculty faculty = getFacultyByAbbreviation(parsedCommand.get(1));

        if (student != null) {
            if (faculty != null) {
                for (Student st : faculty.getStudents())
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
