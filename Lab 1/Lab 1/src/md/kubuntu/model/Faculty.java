package md.kubuntu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty {
    private String name;
    private String abbreviation;
    private List<Student> students;
    private StudyField studyField;

    public Faculty(String name, String abbreviation, List<Student> students, StudyField studyField) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.students = students;
        this.studyField = studyField;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public List<Student> getStudents() {
        return students;
    }

    public StudyField getStudyField() {
        return studyField;
    }

    @Override
    public String toString() {
        return "Faculty name: " + name + "(" + abbreviation + "), study field: " + studyField;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) && Objects.equals(abbreviation, faculty.abbreviation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, abbreviation, studyField);
    }

    public void removeStudent(Student st) {
        students.remove(st);
    }

    public void addStudents(ArrayList<Student> newStudents) {
        students.addAll(newStudents);
    }

    public void setStudents(ArrayList<Student> studentToSave) {
        this.students = studentToSave;
    }
}
