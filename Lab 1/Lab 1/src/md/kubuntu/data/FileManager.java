package md.kubuntu.data;

import java.io.*;
import md.kubuntu.model.Faculty;
import md.kubuntu.model.Student;
import md.kubuntu.model.StudyField;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String FILE_NAME = "university.txt";

    public static void saveData(ArrayList<Faculty> faculties) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Faculty faculty : faculties) {

                writer.write("Faculty: " + faculty.getName() + " (" + faculty.getAbbreviation() + "), Study Field: " + faculty.getStudyField());
                writer.newLine();

                List<Student> students = faculty.getStudents();
                for (Student student : students) {
                    writer.write("Student: " + student.getFirstName() + " " + student.getLastName());
                    writer.newLine();
                    writer.write("Email: " + student.getEmail());
                    writer.newLine();
                    writer.write("Enrollment Date: " + student.getEnrollmentDate());
                    writer.newLine();
                    writer.write("Date of Birth: " + student.getDateOfBirth());
                    writer.newLine();
                    writer.write("Graduated: " + (student.isGraduated() ? "Yes" : "No"));
                    writer.newLine();
                }

                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    public static ArrayList<Faculty> loadData() {

        ArrayList<Faculty> faculties = new ArrayList<>();
        Faculty currentFaculty = null;
        Student currentStudent;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Faculty: ")) {

                    String facultyInfo = line.substring("Faculty: ".length());
                    String[] facultyData = facultyInfo.split(" \\(");
                    String facultyName = facultyData[0];
                    String facultyAbbreviation = facultyData[1].split("\\), Study Field: ")[0];
                    String studyFieldStr = facultyData[1].split("\\), Study Field: ")[1];
                    StudyField studyField = StudyField.findStudyField(studyFieldStr);


                    currentFaculty = new Faculty(facultyName, facultyAbbreviation, new ArrayList<>(), studyField);
                    faculties.add(currentFaculty);
                } else if (line.startsWith("Student: ")) {

                    String studentName = line.substring("Student: ".length());
                    String email = reader.readLine().substring("Email: ".length());
                    LocalDate enrollmentDate = LocalDate.parse(reader.readLine().substring("Enrollment Date: ".length()));
                    LocalDate dateOfBirth = LocalDate.parse(reader.readLine().substring("Date of Birth: ".length()));
                    boolean graduated = reader.readLine().substring("Graduated: ".length()).equals("Yes");


                    currentStudent = new Student(
                            studentName.split(" ")[0],
                            studentName.split(" ")[1],
                            email,
                            enrollmentDate,
                            dateOfBirth,
                            graduated
                    );

                    if (currentFaculty != null) {
                        currentFaculty.getStudents().add(currentStudent);
                    }
                }
            }


        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }

        return faculties;
    }

}