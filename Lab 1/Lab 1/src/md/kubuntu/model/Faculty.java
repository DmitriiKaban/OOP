package md.kubuntu.model;

import java.util.List;

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
}
