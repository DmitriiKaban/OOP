package model;

import java.time.LocalDate;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate enrollmentDate;
    private LocalDate dateOfBirth;
    private boolean hasGraduated;

    public Student(String firstName, String lastName, String email, LocalDate enrollmentDate, LocalDate dateOfBirth, boolean hasGraduated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
        this.dateOfBirth = dateOfBirth;
        this.hasGraduated = hasGraduated;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isGraduated() {
        return hasGraduated;
    }

    public void setGraduated(boolean b) {
        this.hasGraduated = b;
    }
}
