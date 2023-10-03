package md.kubuntu.data;

import md.kubuntu.Logger;
import md.kubuntu.model.Faculty;
import md.kubuntu.model.Student;
import md.kubuntu.model.StudyField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DataManager {

    private static final ArrayList<Faculty> faculties = FileManager.loadData();
    private static final Logger logger = new Logger();

    public static void createFaculty(ArrayList<String> parsedCommand) {

        if (parsedCommand.size() != 4) {
            System.out.println("Incorrect number of parameters");
            return;
        }

        StudyField studyField = StudyField.findStudyField(parsedCommand.get(3));
        if (studyField == null){
            System.out.println(
                    "No such study field: " + parsedCommand.get(3) + " try one more time\n" +
                    "Select from the following list: MECHANICAL_ENGINEERING, SOFTWARE_ENGINEERING, FOOD_TECHNOLOGY, URBANISM_ARCHITECTURE, VETERINARY_MEDICINE"
            );
            logger.log("Error while creating new faculty: no such study field: " + parsedCommand.get(3));
            return;
        }
        String abbreviation = parsedCommand.get(2);
        String facultyName = parsedCommand.get(1);
        if (getFacultyByAbbreviation(abbreviation) != null) {
            System.out.println("Faculty with abbreviation " + abbreviation + " already exists!");
            logger.log("Error while creating new faculty: faculty with abbreviation " + abbreviation + " already exists!");
            return;
        }
        if (getFacultyByAbbreviation(facultyName) != null) {
            System.out.println("Faculty with name " + facultyName + " already exists!");
            logger.log("Error while creating new faculty: faculty with name " + facultyName + " already exists!");
            return;
        }

        Faculty newFaculty = new Faculty(facultyName, abbreviation, new ArrayList<>(), studyField);
        logger.log("Created a new faculty: " + newFaculty);

        System.out.println("New faculty created: " + newFaculty);

        faculties.add(newFaculty);
        FileManager.saveData(faculties);
    }

    public static void searchStudent(ArrayList<String> parsedCommand) {

        if (parsedCommand.size() != 2) {
            System.out.println("Incorrect number of parameters");
            return;
        }

        try {
            String email = parsedCommand.get(1);
            boolean studentFound = false;

            for (Faculty faculty : faculties) {
                for (Student st : faculty.getStudents()) {
                    if (st.getEmail().equals(email)) {
                        studentFound = true;
                        System.out.println("Student with email " + email + " is present in the faculty:" + faculty.getName());
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

    public static void displayFaculties(ArrayList<String> parsedCommand) {

        StringBuilder facultiesString = new StringBuilder();
        if (parsedCommand.size() == 2) {
            StudyField studyField = StudyField.findStudyField(parsedCommand.get(1));

            if (studyField == null){
                System.out.println("No such study field: " + parsedCommand.get(1));
                return;
            }

            boolean facultiesByFieldPresent = false;

            for (Faculty f : faculties) {
                if (f.getStudyField().equals(studyField)) {
                    facultiesString.append(f);
                    facultiesString.append('\n');
                    facultiesByFieldPresent = true;
                }
            }

            if (!facultiesByFieldPresent)
                System.out.println("Faculty list is empty");
            else {
                System.out.println("======Faculties======");
                System.out.print(facultiesString);
                System.out.println("======Faculties======");

            }

        } else if (parsedCommand.size() == 1) {

            if (faculties.isEmpty()) {
                System.out.println("Faculty list is empty");
            } else {
                for (Faculty f : faculties) {
                    facultiesString.append(f);
                    facultiesString.append('\n');
                }

                System.out.println("======Faculties======");
                System.out.print(facultiesString);
                System.out.println("======Faculties======");
            }
        }
    }

    public static void createStudent(ArrayList<String> parsedCommand) {

        if (parsedCommand.size() != 8) {
            System.out.println("Incorrect number of parameters");
            return;
        }

        String email = parsedCommand.get(4);

        if (getStudentByEmail(email) != null) {
            System.out.println("Email is already taken, try another one");
            logger.log("Error while creating new student: email " + email + " already exists!");
            return;
        }

        String dateOfBirthStr = parsedCommand.get(5) + "/" + parsedCommand.get(6) + "/" + parsedCommand.get(7);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);

        String facultyAbbreviation = parsedCommand.get(1);

        Faculty faculty = getFacultyByAbbreviation(facultyAbbreviation);
        if (faculty != null) {

            Student student = new Student(parsedCommand.get(2), parsedCommand.get(3), email, LocalDate.now()
                    , dateOfBirth, false);

            faculty.addStudent(student);
            FileManager.saveData(faculties);
            System.out.println("Student:" + student + ", was successfully added to the faculty " + faculty.getName());
            logger.log("Student:" + student + ", was added to the faculty " + faculty.getName());

        } else {
            System.out.println("Incorrect faculty abbreviation");
        }

    }

    public static void graduateStudent(ArrayList<String> parsedCommand) {

        if (parsedCommand.size() != 2) {
            System.out.println("Incorrect number of parameters for the command " + parsedCommand.get(0));
            return;
        }

        String email = parsedCommand.get(1);
        Student student = getStudentByEmail(email);

        if (student == null) {
            System.out.println("Student with email " + email + " is not present");
            return;
        }

        student.setGraduated(true);
        FileManager.saveData(faculties);
        System.out.println("Student " + student.getFirstName() + " " + student.getLastName() + " is now graduated!");
        logger.log("Graduated " + student + " student");
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

    public static Faculty getFacultyByName(String name) {
        for (Faculty faculty : faculties) {
            if (faculty.getName().equalsIgnoreCase(name))
                return faculty;
        }

        return null;
    }

    public static void displayAllStudentsByFaculty(ArrayList<String> params) {

        if (params.size() != 2) {
            System.out.println("Incorrect number of parameters for the command " + params.get(0));
            return;
        }

        Faculty faculty = getFacultyByAbbreviation(params.get(1));
        if (faculty == null) {
            System.out.println("Incorrect abbreviation");
            return;
        }

        if (faculty.getStudents().isEmpty()) {
            System.out.println("No students present in the faculty");
            return;
        }

        StringBuilder stringOutput = new StringBuilder();
        stringOutput.append("======STUDENTS from ").append(faculty.getName()).append("======\n");
        System.out.println();
        for (Student st : faculty.getStudents()) {
            stringOutput.append(st);
            stringOutput.append('\n');
        }
        stringOutput.append("======STUDENTS from ").append(faculty.getName()).append("======");
        System.out.println(stringOutput);
    }

    public static void displayGraduatedStudentsByFaculty(ArrayList<String> parsedCommand) {

        if (parsedCommand.size() != 2) {
            System.out.println("Incorrect number of parameters for the command " + parsedCommand.get(0));
            return;
        }

        String abbreviation = parsedCommand.get(1);
        Faculty faculty = getFacultyByAbbreviation(abbreviation);
        if (faculty == null) {
            System.out.println("Faculty with the following abbreviation: " + abbreviation + " doesn't exist");
            return;
        }

        StringBuilder stringOutput = new StringBuilder();
        stringOutput.append("======STUDENTS graduated from ").append(faculty.getName()).append("======\n");
        boolean foundStudent = false;
        for (Student st : faculty.getStudents())
            if (st.isGraduated()) {
                stringOutput.append(st);
                stringOutput.append('\n');
                foundStudent = true;
            }
        stringOutput.append("======STUDENTS from ").append(faculty.getName()).append("======");

        if (foundStudent)
            System.out.println(stringOutput);
        else
            System.out.println("No graduated students");
    }

    public static void checkIfStudentIsPresentInFaculty(ArrayList<String> parsedCommand) {

        if (parsedCommand.size() != 3) {
            System.out.println("Incorrect number of parameters for the command " + parsedCommand.get(0));
            return;
        }

        String email = parsedCommand.get(2);
        String abbreviation = parsedCommand.get(2);
        Student student = getStudentByEmail(email);
        Faculty faculty = getFacultyByAbbreviation(abbreviation);

        if (student != null) {
            if (faculty != null) {
                for (Student st : faculty.getStudents())
                    if (st.equals(student)) {
                        System.out.println("Student belongs to faculty!");
                        return;
                    }
            } else {
                System.out.println("Faculty is not present");
                return;
            }
        } else {
            System.out.println("Student with email " + email + " doesn't exist");
            return;
        }

        System.out.println("Student doesn't belong to faculty");
    }

    public ArrayList<Faculty> getFaculties(){
        return this.faculties;
    }
}
