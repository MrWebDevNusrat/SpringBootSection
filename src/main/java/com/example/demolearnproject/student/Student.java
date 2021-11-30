package com.example.demolearnproject.student;

public class Student {
    private final Integer sudentId;
    private final String studentName;

    public Student(Integer sudentId,
                   String studentName) {
        this.sudentId = sudentId;
        this.studentName = studentName;
    }

    public Integer getSudentId() {
        return sudentId;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sudentId=" + sudentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
